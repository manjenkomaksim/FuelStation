package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class StaffSignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button inButton;

    @FXML
    private TextField addressField;

    @FXML
    private TextField dutyField;

    @FXML
    private PasswordField signUpPasswordField;

    @FXML
    private TextField signUpLoginField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField phoneNumberField;


    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        inButton.setOnAction(event -> {
            try {
                dbHandler.signUpStaff(fullNameField.getText(), phoneNumberField.getText(), addressField.getText(),
                        dutyField.getText(), signUpLoginField.getText(), signUpPasswordField.getText());
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
