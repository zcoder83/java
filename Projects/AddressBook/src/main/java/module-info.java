module com.example.addressbook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.addressbook to javafx.fxml;
    exports com.example.addressbook;
}