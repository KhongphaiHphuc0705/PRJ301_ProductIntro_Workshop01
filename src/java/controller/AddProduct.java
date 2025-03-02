/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.AccountDAO;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.dto.Account;
import model.dto.Category;
import model.dto.Product;
import utils.ConnectDB;

/**
 *
 * @author Windows
 */
public class AddProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("account");
        Account x = new AccountDAO().getObjectById(account);
        request.setAttribute("account", x);
        request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            response.setContentType("text/html;charset=UTF-8");
            String productId = request.getParameter("productId");
            String productName = request.getParameter("productName");
            String productImage = request.getParameter("productImage");
            String brief = request.getParameter("brief");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date postedDate = new Date (sdf.parse(request.getParameter("postedDate")).getTime());
            String typeId = request.getParameter("typeId");
            Category type = new CategoryDAO().getObjectById(typeId);
            String acc = request.getParameter("account");
            Account account = new AccountDAO().getObjectById(acc);
            String unit = request.getParameter("unit");
            int price = Integer.parseInt(request.getParameter("price"));
            int discount = Integer.parseInt(request.getParameter("discount"));

            ProductDAO x = new ProductDAO();
            int result = x.insertRec(new Product(productId, productName, productImage, 
                         brief, postedDate, type, account, unit, price, discount));
            if (result != 0)
                response.sendRedirect("ListProduct");
        } catch (ParseException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
