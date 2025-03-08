/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.AccountDAO;
import model.dto.Account;

/**
 *
 * @author Windows
 */
@WebServlet(name = "AccountController", urlPatterns = {"/AccountController"})
public class AccountController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        AccountDAO accountDAO = new AccountDAO();
        try {
            if ("DeleteAccount".equals(action)) {
                String account = request.getParameter("account");
                Account x = accountDAO.getObjectById(account);
                int result = accountDAO.deleteRec(x);
                if (result != 0) {
                    request.getRequestDispatcher("MainController?action=ListAccount").forward(request, response);
                }
            } else if ("ToggleStatus".equals(action)) {
                String account = request.getParameter("account");
                Boolean isUse = Boolean.parseBoolean(request.getParameter("isUse"));
                int result = accountDAO.updateIsUsed(account, !isUse);
                if (result != 0) {
                    request.getRequestDispatcher("MainController?action=ListAccount").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error processing request");
        }
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
        processRequest(request, response);
        String action = request.getParameter("action");
        AccountDAO accountDAO = new AccountDAO();
        try {
            if ("ListAccount".equals(action)) {
                String search = request.getParameter("search");
                List<Account> accounts = (search != null && !search.trim().isEmpty())
                        ? accountDAO.searchByName(search.trim())
                        : accountDAO.listAll();

                request.setAttribute("listAccount", accounts);
                request.setAttribute("search", search);
                request.getRequestDispatcher("ListAccount.jsp").forward(request, response);
            } else if ("UpdateAccount".equals(action)) {
                String account = request.getParameter("account");
                Account x = new AccountDAO().getObjectById(account);
                request.setAttribute("account", x);
                request.getRequestDispatcher("UpdateAccount.jsp").forward(request, response);
            } else if ("AddAccount".equals(action)) {
                request.getRequestDispatcher("AddAccount.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error processing request");
        }
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
        processRequest(request, response);
        String action = request.getParameter("action");
        AccountDAO accountDAO = new AccountDAO();
        
        try {
            if ("AddAccount".equals(action)) {
                String account = request.getParameter("account");
                String password = request.getParameter("pass");
                String lastName = request.getParameter("lastName");
                String firstName = request.getParameter("firstName");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = new Date(sdf.parse(request.getParameter("birthday")).getTime());
                String phone = request.getParameter("phone");
                boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
                boolean isUse = request.getParameter("isUse") != null;
                int roleInSystem = Integer.parseInt(request.getParameter("roleInSystem"));
                int result = accountDAO.insertRec(new Account(account, password, lastName,
                        firstName, birthday, gender, phone, isUse, roleInSystem));
                if (result != 0) {
                    response.sendRedirect("MainController?action=ListAccount");
                }
            } else if ("UpdateAccount".equals(action)) {
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
                String account = request.getParameter("account");
                String password = request.getParameter("pass");
                String lastName = request.getParameter("lastName");
                String firstName = request.getParameter("firstName");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = new Date(sdf.parse(request.getParameter("birthday")).getTime());
                String phone = request.getParameter("phone");
                boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
                boolean isUse = request.getParameter("isUse") != null;
                int roleInSystem = Integer.parseInt(request.getParameter("roleInSystem"));
                int result = accountDAO.updateRec(new Account(account, password, lastName, firstName,
                        birthday, gender, phone, isUse, roleInSystem));
                if (result != 0) {
                    response.sendRedirect("MainController?action=ListAccount");
                } else {
                    request.setAttribute("error", "Update failed!");
                    request.getRequestDispatcher("UpdateAccount.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error processing request");
            request.getRequestDispatcher("ListAccount.jsp").forward(request, response);
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
