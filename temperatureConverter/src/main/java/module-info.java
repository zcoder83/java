module com.example.temperatureconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temperatureconverter to javafx.fxml;
    exports com.example.temperatureconverter;
}