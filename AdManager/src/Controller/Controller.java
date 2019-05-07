/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Tyler
 */
public class Controller {
    /**
     * @param args the command line arguments
     */
    
    Connection connection;
    
    public class Record{
        public String title;
        public String description;
        public String price;
        public String status;
        public String date;
        public String username;
        public String type;
        
        public Record(String title, String description, float price, String status, String date, String username, String type){
            this.title = title;
            this.description = description;
            this.price = Float.toString(price);
            this.status = status;
            this.date = date;
            this.username = username;
            this.type = type;
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
    
    public LinkedList<Record> getActiveAds(String category, int months, String keyword){
        LinkedList<Record> records=new LinkedList();
        PreparedStatement stmt = null;
        Date date = new Date();
        date.setMonth(date.getMonth() - months);
        String date_arg = date.toString();
        String query = "select AdvTitle, AdvDetails, Price, AdvDateTime"
                + "FROM Advertisements"
                + "WHERE Status_ID='AC' AND Category_ID=? AND AdvDateTime<? AND (AdvTitle LIKE ? OR A.AdvDetails LIKE ?);";

        try {
            stmt=connection.prepareStatement(query);
            stmt.setString(1, category);
            stmt.setString(2, date_arg);
            stmt.setString(3, "%" + keyword + "%");
            stmt.setString(4, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String ad_title = rs.getString("AdvTitle");
                String ad_desc = rs.getString("AdvDetails");
                String ad_price = rs.getString("Price");
                String ad_date = rs.getString("AdvDateTime");
                Record record=new Record(ad_title, ad_desc, ad_price, "", ad_date, "", "");
                records.add(record);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return records;
        }
        return records;
 }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
