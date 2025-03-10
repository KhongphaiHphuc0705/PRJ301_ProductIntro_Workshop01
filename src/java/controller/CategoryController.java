/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.CategoryDAO;
import model.dto.Category;

/**
 *
 * @author Windows
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController"})
public class CategoryController extends HttpServlet {

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
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            if ("DeleteCategory".equals(action)) {
                String typeId = request.getParameter("typeId");
                Category x = categoryDAO.getObjectById(typeId);
                int result = categoryDAO.deleteRec(x);
                if (result != 0) {
                    request.getRequestDispatcher("MainController?action=ListCategory").forward(request, response);
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
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            if ("AddCategory".equals(action)) {
                request.getRequestDispatcher("/private/AddCategory.jsp").forward(request, response);
            } else if ("ListCategory".equals(action)) {
                List<Category> listCategory = categoryDAO.listAll();
                HttpSession session = request.getSession();
                session.setAttribute("listCategory", listCategory);
                request.getRequestDispatcher("/private/ListCategory.jsp").forward(request, response);
            } else if ("UpdateCategory".equals(action)) {
                String typeId = request.getParameter("typeId");
                Category x = categoryDAO.getObjectById(typeId);
                request.setAttribute("typeId", x);
                request.getRequestDispatcher("/private/UpdateCategory.jsp").forward(request, response);
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
        CategoryDAO categoryDAO = new CategoryDAO();
        try {
            if ("AddCategory".equals(action)) {
                String categoryName = request.getParameter("categoryName");
                String memo = request.getParameter("memo");

                int result = categoryDAO.insertRec(new Category(categoryName, memo));
                if (result != 0) {
                    response.sendRedirect("MainController?action=ListCategory");
                }
            } else if ("UpdateCategory".equals(action)) {
                String typeId = request.getParameter("typeId");
                int id = Integer.parseInt(typeId);
                String categoryName = request.getParameter("categoryName");
                String memo = request.getParameter("memo");

                CategoryDAO x = new CategoryDAO();
                int result = x.updateRec(new Category(id, categoryName, memo));
                if (result != 0) {
                    response.sendRedirect("MainController?action=ListCategory");
                } else {
                    request.setAttribute("error", "Update failed!");
                    request.getRequestDispatcher("/private/UpdateCategory.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error processing request");
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
