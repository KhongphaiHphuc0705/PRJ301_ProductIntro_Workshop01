<%-- 
    Document   : UpdateAccount
    Created on : Feb 25, 2025, 7:48:46 PM
    Author     : Windows
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.dto.Account"%>
<%@page import="model.dao.AccountDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Account acc = (Account) request.getAttribute("account");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Account</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="/public/Header.jspf" %>
        <div class="mx-auto p-6 bg-gray-800 shadow-lg min-h-screen">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">
                UPDATE ACCOUNT
            </h1>
            <form action="MainController" method="POST" class="space-y-4 border-2 border-white p-4 max-w-3xl mx-auto">
                <input type="hidden" name="action" value="UpdateAccount">
                <div class="form-group">
                    <label for="account" class="block font-medium text-gray-100">Account </label>
                    <input placeholder="Enter email" type="text" name="account" value="<%= acc.getAccount() %>" 
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                                  focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out
                                  placeholder-gray-400 text-gray-100" readonly>
                </div>
                <div class="form-group">
                    <label for="pass" class="block font-medium text-gray-100">Password </label>
                    <input placeholder="Enter password" type="password" name="pass" value="<%= acc.getPass() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                                  focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out
                                  placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="lastName" class="block font-medium text-gray-100">Last name </label>
                    <input placeholder="Last name" type="text" name="lastName" value="<%= acc.getLastName() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                                  focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out
                                  placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="firstName" class="block font-medium text-gray-100">First name </label>
                    <input placeholder="First name" type="text" name="firstName" value="<%= acc.getFirstName() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                                  focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out
                                  placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="phone" class="block font-medium text-gray-100">Phone number </label>
                    <input placeholder="Phone number" type="text" name="phone" value="<%= acc.getPhone() %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none 
                                  focus:ring-2 focus:ring-emerald-400 transition duration-500 ease-in-out
                                  placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="birthday" class="block font-medium text-gray-100">Birth day </label>
                    <input type="date" name="birthday" 
                           value="<%= new SimpleDateFormat("yyyy-MM-dd").format(acc.getBirthday()) %>"
                           class="w-full px-4 py-2 mt-4 border border-gray-100 rounded-lg focus:outline-none focus:ring-2 
                           focus:ring-emerald-400 transition duration-500 ease-in-out placeholder-gray-400 text-gray-100">
                </div>
                <div class="form-group">
                    <label for="gender" class="block font-medium text-gray-100">Gender </label>
                    <div class="flex space-x-4 mt-3">
                        <label>
                            <input type="radio" name="gender" value="male" <%= acc.isGender() ? "checked" : ""%> class="text-blue-500 mr-2"> 
                            <span class="text-gray-100">Male</span>
                        </label>
                        <label>
                            <input type="radio" name="gender" value="female" <%= !acc.isGender() ? "checked" : ""%> class="text-blue-500 mr-2"> 
                            <span class="text-gray-100">Female</span>
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="roleInSystem" class="block font-medium text-gray-100">Role in system </label>
                    <select name="roleInSystem" class="w-full p-2 border rounded-lg 
                            bg-gray-700 border-gray-600 mt-4 text-gray-100">
                        <option value="1" <%= acc.getRoleInSystem() == 1 ? "selected" : "" %>>Administrator</option>
                        <option value="2" <%= acc.getRoleInSystem() == 2 ? "selected" : "" %>>Staff</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="block font-medium text-gray-100">
                        <input type="checkbox" name="isUse" <%= acc.isIsUse() ? "checked" : "" %> class="mr-2">  Is active
                    </label>
                </div>
                <button type="submit" class="w-full px-4 py-2 font-bold bg-emerald-300 rounded-lg hover:bg-emerald-500 hover:text-white
                        focus:outline-none focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out cursor-pointer">Submit</button>
            </form>
        </div>
    </body>
</html>
