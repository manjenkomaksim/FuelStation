package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpClient(Client client) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.CLIENTS_TABLE + "(" + Const.CLIENTS_FULLNAME + "," + Const.CLIENTS_PHONENUMBER +
                "," + Const.CLIENTS_CARDNUMBER + "," + Const.CLIENTS_FUELTYPE + "," + Const.CLIENTS_LOGIN + "," + Const.CLIENTS_PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1, client.getFullname());
        preparedStatement.setString(2, client.getPhonenumber());
        preparedStatement.setString(3, client.getCardnumber());
        preparedStatement.setString(4, client.getFuel());
        preparedStatement.setString(5, client.getLogin());
        preparedStatement.setString(6, client.getPassword());

        preparedStatement.executeUpdate();
    }

    public void signUpStaff(Staff staff) throws SQLException, ClassNotFoundException {
        String staffInsert = "INSERT INTO " + Const.STAFF_TABLE + "(" + Const.STAFF_FULLNAME + "," + Const.STAFF_PHONENUMBER +
                "," + Const.STAFF_ADDRESS + "," + Const.STAFF_DUTY + "," + Const.STAFF_LOGIN + "," + Const.STAFF_PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?)";
        PreparedStatement staffPreparedStatement = getDbConnection().prepareStatement(staffInsert);
        staffPreparedStatement.setString(1, staff.getFullname());
        staffPreparedStatement.setString(2, staff.getPhonenumber());
        staffPreparedStatement.setString(3, staff.getAddress());
        staffPreparedStatement.setString(4, staff.getDuty());
        staffPreparedStatement.setString(5, staff.getLogin());
        staffPreparedStatement.setString(6, staff.getPassword());

        staffPreparedStatement.executeUpdate();
    }

    public ResultSet getClient(Client client) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.CLIENTS_TABLE + " WHERE " + Const.CLIENTS_LOGIN + "=? AND "
                + Const.CLIENTS_PASSWORD + "=?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);

        preparedStatement.setString(1, client.getLogin());
        preparedStatement.setString(2, client.getPassword());

        resSet = preparedStatement.executeQuery();

        return resSet;

    }

    public ResultSet getStaff(Staff staff) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.STAFF_TABLE + " WHERE " + Const.STAFF_LOGIN + "=? AND "
                + Const.STAFF_PASSWORD + "=?";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);

        preparedStatement.setString(1, staff.getLogin());
        preparedStatement.setString(2, staff.getPassword());

        resSet = preparedStatement.executeQuery();

        return resSet;

    }

    public String getPopularFuel() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        ArrayList<String> fuelList = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        String select = "SELECT * FROM " + Const.CLIENTS_TABLE;
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        resSet = preparedStatement.executeQuery();
        while (resSet.next()) {
            fuelList.add(resSet.getString("fueltype"));
        }
        int countFuel = 1;
        for (int i = 0; i < fuelList.size() - 1; i++) {
            for (int j = i + 1; j < fuelList.size(); j++) {
                if (fuelList.get(i).equals(fuelList.get(j))) {
                    countFuel++;
                }
            }
            count.add(countFuel);
            countFuel = 1;
        }
        int mostPopularFuelIndex = 0;
        int max = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count.get(i) > max) {
                max = count.get(i);
                mostPopularFuelIndex = i;
            }
        }
        return fuelList.get(mostPopularFuelIndex);

    }

    public void addNewFuel(Fuel fuel) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.FS_TABLE + "(" + Const.FS_FUELTYPE +
                "," + Const.FS_PRICE + "," + Const.FS_AMOUNT + ")" +
                "VALUES(?,?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

        preparedStatement.setString(1, fuel.getTypeOfFuel());
        preparedStatement.setString(2, fuel.getPrice());
        preparedStatement.setString(3, fuel.getAmount());

        preparedStatement.executeUpdate();
    }

    public Double getAveragePrice() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.FS_TABLE;
        ArrayList<Integer> priceList = new ArrayList<>();

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        resSet = preparedStatement.executeQuery();
        while (resSet.next()) {
            priceList.add(Integer.parseInt(resSet.getString("price")));
        }
        Double average = 0.0;
        int sum = 0;
        for (int i = 0; i < priceList.size(); i++) {
            sum = sum + priceList.get(i);
        }
        average = (double) sum / priceList.size();
        return average;
    }

    public ObservableList<String> getStaffList() throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        ObservableList<String> allStaffList = allStaffList = FXCollections.observableArrayList();;
        String select = "SELECT * FROM " + Const.STAFF_TABLE;
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        resSet = preparedStatement.executeQuery();
        while (resSet.next()) {
            String resultString = resSet.getString(2) + ", " + resSet.getString(3) +
                    ", " + resSet.getString(4) + ", " + resSet.getString(5);
            allStaffList.add(resultString);

        }
        return allStaffList;

    }
    public ObservableList<String> getClientByFuelList(String fuel) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        ObservableList<String> allStaffList = allStaffList = FXCollections.observableArrayList();;
        String select = "SELECT * FROM " + Const.CLIENTS_TABLE + " WHERE " + Const.CLIENTS_FUELTYPE + " LIKE " + "'" + fuel + "'";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        resSet = preparedStatement.executeQuery();
        while (resSet.next()) {
            String resultString = resSet.getString(2) + ", " + resSet.getString(3) +
                    ", " + resSet.getString(4) + ", " + resSet.getString(5);
            allStaffList.add(resultString);

        }
        return allStaffList;

    }
    public ObservableList<String> getStaffByFuelList(String fuel) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        ObservableList<String> allStaffList = allStaffList = FXCollections.observableArrayList();;
        String select = "SELECT * FROM " + Const.CLIENTS_TABLE + " WHERE " + Const.CLIENTS_FUELTYPE + " LIKE " + "'" + fuel + "'";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        resSet = preparedStatement.executeQuery();
        while (resSet.next()) {
            String resultString = resSet.getString(2) + ", " + resSet.getString(3) +
                    ", " + resSet.getString(4) + ", " + resSet.getString(5);
            allStaffList.add(resultString);

        }
        return allStaffList;

    }
    public ObservableList<String> getStaffByDutyList(String duty) throws SQLException, ClassNotFoundException {
        ResultSet resSet = null;

        ObservableList<String> allStaffList = allStaffList = FXCollections.observableArrayList();;
        String select = "SELECT * FROM " + Const.STAFF_TABLE + " WHERE " + Const.STAFF_DUTY + " LIKE " + "'" + duty + "'";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        resSet = preparedStatement.executeQuery();
        while (resSet.next()) {
            String resultString = resSet.getString(2) + ", " + resSet.getString(3) +
                    ", " + resSet.getString(4) + ", " + resSet.getString(5);
            allStaffList.add(resultString);

        }
        return allStaffList;

    }
}

/*

*/