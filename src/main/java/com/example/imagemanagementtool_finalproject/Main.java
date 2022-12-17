package com.example.imagemanagementtool_finalproject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

    /**
     * This project implemented an Adapter pattern.
     * For the JavaFX structure,
     * The Main class contains the start method which is used to create and display the user interface
     * by creating a scene and setting a title, width and height for the stage.
     * It also creates a Text object for the program title, a Vbox container for the components,
     * an ImageLoader object, a file access box and a filter box.
     * Finally, it adds the Vbox container to the root, sets the scene to the stage and shows it.
     */

public class Main extends Application {
    @Override
    public void start(final Stage primaryStage) {
        try {
            StackPane root = new StackPane();
            Scene scene = new Scene(root);

            // Create text object and style it for program title
            Text text = new Text();
            text.setText("Image Management Tool");
            text.setFill(Color.WHITESMOKE);
            text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
            text.setX(450);
            text.setY(150);

            // Create Vbox and style it
            VBox vbox = new VBox(20);
            vbox.setAlignment(Pos.CENTER);

            // Create objects to display image and buttons for loading and filtering
            ImageLoader imageLoader = new ImageLoader();
            ButtonContainer buttonContainer = new ButtonContainer();// Implement Adapter pattern here
            HBox fileLoader = buttonContainer.getContainer("fileLoader", 20, Pos.CENTER, primaryStage);
            HBox filter = buttonContainer.getContainer("filter", 20, Pos.CENTER, primaryStage);
            vbox.getChildren().addAll(text,
                    imageLoader.getImageView(),
                    imageLoader.getImagePropertyText(), fileLoader, filter);
            vbox.setBackground(new Background(new BackgroundFill(Color.rgb(17, 24, 38),CornerRadii.EMPTY, Insets.EMPTY)));

            root.getChildren().addAll(vbox);
            primaryStage.setTitle("Image Management Tool");
            primaryStage.setScene(scene);
            // Default window size
            primaryStage.setWidth(600);
            primaryStage.setHeight(500);
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}