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
import View.*;

public class Controller {
    /**
     * @param args the command line arguments
     */
    
    private Connection connection;
    private LoginView lv;
    private AddView av;
    private EditView ev;
    private ModView mv;
    private UserView uv;
    
    public Controller() {
        lv = new LoginView(this);
    }
    
    public void start() {
        lv.setVisible(true);
    }
    
    public void handleLoginRequest(String username, String userType) {
        PreparedStatement stmt = null;
        int size; String user_id; ResultSet rs;
        String query = "SELECT User_ID FROM ";
        switch(userType) {
            
            case "User":
                query += "Users WHERE Username=?;";
                try {
                    stmt=connection.prepareStatement(query);
                    stmt.setString(0, username);
                    rs = stmt.executeQuery();
                    size = getResultSetSize(rs);
                    if (size == 0)
                        return;
                    user_id = rs.getString("User_ID");
                    uv = new UserView(this, user_id);
                    uv.setVisible(true);
                    lv.setVisible(false);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
                
            case "Moderator":
                query += "Users WHERE EXISTS (SELECT 1 FROM Moderators WHERE User_ID=?);";
                try {
                    stmt=connection.prepareStatement(query);
                    stmt.setString(0, username);
                    rs = stmt.executeQuery();
                    size = getResultSetSize(rs);
                    user_id = rs.getString("User_ID");
                    if (size == 0)
                        return;
                    mv = new ModView(this, user_id);
                    mv.setVisible(true);
                    lv.setVisible(false);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }
   
    public void handleAddRequest(String title, String desc, String cat, String price, String user_id) {
        switch (cat) {
            case "Housing":
                cat = "HOU";
                break;
            case "Electronics":
                cat = "ELC";
                break;
            case "Cars and Trucks":
                cat = "CAT";
                break;
            case "Child Care":
                cat = "CCA";
                break;
            default:
                return;
        }
        PreparedStatement stmt = null;
        String query = "INSERT INTO Advertisements(AdvTitle, AdvDetails, AdvDateTime, Price, Category_ID, User_ID, Status_ID)"
                + "VALUES (?, ?, DATETIME(?), ?, ?, ?, 'PN');";
        Date date = new Date();
        String date_arg = Integer.toString(date.getYear())+"-"+Integer.toString(date.getMonth())+"-"+Integer.toString(date.getDate());
        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, desc);
            stmt.setString(3, date_arg);
            stmt.setString(4, price);
            stmt.setString(5, cat);
            stmt.setString(6, user_id);
            stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //The button pushed tells the controller to create and set the view to be visible.
    public void handleAddButton(String userID){
        av = new AddView(this, userID);
        av.setVisible(true);
    }
    
    public void handleEditButton(String adv_id, String user_id) {
        ev = new EditView(this, adv_id, user_id);
        ev.setVisible(true);
    }
    
    public void handleEditRequest(String title, String details, float price, int user_id) {
        if ("".equals(title) | "".equals(details) | price == 0)
            return;
    }
    
    public void handleDeleteRequest(int adv_id) {
        
    }
    
    public void handleUserSTDTableRequest(String category, int months, String keyword){
        PreparedStatement stmt = null;
        Date date = new Date();
        date.setMonth(date.getMonth() - months);
        String date_arg = Integer.toString(date.getYear())+"-"+Integer.toString(date.getMonth())+"-"+Integer.toString(date.getDate());
        String query = "SELECT AdvTitle, AdvDetails, Price, AdvDateTime"
                + "FROM Advertisements"
                + "WHERE Status_ID='AC' AND Category_ID='?' AND (AdvTitle LIKE '?' OR A.AdvDetails LIKE '?')";
        if (months > 0) {
            query += "AND AdvDateTime<'?';";
        }
        else {
            query += ";";
        }
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
        
    public void handleUserMyTableRequest(String category, int months, String keyword){
        PreparedStatement stmt = null;
        Date date = new Date();
        date.setMonth(date.getMonth() - months);
        String date_arg = Integer.toString(date.getYear())+"-"+Integer.toString(date.getMonth())+"-"+Integer.toString(date.getDate());
        String query = "SELECT AdvTitle, AdvDetails, Price, AdvDateTime"
                + "FROM Advertisements"
                + "WHERE Status_ID='AC' AND Category_ID='?' AND AdvDateTime<'?' AND (AdvTitle LIKE '?' OR A.AdvDetails LIKE '?');";
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
    
    /**
    * @param args
    */
    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
}
