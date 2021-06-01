package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GetByFuelController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitToStaffMenuButton;

    @FXML
    private Label addedFuelLabel;

    @FXML
    private ListView<String> staffListView;

    @FXML
    private Button getClientButton;

    @FXML
    private Label enterFuelLabel;

    @FXML
    private  TextField enterTypeOfFuelField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
        getClientButton.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();
            try {
                staffListView.getItems().addAll(dbHandler.getClientByFuelList(enterTypeOfFuelField.getText()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });
    }
}
