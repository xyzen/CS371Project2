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
import java.util.Calendar;
import View.*;

public class Controller {
    
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
        
    /**
    * @param args
    */
    public static void main(String[] args) {
        Controller c = new Controller();
        try {
            c.connect("user", "1234", "localhost", "3306", "project2");
            c.start();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
            System.out.println("Could not connect to database.");
        }
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
    
    private int getResultSetSize(ResultSet rs) {
        int count = 0;
        try {
            while (rs.next()) {
                count++;
            }
            rs.first();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
        
    public void handleLoginRequest(String username, String userType) {
        PreparedStatement stmt = null;
        String user_id;
        ResultSet rs;
        int size;
        String query = "SELECT User_ID FROM Users WHERE User_Handle=?";
        switch(userType) {
            
            case "User":
                try {
                    query += ";";
                    stmt=connection.prepareStatement(query);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    size = getResultSetSize(rs);
                    if (size == 0)
                        return;
                    user_id = rs.getString("User_ID");
                    uv = new UserView(this, user_id, username);
                    uv.setVisible(true);
                    lv.setVisible(false);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
                
            case "Moderator":
                query += "AND EXISTS (SELECT 1 FROM Moderators WHERE User_ID=?);";
                try {
                    stmt=connection.prepareStatement(query);
                    stmt.setString(1, username);
                    rs = stmt.executeQuery();
                    size = getResultSetSize(rs);
                    if (size == 0)
                        return;
                    user_id = rs.getString("User_ID");
                    mv = new ModView(this, user_id, username);
                    mv.setVisible(true);
                    lv.setVisible(false);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }
    
    public void handleUserSTDTableRequest(String category, int months_ago, String keyword){
        PreparedStatement stmt = null;
        
        switch (category) {
            case "Housing":
                category = "HOU";
                break;
            case "Electronics":
                category = "ELC";
                break;
            case "Cars and Trucks":
                category = "CAT";
                break;
            case "Child Care":
                category = "CCA";
                break;
            default:
                return;
        }
        
        // Keeps count of question marks in the query
        int var_count = 0;
        
        String query = "SELECT AdvTitle, AdvDetails, Price, AdvDateTime"
                + " FROM Advertisements"
                + " WHERE Status_ID='AC' AND Category_ID=?";
        // We will always have at least one var
        var_count++;

        int days_ago = months_ago*30;
        String date_arg = "";
        
        if (months_ago > 0) {
            Calendar cal = Calendar.getInstance();
            cal.getTime();
            cal.add(Calendar.DATE, -days_ago);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            String month = Integer.toString(cal.get(Calendar.MONTH));
            String year = Integer.toString(cal.get(Calendar.YEAR));
            date_arg = year + "-" + month + "-" + day;
            query += " AND AdvDateTime<DATETIME(?)";
            var_count++; // 
        }
        // We now either have 1 var or 2
        if (!"".equals(keyword)) {
            query += " AND (AdvTitle LIKE ? OR AdvDetails LIKE ?)";
            var_count += 2;
        }
        // We will either have 1, 2, 3, or 4 variables, each corresponding to a specific case
        query += ";";
        
        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1, category);
            switch (var_count) {
                case(1):
                    break;
                case (2):
                    stmt.setString(2, date_arg);
                    break;
                case (3):
                    stmt.setString(2, "%" + keyword + "%");
                    stmt.setString(3, "%" + keyword + "%");
                    break;
                case (4):
                    stmt.setString(2, date_arg);
                    stmt.setString(3, "%" + keyword + "%");
                    stmt.setString(4, "%" + keyword + "%");
                    break;
                default:
                    break;
            }
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count == 0) {
                return;
            }
            Object[][] published_data = new Object[count][4];
            System.out.println("Before loop...");
            int index = 0;
            do {
                String title = rs.getString("AdvTitle");
                String details = rs.getString("AdvDetails");
                String price = rs.getString("Price");
                String datetime = rs.getString("AdvDateTime");
                System.out.println(title + " " + details + " " + price + " " + datetime);
                published_data[index++] = new Object[] {title, details, price, datetime};
            } while (rs.next());
            System.out.println("After loop... " + Integer.toString(index));
            uv.populateSTDTable(published_data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void handleUserMyTableRequest(String userID){
        PreparedStatement stmt = null;
        String query = "SELECT Advertisement_ID, AdvTitle, AdvDetails, Price, S.Status_Name State, AdvDateTime"
                + " FROM Advertisements A "
                + "INNER JOIN Statuses S "
                + "ON A.Status_ID=S.Status_ID "
                + "WHERE User_ID=?;";
        try {
            stmt=connection.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(userID));
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            System.out.println("Count: " + Integer.toString(count));
            if (count == 0)
                return;
            Object[][] user_data = new Object[count][6];
            int index = 0;
            do {
                String id = rs.getString("Advertisement_ID");
                String title = rs.getString("AdvTitle");
                String details = rs.getString("AdvDetails");
                String price = rs.getString("Price");
                String status = rs.getString("State");
                String datetime = rs.getString("AdvDateTime");
                user_data[index++] = new Object[] {id, title, details, price, status, datetime};
            } while(rs.next());
            uv.populateMyTable(user_data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //The button pushed tells the controller to create and set the view to be visible.
    public void handleAddButton(String userID, String username){
        av = new AddView(this, userID, username);
        av.setVisible(true);
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
        String date_arg = "";
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
    
    public void handleEditButton(String adv_id, String user_id) {
        ev = new EditView(this, adv_id, user_id);
        ev.setVisible(true);
    }
    
    public void handleEditRequest(String title, String details, String price, String user_id) {
        if ("".equals(title) | "".equals(details) | "".equals(price))
            return;
    }
    
    public void handleDeleteRequest(String advID) {
        
    }
    
    public void handleModSTDTableRequest(String category, int months, String keyword) {
        
    }
    
    public void handleModMyTableRequest(String userID) {
        
    }
    
    public void handleDecisionRequest(boolean approve, String advID, String userID) {
        
    }
    
    public void handleClaimRequest(String advID, String userID) {
        
    }
}
