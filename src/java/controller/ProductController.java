/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.AccountDAO;
import model.dao.CategoryDAO;
import model.dao.ProductDAO;
import model.dto.Account;
import model.dto.Category;
import model.dto.Product;

/**
 *
 * @author Windows
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductController"})
public class ProductController extends HttpServlet {

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
        ProductDAO productDAO = new ProductDAO();
        try {
            if ("DeleteProduct".equals(action)) {
                String productId = request.getParameter("productId");
                Product x = new ProductDAO().getObjectById(productId);
                int result = new ProductDAO().deleteRec(x);
                if (result != 0) {
                    request.getRequestDispatcher("MainController?action=ListProduct").forward(request, response);
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
        ProductDAO productDAO = new ProductDAO();
        try {
            if ("AddProduct".equals(action)) {
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
            } else if ("ListProduct".equals(action)) {
                String search = request.getParameter("search");
                List<Product> products = (search != null && !search.trim().isEmpty())
                                       ? productDAO.searchByName(search.trim())
                                       : productDAO.listAll();
                request.setAttribute("listProduct", products);
                request.setAttribute("search", search);
                request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
            } else if ("UpdateProduct".equals(action)) {
                String productId = request.getParameter("productId");
                Product x = new ProductDAO().getObjectById(productId);
                request.setAttribute("productId", x);
                request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
            } else if ("ViewProduct".equals(action)) {
                String productId = request.getParameter("productId");
                Product product = productDAO.getObjectById(productId);
                request.setAttribute("product", product);
                System.out.println("Product loaded: " + product);
                request.getRequestDispatcher("ViewProduct.jsp").forward(request, response);
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
        ProductDAO productDAO = new ProductDAO();
        try {
            if ("AddProduct".equals(action)) {
                response.setContentType("text/html;charset=UTF-8");
                String productId = request.getParameter("productId");
                String productName = request.getParameter("productName");
                String productImage = request.getParameter("productImage");
                String brief = request.getParameter("brief");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date postedDate = new Date(sdf.parse(request.getParameter("postedDate")).getTime());
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
                if (result != 0) {
                    response.sendRedirect("MainController?action=ListProduct");
                }
            } else if ("UpdateProduct".equals(action)) {
                response.setContentType("text/html;charset=UTF-8");
                String productId = request.getParameter("productId");
                String productName = request.getParameter("productName");
                String productImage = request.getParameter("productImage");
                String brief = request.getParameter("brief");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date postedDate = new Date(sdf.parse(request.getParameter("postedDate")).getTime());
                String typeId = request.getParameter("typeId");
                Category type = new CategoryDAO().getObjectById(typeId);
                String acc = request.getParameter("account");
                Account account = new AccountDAO().getObjectById(acc);
                String unit = request.getParameter("unit");
                int price = Integer.parseInt(request.getParameter("price"));
                int discount = Integer.parseInt(request.getParameter("discount"));

                ProductDAO x = new ProductDAO();
                int result = x.updateRec(new Product(productId, productName, productImage,
                        brief, postedDate, type, account, unit, price, discount));
                if (result != 0) {
                    response.sendRedirect("MainController?action=ListProduct");
                } else {
                    request.setAttribute("error", "Update failed!");
                    request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
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
