package com.example.imagemanagementtool_finalproject;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

    /**
     * ButtonContainerAdapter helps to provide proper button group instance for each type of containers.
     * It takes type, spacing, position, and primaryStage as parameters and
     * returns an HBox for the button container.
     */
public class ButtonContainerAdapter {
    ButtonController buttonController;
    public ButtonContainerAdapter(String type, double spacing, Pos position, Stage primaryStage) {
        switch (type) {
            case "filter":
                buttonController = new FilterButtons(spacing, position);
                break;
            case "fileLoader":
                buttonController = new FileLoaderButtons(spacing, position, primaryStage);
                break;
            default:
                System.out.println("Container type is invalid.");
        }
    }
    public HBox getButtonContainer() {
        return buttonController.getButtonContainer();
    }
}
