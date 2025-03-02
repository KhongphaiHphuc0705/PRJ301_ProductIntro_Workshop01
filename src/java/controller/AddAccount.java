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
import javax.servlet.http.HttpSession;
import model.dao.AccountDAO;
import model.dto.Account;
import utils.ConnectDB;

/**
 *
 * @author Windows
 */
public class AddAccount extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AddAccount.jsp").forward(request, response);
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
        try {
            String account = request.getParameter("account");
            String password = request.getParameter("pass");
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            java.util.Date utilDate = sdf.parse(request.getParameter("birthday"));
//            java.sql.Date birthday = new java.sql.Date(utilDate.getTime());
            Date birthday = new Date(sdf.parse(request.getParameter("birthday")).getTime());
            String phone = request.getParameter("phone");
            boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
            boolean isUse = request.getParameter("isUse") != null;
            int roleInSystem = Integer.parseInt(request.getParameter("roleInSystem"));

            AccountDAO x = new AccountDAO();
            int result = x.insertRec(new Account(account, password, lastName, 
                         firstName, birthday, gender, phone, isUse, roleInSystem));
            if (result != 0)
                response.sendRedirect("ListAccount");
        } catch (ParseException ex) {
            Logger.getLogger(AddAccount.class.getName()).log(Level.SEVERE, null, ex);
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
