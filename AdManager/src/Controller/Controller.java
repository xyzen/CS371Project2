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
import java.util.Properties;
import java.util.Date;
import View.EditView;
import View.AddView;
import View.LoginView;


public class Controller {
    /**
     * @param args the command line arguments
     */
    
    private Connection connection;
    private final LoginView lv;
    private AddView av;
    private EditView ev;
    
    public Controller() {
        lv = new LoginView(this);
    }
    
    public void start() {
        lv.setVisible(true);
    }
    
    public void handleLoginRequest(String username, String userType) {
        
    }
   
    public void handleAddAdvertisement(String title, String desc, String cat, float price, int user_id) {
        if (cat == "Housing") {
            cat = "HOU";
        }
        else if (cat == "Electronics") {
            cat = "ELC";
        }
        else if (cat == "Cars and Trucks") {
            cat = "CAT";
        }
        else if (cat == "Child Care") {
            cat = "CCA";
        }
        else {
            return;
        }
        PreparedStatement stmt;
        String query = "INSERT INTO Advertisements(AdvTitle, AdvDetails, AdvDateTime, Price, Category_ID, User_ID, Status_ID)"
                + "VALUES (?, ?, DATETIME(?), ?, ?, ?, 'PN');";
        Date date = new Date();
        String date_arg = Integer.toString(date.getYear())+"-"+Integer.toString(date.getMonth())+"-"+Integer.toString(date.getDate());
        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, desc);
            stmt.setString(3, date_arg);
            stmt.setString(4, Float.toString(price));
            stmt.setString(5, cat);
            stmt.setString(6, Integer.toString(user_id));
            stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //The button pushed tells the controller to create and set the view to be visible.
    public void handleAddAdButtonPushed(){
        av = new AddView();
        av.setVisible(true);
    }
    
    
    public void handleEditAdvertisement(int adv_id) {
        ev = new EditView(adv_id);
        ev.setVisible(true);
    }
    
    public void handleDeleteAdvertisement(int adv_id) {
        
    }
    
    public void handleUserSTDTableRequest(String category, int months, String keyword){
        PreparedStatement stmt;
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    
    public void connect(String userName, String password, String serverName, String portNumber, String dbName) throws SQLException, InstantiationException, IllegalAccessException {
        System.out.println("Loading driver...");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }

        Connection conn;
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
    
}
