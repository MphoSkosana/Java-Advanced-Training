package Chapter11;

import java.sql.*;

public class ReadData {
    static void main() {
        String connectionString = "jdbc:sqlserver://ILAB09\\SQLEXPRESS;database=Northwind;encrypt=true";

        try {
            //create connection obj
            Connection objConnection = DriverManager.getConnection(connectionString);

            //open the connection
            Statement stm = objConnection.createStatement();

            String cmdSelect = "SELECT * FROM Employees";

            //create query
            ResultSet rs = stm.executeQuery(cmdSelect);

            while (rs.next()){
                System.out.println(rs.getInt(1)+ " - " +rs.getString(3));
            }

            objConnection.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
