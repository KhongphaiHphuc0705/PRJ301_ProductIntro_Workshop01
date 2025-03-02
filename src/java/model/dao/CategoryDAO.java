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
import model.dto.Category;
import utils.ConnectDB;

/**
 *
 * @author Windows
 */
public class CategoryDAO implements Accessible<Category> {
    private ServletContext sc;
    private Connection con;

//    public CategoryDAO() throws ClassNotFoundException, SQLException {
//        this.con = new ConnectDB().getConnection();
//    }

//    public CategoryDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
//        
//    }
//    
//    public Connection getConnect(ServletContext sc) throws ClassNotFoundException, SQLException {
//        //Return connection with default parameter or from web descriptor
//        return null;
//    }
    
    @Override
    public int insertRec(Category obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "INSERT INTO categories (categoryName, memo) VALUES (?, ?)";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getCategoryName());
            cmd.setString(2, obj.getMemo());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int updateRec(Category obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "UPDATE categories SET categoryName=?, "
                             + "memo=? WHERE typeId=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getCategoryName());
            cmd.setString(2, obj.getMemo());
            cmd.setInt(3, obj.getTypeId());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int deleteRec(Category obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "DELETE FROM categories WHERE typeId=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setInt(1, obj.getTypeId());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Category getObjectById(String id) {
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM categories WHERE typeId=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setInt(1, Integer.parseInt(id));
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                Category x = new Category();
                x.setTypeId(rs.getInt("typeId"));
                x.setCategoryName(rs.getString("categoryName"));
                x.setMemo(rs.getString("memo"));
                return x;
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Category> listAll() {
        List<Category> list = new ArrayList<>();
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM categories";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Category x = new Category();
                x.setTypeId(rs.getInt("typeId"));
                x.setCategoryName(rs.getString("categoryName"));
                x.setMemo(rs.getString("memo"));
                list.add(x);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
