# Image Management Tool

This Image Management Tool allows users to upload one or more image files from their desktop/laptop, and then convert the image(s) to various formats with the help of Image IO/ImageMagick/JMagick. It also provides users with the ability to apply various filters (Brighten, Shadow, Gray-scale and Invert color) to the image(s).

## Features

- Upload an image file from desktop/laptop
- Show image thumbnail (100x100)
- Show image properties (height, width, location, last modified.)
- Convert image to various formats
- Download converted images
- Apply various filters (Brighten, Shadow, Gray-scale and Invert color) to image

## Test Screenshots

[Test Screenshots(PDF)](https://github.com/erinmhpark/INFO5100_002743228_MinheePark/blob/main/imageManagementTool_FinalProject/TestScreenshots-finalProject.pdf)

## Class Diagram
[Class Diagram(PDF)](https://github.com/erinmhpark/INFO5100_002743228_MinheePark/blob/main/imageManagementTool_FinalProject/ImageManagementToolClassDiagram.pdf)

## How To Use

1. Upload an image file from your desktop/laptop.
2. View image thumbnail (100x100) and its properties (height, width, location, last modified).
3. Select which format(s) to convert the image to.
4. Download the converted image.
5. Optionally, apply various filters (color tints, black-and-white, etc.) to image.
6. Enjoy!

## Design Pattern Implementation - Adaptor Pattern

The Adapter pattern is used in the project to dynamically create different implementations of the ButtonController interface. It allows for different types of buttons to be created and placed in a container depending on the type and parameters given. The ButtonContainerAdapter class contains a switch statement to determine the type of button container to be created, and then passes the necessary parameters to the appropriate ButtonController class. Once the appropriate ButtonController is created, the getButtonContainer() method is called to return the container of buttons. This pattern allows for the code to be more flexible and easily extendable.

## Contributors:
- Minhee Park
- Kriti Sonal