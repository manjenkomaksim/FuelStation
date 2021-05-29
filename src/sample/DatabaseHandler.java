package sample;
import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
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
}
