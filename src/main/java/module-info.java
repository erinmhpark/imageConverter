module com.example.imagemanagementtool_finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.imagemanagementtool_finalproject to javafx.fxml;
    exports com.example.imagemanagementtool_finalproject;
}