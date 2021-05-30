package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientSignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button exitToMainButton;

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
                inButton.getScene().getWindow().hide();
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
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        exitToMainButton.setOnAction(event -> {
            exitToMainButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/sample.fxml"));
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