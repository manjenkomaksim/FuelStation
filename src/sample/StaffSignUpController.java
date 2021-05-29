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

        inButton.setOnAction(event -> {
            try {
                signUpNewStaff();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    public void signUpNewStaff() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String fullname = fullNameField.getText();
        String phonenumber = phoneNumberField.getText();
        String address = addressField.getText();
        String duty = dutyField.getText();
        String login = signUpLoginField.getText();
        String password = signUpPasswordField.getText();

        Staff staff = new Staff(fullname, phonenumber, address, duty, login, password);

        dbHandler.signUpStaff(staff);
    }
}
