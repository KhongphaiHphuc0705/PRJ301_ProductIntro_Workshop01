<%-- 
    Document   : UpdateCategory
    Created on : Feb 26, 2025, 8:06:17 AM
    Author     : Windows
--%>

<%@page import="model.dto.Category"%>
<%@page import="model.dao.CategoryDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Category x = (Category) request.getAttribute("typeId");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="/public/Header.jspf" %>
        <div class="mx-auto p-6 bg-gray-800 shadow-lg min-h-screen">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">
                UPDATE CATEGORY
            </h1>
            <form action="MainController" method="POST" class="space-y-4 border-2 border-white p-4 max-w-3xl mx-auto">
                <input type="hidden" name="action" value="UpdateCategory">
                <input type="hidden" name="typeId" value="<%= x.getTypeId() %>">
                <div class="form-group">
                    <label for="categoryName" class="block font-medium text-gray-100">Category name: </label>
                    <input type="text" name="categoryName" value="<%= x.getCategoryName() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg 
                           focus:outline-none focus:ring-2 focus:ring-emerald-400 transition 
                           ease-in-out placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="memo" class="block font-medium text-gray-100">Memo: </label>
                    <textarea name="memo" class="w-full px-4 py-2 mt-4 border border-gray-100 
                           rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-400 
                           transition ease-in-out text-gray-100"><%= x.getMemo() %></textarea>
                </div>
                <button type="submit" class="w-full px-4 py-2 font-bold bg-emerald-300 rounded-lg hover:bg-emerald-500 hover:text-white
                        focus:outline-none focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out cursor-pointer">Submit</button>
            </form>
        </div>
    </body>
</html>
