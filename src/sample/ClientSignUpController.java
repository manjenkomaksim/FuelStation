package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ClientSignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button inButton;

    @FXML
    private TextField cardNumberField;

    @FXML
    private TextField typeOfFuelField;

    @FXML
    private PasswordField clientSignUpPasswordField;

    @FXML
    private TextField clientSignUpLoginField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField phoneNumberField;


    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        inButton.setOnAction(event -> {
            try {
                dbHandler.signUpClient(fullNameField.getText(), phoneNumberField.getText(), cardNumberField.getText(),
                        typeOfFuelField.getText(), clientSignUpLoginField.getText(), clientSignUpPasswordField.getText());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });


    }

}