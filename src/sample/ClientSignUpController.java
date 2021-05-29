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

        inButton.setOnAction(event -> {
            try {
                signUpNewClient();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    public void signUpNewClient() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String fullname = fullNameField.getText();
        String phonenumber = phoneNumberField.getText();
        String cardnumber = cardNumberField.getText();
        String fuel = typeOfFuelField.getText();
        String login = clientSignUpLoginField.getText();
        String password = clientSignUpPasswordField.getText();

        Client client = new Client(fullname, phonenumber, cardnumber, fuel, login, password);

        dbHandler.signUpClient(client);
    }

}