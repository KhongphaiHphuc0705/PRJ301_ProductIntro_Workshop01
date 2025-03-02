/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class ConnectDB {
    private String host;
    private String port;
    private String database;
    private String user;
    private String password;
    
    public ConnectDB() {
        this.host = "localhost";
        this.port = "1433";
        this.database = "ProductIntro";
        this.user = "sa";
        this.password = "12345";
    }
    
    public String getUrlConnect() {
        return String.format("jdbc:sqlserver://%s:%s;databaseName=%s", 
                            this.host, this.port, this.database);
    }
    
    public Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection(getUrlConnect(), this.user, this.password);
            System.out.println("Ket noi thanh cong!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }
}
