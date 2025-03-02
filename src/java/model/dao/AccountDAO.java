/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.dto.Account;
import utils.ConnectDB;

/**
 *
 * @author Windows
 */
public class AccountDAO implements Accessible<Account> {
    private ServletContext sc;
    private Connection con;

//    public AccountDAO() throws ClassNotFoundException, SQLException {
//        this.con = new ConnectDB().getConnection();
//    }

//    public AccountDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
//        //Constructor to update ServletConfig object
//    }
//
//    public Connection getConnect(ServletContext sc) throws ClassNotFoundException, SQLException {
//        //Return connection with default parameter or from web descriptor
//        return null;
//    }
    
    @Override
    public int insertRec(Account obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "INSERT INTO accounts (account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getAccount());
            cmd.setString(2, obj.getPass());
            cmd.setString(3, obj.getLastName());
            cmd.setString(4, obj.getFirstName());
            cmd.setDate(5, obj.getBirthday());
            cmd.setBoolean(6, obj.isGender());
            cmd.setString(7, obj.getPhone());
            cmd.setBoolean(8, obj.isIsUse());
            cmd.setInt(9, obj.getRoleInSystem());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int updateRec(Account obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "UPDATE accounts SET account=?, pass=?, lastName=?, firstName=?, "
                    + "birthday=?, gender=?, phone=?, isUse=?, roleInSystem=? WHERE account=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getAccount());
            cmd.setString(2, obj.getPass());
            cmd.setString(3, obj.getLastName());
            cmd.setString(4, obj.getFirstName());
            cmd.setDate(5, obj.getBirthday());
            cmd.setBoolean(6, obj.isGender());
            cmd.setString(7, obj.getPhone());
            cmd.setBoolean(8, obj.isIsUse());
            cmd.setInt(9, obj.getRoleInSystem());
            cmd.setString(10, obj.getAccount());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int deleteRec(Account obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "DELETE FROM accounts WHERE account=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getAccount());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Account getObjectById(String id) {
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM accounts WHERE account=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, id);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                Account x = new Account();
                x.setAccount(rs.getString("account"));
                x.setPass(rs.getString("pass"));
                x.setLastName(rs.getString("lastName"));
                x.setFirstName(rs.getString("firstName"));
                x.setBirthday(rs.getDate("birthday"));
                x.setGender(rs.getBoolean("gender"));
                x.setPhone(rs.getString("phone"));
                x.setIsUse(rs.getBoolean("isUse"));
                x.setRoleInSystem(rs.getInt("roleInSystem"));
                return x;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Account> listByRole(int role) {
        List<Account> list = new ArrayList<>();
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM accounts WHERE roleInSystem=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setInt(1, role);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Account x = new Account();
                x.setAccount(rs.getString("account"));
                x.setPass(rs.getString("pass"));
                x.setLastName(rs.getString("lastName"));
                x.setFirstName(rs.getString("firstName"));
                x.setBirthday(rs.getDate("birthday"));
                x.setGender(rs.getBoolean("gender"));
                x.setPhone(rs.getString("phone"));
                x.setIsUse(rs.getBoolean("isUse"));
                x.setRoleInSystem(rs.getInt("roleInSystem"));
                list.add(x);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM accounts";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Account x = new Account();
                x.setAccount(rs.getString("account"));
                x.setPass(rs.getString("pass"));
                x.setLastName(rs.getString("lastName"));
                x.setFirstName(rs.getString("firstName"));
                x.setBirthday(rs.getDate("birthday"));
                x.setGender(rs.getBoolean("gender"));
                x.setPhone(rs.getString("phone"));
                x.setIsUse(rs.getBoolean("isUse"));
                x.setRoleInSystem(rs.getInt("roleInSystem"));
                list.add(x);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int updateIsUsed(String account, boolean isUse) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "UPDATE accounts SET isUse=? WHERE account=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setBoolean(1, isUse);
            cmd.setString(2, account);
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public Account loginSuccess(String account, String pass) {
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM accounts WHERE account='" + account + "'AND pass='" + pass + "';";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                Account x = new Account();
                x.setAccount(rs.getString("account"));
                x.setPass(rs.getString("pass"));
                x.setLastName(rs.getString("lastName"));
                x.setFirstName(rs.getString("firstName"));
                x.setBirthday(rs.getDate("birthday"));
                x.setGender(rs.getBoolean("gender"));
                x.setPhone(rs.getString("phone"));
                x.setIsUse(rs.getBoolean("isUse"));
                x.setRoleInSystem(rs.getInt("roleInSystem"));
                return x;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
