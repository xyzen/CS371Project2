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
import View.*;
import Model.QueryBuilder;

public class Controller {

    private Connection connection;
    private LoginView lv;
    private AddView av;
    private EditView ev;
    private ModView mv;
    private UserView uv;
    private MessageView mesv;
    
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

    public Controller() {
        lv = new LoginView(this);
    }

    public void start() {
        lv.setVisible(true);
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
        this.connection = conn;
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

    private int getNumMonths(String period) {
        switch (period) {
            case "Last 3 Months":
                return 3;
            case "Last 6 Months":
                return 6;
            case "Last 12 Months":
                return 12;
            default:
                return 0;
        }
    }
    
    private QueryBuilder buildUserSTDQuery(String category, String months_ago, String keyword) {
        QueryBuilder qb = new QueryBuilder();
        qb.setColumns(new String[] {"Title", "Details", "Price", "Date_Posted"}, 4);
        qb.setCondition("Status='Active'");
        if(!"All".equals(category))
            qb.setCategoryCondition(category);
        qb.setDateCondition(getNumMonths(months_ago));
        qb.setKeywordCondition(keyword);
        return qb;
    }
    
    private QueryBuilder buildModSTDQuery(String modID, String category, String months_ago, String keyword) {
        QueryBuilder qb = new QueryBuilder();
        qb.setColumns(new String[] {"ID", "Title", "Details", "Price", "Date_Posted", "Username"}, 6);
        qb.setCategoryCondition(category);
        qb.setDateCondition(getNumMonths(months_ago));
        qb.setKeywordCondition(keyword);
        qb.setCondition("Status='Pending'");
        qb.setCondition("User_ID!=?", modID);
        qb.setCondition("Mod_ID IS NULL");
        return qb;
    }

    private PreparedStatement buildStatement(QueryBuilder qb) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(qb.buildQuery());
        for (int i = 0; i < qb.num_args; i++) {
            if (qb.args[i] instanceof Integer) {
                stmt.setInt(i+1, (int) qb.args[i]);
            }
            if (qb.args[i] instanceof String) {
                stmt.setString(i+1, (String) qb.args[i]);
            }
        }
        return stmt;
    }
    
    private Object[][] buildData(ResultSet rs, int count, QueryBuilder qb) throws SQLException {
        Object data[][] = new Object[count][qb.num_cols];
        int index = 0;
        do {
            Object[] temp = new Object[qb.num_cols];
            for(int i = 0; i < qb.num_cols; i++)
                temp[i] = rs.getString(qb.columns[i]);
            data[index++] = temp;
        } while(rs.next());
        return data;
    }

    private void handleUserLogin(String username) {
        String query = "SELECT User_ID from Users WHERE User_Handle=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            ;
            if (getResultSetSize(rs) < 1) {
                mesv = new MessageView("User not found!");
                return;
            }
            uv = new UserView(this, rs.getString("User_ID"), username);
            uv.setVisible(true);
            lv.setVisible(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleModLogin(String username) {
        String query = "SELECT M.User_ID from Moderators M"
                + " INNER JOIN Users U"
                + " ON M.User_ID=U.User_ID"
                + " WHERE U.User_Handle=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (getResultSetSize(rs) < 1) {
                mesv = new MessageView("User not found!");
                return;
            }
            mv = new ModView(this, rs.getString("User_ID"), username);
            mv.setVisible(true);
            lv.setVisible(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleLoginRequest(String username, String userType) {
        switch (userType) {
            case "User":
                handleUserLogin(username);
                break;
            case "Moderator":
                handleModLogin(username);
                break;
            default:
                break;
        }
    }

    public void handleUserSTDTableRequest(String category, String months_ago, String keyword) {
        
        QueryBuilder qb = buildUserSTDQuery(category, months_ago, keyword);
        try {
            PreparedStatement stmt = buildStatement(qb);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count < 1) {
                uv.resetSTDTable();
                return;
            }
            Object[][] data = buildData(rs, count, qb);
            uv.populateSTDTable(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleUserMyTableRequest(String userID) {
        QueryBuilder qb = new QueryBuilder();
        qb.setColumns(new String[]{"ID", "Title", "Details", "Price", "Status", "Date_Posted"}, 6);
        qb.setCondition("User_ID=?");
        try {
            PreparedStatement stmt = connection.prepareStatement(qb.buildQuery());
            stmt.setInt(1, Integer.parseInt(userID));
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count == 0) {
                uv.resetMyTable();
                return;
            }
            Object[][] data = buildData(rs, count, qb);
            uv.populateMyTable(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //The button pushed tells the controller to create and set the view to be visible.
    public void handleAddButton(String userID, String username) {
        av = new AddView(this, userID, username);
        av.setVisible(true);
    }

    public void handleAddRequest(String title, String desc, String cat, String price, String user_id) {
     
        String query = "INSERT INTO Advertisements(AdvTitle, AdvDetails, AdvDateTime, Price, Category_ID, User_ID, Status_ID)"
                + "VALUES (?, ?, CURRENT_TIME(), ?, ("
                    + "SELECT Category_ID FROM Categories WHERE CatName=?)"
                + ", ?, 'PN');";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, desc);
            stmt.setString(3, price);
            stmt.setString(4, cat);
            stmt.setString(5, user_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        av.setVisible(false);
    }

    public void handleEditButton(String adv_id, String user_id) {
        ev = new EditView(this, adv_id, user_id);
        ev.setVisible(true);
    }

    public void handleEditRequest(String advID, String title, String details, String price, String user_id) {
        if ("".equals(title) | "".equals(details) | "".equals(price)) {
            ev.setVisible(false);
            mesv = new MessageView("Please fill all fields.");
            return;
        }
        String query = "UPDATE Advertisements"
                + " SET AdvTitle=?, AdvDetails=?, Price=?, Status_ID='PN'"
                + " WHERE Advertisement_ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, details);
            stmt.setString(3, price);
            stmt.setString(4, advID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ev.setVisible(false);
    }

    public void handleDeleteRequest(String advID) {
        String query = "DELETE FROM Advertisements"
                + " WHERE Advertisement_ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, advID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleModSTDTableRequest(String modID, String category, String months_ago, String keyword) {
        
        QueryBuilder qb = buildModSTDQuery(modID, category, months_ago, keyword);
        try {
            PreparedStatement stmt = buildStatement(qb);
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count < 1) {
                mv.resetSTDTable();
                return;
            }
            Object[][] data = buildData(rs, count, qb);
            mv.populateSTDTable(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleModMyTableRequest(String modID) {
        QueryBuilder qb = new QueryBuilder();
        qb.setColumns(new String[] {"ID", "Title", "Details", "Price", "Status", "Date_Posted", "Username"}, 7);
        qb.setCondition("Mod_ID=?");
        try {
            PreparedStatement stmt = connection.prepareStatement(qb.buildQuery());
            stmt.setInt(1, Integer.parseInt(modID));
            ResultSet rs = stmt.executeQuery();
            int count = getResultSetSize(rs);
            if (count == 0) {
                mv.resetMyTable();
                return;
            }
            Object[][] data = buildData(rs, count, qb);
            mv.populateMyTable(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleDecisionRequest(boolean approve, String advID, String userID) {
        String query = "UPDATE Advertisements SET Status_ID=? WHERE Advertisement_ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            if (approve) {
                stmt.setString(1, new String("AC"));
            } else {
                stmt.setString(1, new String("DI"));
            }
            stmt.setString(2, advID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleClaimRequest(String advID, String userID) {
        PreparedStatement stmt = null;
        String query = "UPDATE Advertisements SET Moderator_ID=? WHERE Advertisement_ID=?";
        try {
            stmt = connection.prepareStatement(query);
            stmt.setString(1, userID);
            stmt.setString(2, advID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
