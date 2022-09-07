package com.example.addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class AddressBookController implements Initializable {

    static Connection con = DatabaseConnection.getConnection();
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReload;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> tbEmail;

    @FXML
    private TableColumn<?, ?> tbName;

    @FXML
    private TableColumn<?, ?> tbNo;

    @FXML
    private TableColumn<?, ?> tbPhone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhone;

    @FXML
    void createUserOnAction(ActionEvent event) {
        if(tfName.getText().isBlank() || tfPhone.getText().isBlank() || tfEmail.getText().isBlank()) {
            btnMessage.setText("All fields required!!!");

        } else {
            String result = validateUserInformation();
            if(result != null) {
                btnMessage.setText(result);
            }
        }
        btnMessage.setText("Good data!!!");
    }
    @FXML
    private Label btnMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public String validateUserInformation() {
        String name = tfName.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();

        String nameRegex = "^[a-zA-Z\\s]+";
        String phoneRegex = "^(\\d{3}[- .]?){2}\\d{4}$";
        String emailRegex = "^(.+)@(.+)$";

        String errorMsg = "";

        if(name.matches(nameRegex) == false) {
            errorMsg += "Name includes No number or special character\n";
        }
        if(phone.matches(phoneRegex) == false) {
            errorMsg += "phone number looks like 666-666-6666\n";
        }
        if(email.matches(emailRegex) == false) {
            errorMsg += "email address looks like xxx@xxx.com";
        }

        return errorMsg;
    }

}
