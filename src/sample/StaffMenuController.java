package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StaffMenuController {

    @FXML
    private Button exitToMainButton;

    @FXML
    private Button addNewFuelButton;

    @FXML
    private Button getStaffListButton;

    @FXML
    private Button getClientByFuelButton;

    @FXML
    void initialize() {
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
            stage.show();
        });

        addNewFuelButton.setOnAction(event -> {
            addNewFuelButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/addingNewFuel.fxml"));
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