<%-- 
    Document   : UpdateProduct
    Created on : Feb 26, 2025, 5:16:31 PM
    Author     : Windows
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.dto.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Product x = (Product) request.getAttribute("productId");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="Header.jspf" %>
        <div class="mx-auto p-6 bg-gray-800 shadow-lg min-h-screen">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">
                UPDATE PRODUCT
            </h1>
            
            <form action="MainController" method="POST" class="space-y-4 border-2 border-white p-4 max-w-3xl mx-auto">
                <input type="hidden" name="action" value="UpdateProduct">
                <div class="form-group">
                    <label for="productId" class="block font-medium text-gray-100">Product ID: </label>
                    <input type="text" name="productId" required value="<%= x.getProductId() %>" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg 
                           focus:outline-none focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="productName" class="block font-medium text-gray-100">Product name: </label>
                    <input type="text" name="productName" value="<%= x.getProductName() %>" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg 
                           focus:outline-none focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="productImage" class="block font-medium text-gray-100">Product image: </label>
                    <input type="text" name="productImage" value="<%= x.getProductImage() %>" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg 
                           focus:outline-none focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="brief" class="block font-medium text-gray-100">Brief: </label>
                    <textarea name="brief" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                    focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out text-gray-100"><%= x.getBrief() %></textarea>
                </div>
                <div class="form-group">
                    <label for="postedDate" class="block font-medium text-gray-100">Posted date: </label>
                    <input type="date" name="postedDate" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(x.getPostedDate()) %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none focus:ring-2 
                           focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="typeId" class="block font-medium text-gray-100">Type: </label>
                    <select name="typeId" class="w-full p-2 border rounded-lg bg-gray-700 border-gray-600 mt-4 text-gray-100">
                        <c:forEach var="type" items="${types}">
                            <option value="${type.typeId}">${type.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="account" class="block font-medium text-gray-100">Account: </label>
                    <input type="text" name="account" value="<%= x.getAccount().getAccount() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg 
                           focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label for="unit" class="block font-medium text-gray-100">Unit: </label>
                    <input type="text" name="unit" value="<%= x.getUnit() %>" 
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg 
                           focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter unit">
                </div>
                <div class="form-group">
                    <label for="price" class="block font-medium text-gray-100">Price: </label>
                    <input type="number" name="price" value="<%= x.getPrice() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter price (VNĐ)">
                </div>
                <div class="form-group">
                    <label for="discount" class="block font-medium text-gray-100">Discount (%): </label>
                    <input type="number" name="discount" value="<%= x.getDiscount() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter discount">
                </div>
                <button type="submit" class="w-full px-4 py-2 font-bold bg-emerald-300 rounded-lg hover:bg-emerald-500 hover:text-white
                        focus:outline-none focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out cursor-pointer">Submit</button>
            </form>
        </div>
    </body>
</html>
