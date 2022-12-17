package com.example.imagemanagementtool_finalproject;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

    /**
     * This class implements the ButtonContainerInterface and provides a method to get a HBox container,
     * based on a given type (either "filter" or "fileLoader").
     * If the given type is not one of the two specified, it throws an exception.
     */
public class ButtonContainer implements ButtonContainerInterface {
    ButtonContainerAdapter containerAdapter;

    @Override
    public HBox getContainer(String type, double spacing, Pos position, Stage primaryStage) throws Exception {
        if (!type.equals("filter") && !type.equals("fileLoader")) {
            throw new Exception("Container type is invalid.");
        }
        containerAdapter = new ButtonContainerAdapter(type, spacing, position, primaryStage);
        return containerAdapter.getButtonContainer();
    }
}
