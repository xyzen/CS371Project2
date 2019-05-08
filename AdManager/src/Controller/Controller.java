// Reference: DB_Classroom/src/db/DBManager.java

/**
 * 
 * @author Tyler
 */

package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Date;


public class Controller {
    /**
     * @param args the command line arguments
     */
    
    private Connection connection;
    
    public void connect(String userName, String password, String serverName, String portNumber, String dbName) throws SQLException, InstantiationException, IllegalAccessException {
        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);

        conn = DriverManager.getConnection(
                "jdbc:mysql://"
                + serverName
                + ":" + portNumber + "/" + dbName,
                connectionProps);

        System.out.println("Connected to database");
        this.connection=conn;
    }
    
    public String[][] handlePublishedRequest(String category, int months, String keyword){
        PreparedStatement stmt = null;
        Date date = new Date();
        date.setMonth(date.getMonth() - months);
        String date_arg = Integer.toString(date.getYear())+"-"+Integer.toString(date.getMonth())+"-"+Integer.toString(date.getDate());
        String query = "SELECT AdvTitle, AdvDetails, Price, AdvDateTime"
                + "FROM Advertisements"
                + "WHERE Status_ID='AC' AND Category_ID=? AND AdvDateTime<? AND (AdvTitle LIKE ? OR A.AdvDetails LIKE ?);";
        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1, category);
            stmt.setString(2, date_arg);
            stmt.setString(3, "%" + keyword + "%");
            stmt.setString(4, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            String[][] published_data = new String[count][4];
            int index = 0;
            while(rs.next()){
                published_data[index][0] = rs.getString("AdvTitle");
                published_data[index][1] = rs.getString("AdvDetails");
                published_data[index][2] = rs.getString("Price");
                published_data[index][3] = rs.getString("AdvDateTime");
                index++;
            }
            return published_data;   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new String[0][4];
        }
    }
    
      private int getResultSetSize(ResultSet rs) {
        int count = 0;
        try {
            while (rs.next()) {
                count++;
            }
            rs.first();
        } catch (SQLException e) {

        }
        return count;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
