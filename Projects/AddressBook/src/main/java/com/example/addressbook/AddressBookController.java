package com.example.addressbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private TableView<User> table;

    @FXML
    private TableColumn<User, String> tbEmail;

    @FXML
    private TableColumn<User, String> tbName;

    @FXML
    private TableColumn<User, Integer> tbId;

    @FXML
    private TableColumn<User, String> tbPhone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPhone;

    @FXML
    void createUserOnAction(ActionEvent event) {
        String errorMsg = "";
        if(tfName.getText().isBlank() || tfPhone.getText().isBlank() || tfEmail.getText().isBlank()) {
            btnMessage.setText("All fields required!!!");
            return;
        }
        errorMsg = validateUserInformation();
        if(errorMsg == ""){
            if (addUser())
            btnMessage.setText("Added user!!!");
            fetUsers();
        } else {
            btnMessage.setText(errorMsg);
        }
    }
    @FXML
    void deleteUserOnAction(ActionEvent event) {

    }

    @FXML
    void reloadUserOnAction(ActionEvent event) {
        fetUsers();
    }


    @FXML
    void updateUserOnAction(ActionEvent event) {

    }
    @FXML
    private Label btnMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetUsers();
    }
    public String validateUserInformation() {
        String name = tfName.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();

        String nameRegex = "^[a-zA-Z\\s]+";
        String phoneRegex = "^(\\d{3}[- .]?){2}\\d{4}$";
        String emailRegex = "^(.+)@(.+)$"; // or ^(.+)@(.+)\.(.+)$

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
    public boolean addUser(){
        Connection con = DatabaseConnection.getConnection();
        String sql = "";
        String name = tfName.getText();
        String phone = tfPhone.getText();
        String email = tfEmail.getText();
        try {
            Statement statement =con.createStatement();
            sql = "INSERT INTO users(name, phone, email) values('" + name + "', '" + phone + "' , '" + email + "')";
            statement.executeUpdate(sql);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void fetUsers(){

        String sql = "SELECT * FROM users";
        Connection con = DatabaseConnection.getConnection();
        ObservableList<User> list = FXCollections.observableArrayList();
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()) {
                User us = new User();
                us.setId(rs.getInt("id"));
                us.setName(rs.getString("name"));
                us.setEmail(rs.getString("email"));
                us.setPhone(rs.getString("phone"));
                list.add(us);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tbId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        tbName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        tbPhone.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
        tbEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));

        table.setItems(list);
    }
}
