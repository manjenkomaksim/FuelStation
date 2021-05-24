package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private Button mainSignUpButton;

    @FXML
    private TextField passwordField;

    @FXML
    private Button mainSignInButton;

    @FXML
    void initialize() {

    }
}
