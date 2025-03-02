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
import model.dto.Category;
import model.dto.Product;
import utils.ConnectDB;

/**
 *
 * @author Windows
 */
public class ProductDAO implements Accessible<Product> {
    private ServletContext sc;
    private Connection con;

//    public ProductDAO() throws ClassNotFoundException, SQLException {
//        this.con = new ConnectDB().getConnection();
//    }

//    public ProductDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
//        
//    }
//    
//    public Connection getConnect(ServletContext sc) throws ClassNotFoundException, SQLException {
//        //Return connection with default parameter or from web descriptor
//        return null;
//    }
    
    @Override
    public int insertRec(Product obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "INSERT INTO products (productId, productName, productImage, "
                    + "brief, postedDate, typeId, account, unit, price, discount) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getProductId());
            cmd.setString(2, obj.getProductName());
            cmd.setString(3, obj.getProductImage());
            cmd.setString(4, obj.getBrief());
            cmd.setDate(5, obj.getPostedDate());
            cmd.setInt(6, obj.getType().getTypeId());
            cmd.setString(7, obj.getAccount().getAccount());
            cmd.setString(8, obj.getUnit());
            cmd.setInt(9, obj.getPrice());
            cmd.setInt(10, obj.getDiscount());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int updateRec(Product obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "UPDATE products SET productId=?, productName=?, productImage=?, brief=?, "
                             + "postedDate=?, typeId=?, account=?, unit=?, price=?, discount=? WHERE productId=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getProductId());
            cmd.setString(2, obj.getProductName());
            cmd.setString(3, obj.getProductImage());
            cmd.setString(4, obj.getBrief());
            cmd.setDate(5, obj.getPostedDate());
            cmd.setInt(6, obj.getType().getTypeId());
            cmd.setString(7, obj.getAccount().getAccount());
            cmd.setString(8, obj.getUnit());
            cmd.setInt(9, obj.getPrice());
            cmd.setInt(10, obj.getDiscount());
            cmd.setString(11, obj.getProductId());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int deleteRec(Product obj) {
        int result = 0;
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "DELETE FROM products WHERE productId=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, obj.getProductId());
            result = cmd.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Product getObjectById(String id) {
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM products WHERE productId=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setString(1, id);
            ResultSet rs = cmd.executeQuery();
            if (rs.next()) {
                Product x = new Product();
                x.setProductId(rs.getString("productId"));
                x.setProductName(rs.getString("productName"));
                x.setProductImage(rs.getString("productImage"));
                x.setBrief(rs.getString("brief"));
                x.setPostedDate(rs.getDate("postedDate"));
                Category c = new CategoryDAO().getObjectById(String.valueOf(rs.getInt("typeId")));
                x.setType(c);
                Account a = new AccountDAO().getObjectById(rs.getString("account"));
                x.setAccount(a);
                x.setUnit(rs.getString("unit"));
                x.setPrice(rs.getInt("price"));
                x.setDiscount(rs.getInt("discount"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Product> listByCategory(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM products WHERE typeId=?";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            cmd.setInt(1, categoryId);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Product x = new Product();
                x.setProductId(rs.getString("productId"));
                x.setProductName(rs.getString("productName"));
                x.setProductImage(rs.getString("productImage"));
                x.setBrief(rs.getString("brief"));
                x.setPostedDate(rs.getDate("postedDate"));
                Category c = new CategoryDAO().getObjectById(String.valueOf(rs.getInt("typeId")));
                x.setType(c);
                Account a = new AccountDAO().getObjectById(rs.getString("account"));
                x.setAccount(a);
                x.setUnit(rs.getString("unit"));
                x.setPrice(rs.getInt("price"));
                x.setDiscount(rs.getInt("discount"));
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list;
    }

    @Override
    public List<Product> listAll() {
        List<Product> list = new ArrayList<>();
        try {
            con = new ConnectDB().getConnection();
            String sqlString = "SELECT * FROM products";
            PreparedStatement cmd = con.prepareStatement(sqlString);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Product x = new Product();
                x.setProductId(rs.getString("productId"));
                x.setProductName(rs.getString("productName"));
                x.setProductImage(rs.getString("productImage"));
                x.setBrief(rs.getString("brief"));
                x.setPostedDate(rs.getDate("postedDate"));
                Category c = new CategoryDAO().getObjectById(String.valueOf(rs.getInt("typeId")));
                x.setType(c);
                Account a = new AccountDAO().getObjectById(rs.getString("account"));
                x.setAccount(a);
                x.setUnit(rs.getString("unit"));
                x.setPrice(rs.getInt("price"));
                x.setDiscount(rs.getInt("discount"));
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
