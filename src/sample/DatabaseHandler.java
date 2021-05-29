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
    public void signUpClient(String fullname, String phonenumber, String cardnumber, String fuel, String login, String password ) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.CLIENTS_TABLE + "(" + Const.CLIENTS_FULLNAME + "," + Const.CLIENTS_PHONENUMBER +
                "," + Const.CLIENTS_CARDNUMBER + "," + Const.CLIENTS_FUELTYPE + "," + Const.CLIENTS_LOGIN + "," + Const.CLIENTS_PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        preparedStatement.setString(1, fullname);
        preparedStatement.setString(2, phonenumber);
        preparedStatement.setString(3, cardnumber);
        preparedStatement.setString(4, fuel);
        preparedStatement.setString(5, login);
        preparedStatement.setString(6, password);

        preparedStatement.executeUpdate();
    }

        public void signUpStaff(String fullname, String phonenumber, String address, String duty, String login, String password ) throws SQLException, ClassNotFoundException {
            String staffInsert = "INSERT INTO " + Const.STAFF_TABLE + "(" + Const.STAFF_FULLNAME + "," + Const.STAFF_PHONENUMBER +
                    "," + Const.STAFF_ADDRESS + "," + Const.STAFF_DUTY + "," + Const.STAFF_LOGIN + "," + Const.STAFF_PASSWORD + ")" +
                    "VALUES(?,?,?,?,?,?)";
            PreparedStatement staffPreparedStatement = getDbConnection().prepareStatement(staffInsert);
            staffPreparedStatement.setString(1, fullname);
            staffPreparedStatement.setString(2, phonenumber);
            staffPreparedStatement.setString(3, address);
            staffPreparedStatement.setString(4, duty);
            staffPreparedStatement.setString(5, login);
            staffPreparedStatement.setString(6, password);

            staffPreparedStatement.executeUpdate();
    }
}
