<%-- 
    Document   : AddProduct
    Created on : Feb 23, 2025, 5:15:37 PM
    Author     : Windows
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="Header.jspf" %>
        <div class="mx-auto p-6 bg-gray-800 shadow-lg min-h-screen">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">ADD NEW PRODUCT</h1>
            
            <form action="MainController" method="POST" class="space-y-4 border-2 border-white p-4 max-w-3xl mx-auto">
                <input type="hidden" name="action" value="AddProduct">
                <div class="form-group">
                    <label for="productId" class="block font-medium text-gray-100">Product ID: </label>
                    <input type="text" name="productId" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                           focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter product ID">
                </div>
                <div class="form-group">
                    <label for="productName" class="block font-medium text-gray-100">Product name: </label>
                    <input type="text" name="productName" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                           focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100" 
                           autocomplete="off" placeholder="Enter product name">
                </div>
                <div class="form-group">
                    <label for="productImage" class="block font-medium text-gray-100">Product image: </label>
                    <input type="text" name="productImage" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                           focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100" 
                           autocomplete="off" placeholder="Enter product image URL">
                </div>
                <div class="form-group">
                    <label for="brief" class="block font-medium text-gray-100">Brief: </label>
                    <textarea name="brief" class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                           focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out text-gray-100"></textarea>
                </div>
                <div class="form-group">
                    <label for="postedDate" class="block font-medium text-gray-100">Posted date: </label>
                    <input type="date" name="postedDate" class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="typeId" class="block font-medium text-gray-100">Type: </label>
                    <select name="typeId" class="w-full p-2 border rounded-lg 
                            bg-gray-700 border-gray-600 mt-4 text-gray-100">
                        <option value="1">Dụng cụ nhà bếp</option>
                        <option value="2">Điện gia dụng</option>
                        <option value="3">Trang trí nội thất</option>
                        <option value="4">Dụng cụ thể thao</option>
                        <option value="5">Thiết bị thông minh</option>
                        <option value="6">Quần - Áo thời trang</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="account" class="block font-medium text-gray-100">Account: </label>
                    <input type="text" name="account" class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label for="unit" class="block font-medium text-gray-100">Unit: </label>
                    <input type="text" name="unit" class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter unit">
                </div>
                <div class="form-group">
                    <label for="price" class="block font-medium text-gray-100">Price: </label>
                    <input type="number" name="price" class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter price (VNĐ)">
                </div>
                <div class="form-group">
                    <label for="discount" class="block font-medium text-gray-100">Discount (%): </label>
                    <input type="number" name="discount" class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 transition
                           duration-500 ease-in-out placeholder-gray-400 text-gray-100"
                           autocomplete="off" placeholder="Enter discount">
                </div>
                <button type="submit" class="w-full px-4 py-2 font-bold bg-emerald-300 rounded-lg hover:bg-emerald-500 hover:text-white
                        focus:outline-none focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out cursor-pointer">
                    Submit
                </button>
            </form>
        </div>
    </body>
</html>
