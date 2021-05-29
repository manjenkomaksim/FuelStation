package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clientButton;

    @FXML
    private Button staffButton;

    @FXML
    void initialize() {
        clientButton.setOnAction(event -> {
            clientButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/ClientSignUp.fxml"));

            try {
                loader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("MyFuelStation");
            stage.setScene(new Scene(root));
            stage.show();
        });

        staffButton.setOnAction(event -> {
            staffButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/StaffSignUp.fxml"));

            try {
                loader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("MyFuelStation");
            stage.setScene(new Scene(root));
            stage.show();
        });


    }
}