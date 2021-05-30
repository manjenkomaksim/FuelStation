package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AddingNewFuelController {

    @FXML
    private Button exitToStaffMenuButton;

    @FXML
    private Button addNewFuelButton;

    @FXML
    private TextField priceOfFuelField;

    @FXML
    private TextField amountOfFuelField;

    @FXML
    private TextField nameOfFuelField;

    @FXML
    private Label addingFuelLabel;

    @FXML
    private Label addedFuelLabel;

    @FXML
    void initialize() {
        exitToStaffMenuButton.setOnAction(event -> {
            exitToStaffMenuButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../UI/staffMenu.fxml"));
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
            try {
                addFuel();

                addedFuelLabel.setText("Added!");
                nameOfFuelField.clear();
                priceOfFuelField.clear();
                amountOfFuelField.clear();


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

    }
    public void addFuel() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String typeOfFuel = nameOfFuelField.getText();
        String price = priceOfFuelField.getText();
        String amount = amountOfFuelField.getText();

        Fuel fuel = new Fuel(typeOfFuel, price, amount);
        dbHandler.addNewFuel(fuel);
    }
}