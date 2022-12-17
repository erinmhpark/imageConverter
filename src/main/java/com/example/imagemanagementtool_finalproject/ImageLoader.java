package com.example.imagemanagementtool_finalproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

    /**
     * ImageLoader class is responsible for displaying the loaded image on the screen.
     */
public class ImageLoader {
    static ImageView imageView;
    static Image image;
    static Text imagePropertyText;

    /**
     * The constructor generates imageView node to display an image object,
     * sets the image size 100x100 and creates imagePropertyText object to present
     * information about the uploaded image properties
     */
    public ImageLoader() {
        imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imagePropertyText = new Text();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Image getImage() {
        return image;
    }

    public Text getImagePropertyText() {
        return imagePropertyText;
    }

    /**
     * This method sets the image, height, width, location, and last modified of the image in the screen.
     * @param file the image file to be set in the view
     * @param location the location of the image file
     * @param lastModified the date the image file was last modified
     * @throws FileNotFoundException if the file cannot be found
     */
    static void displayImage(File file, String location, String lastModified) throws FileNotFoundException {
        image = new Image(new FileInputStream(file));
        imageView.setImage(image);
        String height = String.valueOf((int) image.getHeight());
        String width = String.valueOf((int) image.getWidth());
        imagePropertyText.setText("Height: " + height + " pixels\n"
                + "Width: " + width + " pixels\n"
                + "Location: " + location + "\n"
                + "Last modified: " + lastModified);
        imagePropertyText.setFill(Color.WHITESMOKE);

    }
}
