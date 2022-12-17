package com.example.imagemanagementtool_finalproject;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

    /**
     * This interface provides a getContainer() method that returns an HBox object.
     * The parameters allow the user to specify the type of container, the spacing between elements in the container,
     * the position of the container, and the primary stage of the application.
     * And an exception is thrown if an error occurs.
     */
public interface ButtonContainerInterface {
    HBox getContainer(String type, double spacing, Pos position, Stage primaryStage) throws Exception;
}