package com.example.imagemanagementtool_finalproject;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

    /**
     * FileLoaderButtons is a class that implements the ButtonController interface.
     * It is responsible for creating a FileChooser for uploading and downloading images,
     * and for initializing the UI buttons and adding an event handler to them.
     */
public class FileLoaderButtons implements ButtonController {
    HBox getButtonContainer;
    Stage primaryStage;

    public FileLoaderButtons(double spacing, Pos position, Stage primaryStage) {
        getButtonContainer = new HBox();
        getButtonContainer.setSpacing(spacing);
        getButtonContainer.setAlignment(position);
        this.primaryStage = primaryStage;
        initButtons();
    }

    @Override
    public HBox getButtonContainer() {
        return getButtonContainer;
    }

    /**
     * initButtons() method initializes the UI buttons and FileChooser for uploading and downloading images.
     * The buttons are given a style and the FileChooser is given an extension filter
     * to limit the file types that can be uploaded. An event listener is also added to the buttons.
     */
    @Override
    public void initButtons() {
        Button upload = new Button("Upload Image");
        Button download = new Button("Download Image");
        getButtonContainer.getChildren().addAll(upload, download);
        FileChooser fileChooser = new FileChooser();
        upload.setStyle("-fx-background-color: #656d7a; -fx-text-fill: #F5F5F5; -fx-font-weight: bold");
        download.setStyle("-fx-background-color: #656d7a; -fx-text-fill: #F5F5F5; -fx-font-weight: bold");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"));
        addEventHandler(upload, download, fileChooser);
    }

    /**
     * addEventHandler() adds an event handler to the upload and
     * download buttons, which use the FileChooser to select a file for uploading or downloading.
     * When a file is selected for uploading, the ImageLoader.displayImage() method is called to display the image.
     * When a file is selected for downloading, a new BufferedImage is created
     * from the ImageLoader.imageView image, and written to the file with ImageIO.write().
     */
    private void addEventHandler(Button upload, Button download, FileChooser fileChooser) {
        upload.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(primaryStage.getOwner());
            if (file != null) {
                try {
                    ImageLoader.displayImage(file, file.getAbsolutePath(), String.valueOf(new Date(file.lastModified())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Please upload an image.");
            }
        });

        download.setOnAction(event -> {
            File file = fileChooser.showSaveDialog(primaryStage.getOwner());
            if (file != null) {
                try {
                    BufferedImage image = new BufferedImage((int) ImageLoader.imageView.getImage().getWidth(),
                            (int) ImageLoader.imageView.getImage().getHeight(),
                            BufferedImage.TYPE_INT_RGB);
                    for (int x = 0; x < ImageLoader.imageView.getImage().getWidth(); x++) {
                        for (int y = 0; y < ImageLoader.imageView.getImage().getHeight(); y++) {
                            image.setRGB(x, y, ImageLoader.imageView.getImage().getPixelReader().getArgb(x, y));
                        }
                    }
                    ImageIO.write(image, "jpg", file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}