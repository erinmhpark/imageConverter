package com.example.imagemanagementtool_finalproject;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

    /**
     * FilterButtons class implements the ButtonController interface.
     * It provides methods to create and manage a group of color filter buttons.
     * It has an HBox ButtonContainer to contain all the filter buttons.
     */
public class FilterButtons implements ButtonController {
    HBox ButtonContainer;
    public FilterButtons(double spacing, Pos position) {
        ButtonContainer = new HBox();
        ButtonContainer.setSpacing(spacing);
        ButtonContainer.setAlignment(position);
        initButtons();
    }
    @Override
    public HBox getButtonContainer() {
        return ButtonContainer;
    }

    /**
     * initButtons() creates a list of Buttons with various image filters.
     * It sets their style and adds an event handler to each of them.
     * The Buttons are added to the ButtonContainer node.
     */
    @Override
    public void initButtons() {
        String[] filters = {"Brighten", "Shadows", "Grayscale", "Invert", "Undo"};
        for (String filter : filters) {
            Button button = new Button(filter);
            button.setStyle("-fx-background-color: #656d7a; -fx-text-fill: #F5F5F5; -fx-font-weight: bold");
            addEvent(button);
            ButtonContainer.getChildren().add(button);
      }
    }

    /**
     * addEvent() adds an event to the given button.
     * Depending on the button text,
     * it will call the method addColorFilter with a different parameter to change color.
     */
    private void addEvent(Button button) {
        button.setOnAction(event -> {
            switch (button.getText()) {
                case "Brighten":
                    adjustColor(1);
                    break;
                case "Shadows":
                    adjustColor(2);
                    break;
                case "Grayscale":
                    adjustColor(3);
                    break;
                case "Invert":
                    adjustColor(4);
                    break;
                case "Undo":
                    ImageLoader.imageView.setImage(ImageLoader.image);
                    break;
                default:
                    break;
            }
      });
    }

    /**
     * adjustColor() applies a color filter to the loaded image in the ImageLoader class.
     */
    private void adjustColor(int type) {
        try {
            PixelReader pixelReader = ImageLoader.imageView.getImage().getPixelReader();
            Image image = ImageLoader.imageView.getImage();
            WritableImage wImage = new WritableImage(
                    (int) image.getWidth(),
                    (int) image.getHeight());
            PixelWriter pixelWriter = wImage.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    Color color = pixelReader.getColor(x, y);
                    switch (type) {
                        case 1:
                            color = color.brighter();
                            break;
                        case 2:
                            color = color.darker();
                            break;
                        case 3:
                            color = color.grayscale();
                            break;
                        case 4:
                            color = color.invert();
                            break;
                        default:
                            break;
                    }
                    pixelWriter.setColor(x, y, color);
                }
            }
            ImageLoader.imageView.setImage(wImage);
        } catch (NullPointerException ne) {
            System.out.println("Please upload an image to filter a color.");
        }
    }
}