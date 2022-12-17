package com.example.imagemanagementtool_finalproject;

import javafx.scene.layout.HBox;

    /**
     * ButtonController is for initializing and managing buttons in the program.
     * It requires two methods to be implemented: initButtons() and getButtonContainer().
     * The initButtons() method is used to initialize the buttons, while
     * getButtonContainer() is used to return a container that layouts its children in a horizontal order.
     */
public interface ButtonController {
    void initButtons();
    HBox getButtonContainer();
}

