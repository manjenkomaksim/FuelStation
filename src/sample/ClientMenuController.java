package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ClientMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label mostPopularFuelLabel;

    @FXML
    private Button exitToMainButton;

    @FXML
    private URL location;

    @FXML
    private Button mostPopularFuelButton;

    @FXML
    private Button averagePrice;

    @FXML
    private Label averagePriceField;

    @FXML
    private Button getStaffByDutyButton;

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

        mostPopularFuelButton.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            try {
                mostPopularFuelLabel.setText(dbHandler.getPopularFuel());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        });

        averagePrice.setOnAction((event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();

            try {
                averagePriceField.setText(Double.toString(dbHandler.getAveragePrice()) + " for 1 liter");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }));

         getStaffByDutyButton.setOnAction(event -> {
            getStaffByDutyButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/getStaffByDuty.fxml"));
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