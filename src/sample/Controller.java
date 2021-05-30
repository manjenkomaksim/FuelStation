package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signInLoginField;

    @FXML
    private Button mainSignUpButton;

    @FXML
    private Button mainSignInButton;

    @FXML
    private PasswordField signInPasswordField;

    @FXML
    void initialize() {

        mainSignInButton.setOnAction(event -> {
            String loginText = signInLoginField.getText().trim();
            String passwordText = signInPasswordField.getText().trim();

            if(!loginText.equals("") && !(passwordText.equals(""))){
                try {
                    loginUser(loginText, passwordText);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else
                System.out.println("Field is empty");
        });

        mainSignUpButton.setOnAction(event -> {
            mainSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/signUp.fxml"));

            try {
                loader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("MyFuelStation");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String passwordText) throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Client client = new Client();
        client.setLogin(loginText);
        client.setPassword(passwordText);
        ResultSet resultSet = dbHandler.getClient(client);
        int clientCounter = 0;
        while (resultSet.next()){
            clientCounter++;
        }
        if(clientCounter>=1){
            mainSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/clientMenu.fxml"));

            try {
                loader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("MyFuelStation");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }

        else {
            Staff staff = new Staff();
            staff.setLogin(loginText);
            staff.setPassword(passwordText);
            ResultSet staffResultSet = dbHandler.getStaff(staff);
            int staffCounter = 0;
            while (staffResultSet.next()){
                staffCounter++;
            }
            if (staffCounter>=1){
                mainSignUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../UI/staffMenu.fxml"));

                try {
                    loader.load();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("MyFuelStation");
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
            else{
                Shake userLoginAnim = new Shake(signInLoginField);
                Shake userPasswordAnim = new Shake(signInPasswordField);
                userLoginAnim.playAnim();
                userPasswordAnim.playAnim();
                signInLoginField.clear();
                signInPasswordField.clear();
            }


        }

    }
}
