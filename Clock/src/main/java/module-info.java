module com.example.clock {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clock to javafx.fxml;
    exports com.example.clock;
}