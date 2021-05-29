package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
                loginUser(loginText, passwordText);
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

    private void loginUser(String loginText, String passwordText) {

    }
}
