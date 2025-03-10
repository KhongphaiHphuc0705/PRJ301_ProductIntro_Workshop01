<%-- 
    Document   : ListAccount
    Created on : Feb 23, 2025, 3:51:46 PM
    Author     : Windows
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of account</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="/public/Header.jspf" %>
        <div class="mx-auto p-6 bg-gray-800 shadow-lg min-h-screen overflow-x-auto">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">
                LIST OF ACCOUNTS IN SYSTEM
            </h1>
            
            <form action="MainController" method="GET" class="mb-4 flex justify-center">
                <input type="hidden" name="action" value="ListAccount">
                <input type="text" name="search" placeholder="Search for accounts"
                       class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none placeholder-gray-400 
                              text-gray-100 focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out" 
                       value="${param.search}" autocomplete="off">
                <button type="submit" class="ml-2 px-4 py-2 bg-emerald-500 text-white rounded-lg hover:bg-emerald-700">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                    <path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
                    </svg>
                </button>
            </form>
                
            <table class="table-auto w-full border-collapse border-2 border-gray-300">
                <thead>
                    <tr class="bg-gray-800 text-gray-100">
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Account</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Full Name</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Birthday</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Gender</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Phone</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Role in system</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="x" items="${listAccount}">
                        <tr class="border border-gray-300 hover:bg-gray-700 transition">
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${x.account}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${x.lastName}, ${x.firstName}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${x.birthday}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${x.gender ? 'Male' : 'Female'}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${x.phone}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${(x.roleInSystem == 1) ? 'Administrator' : 'Staff'}</td>
                            <td class="border border-gray-300 px-4 py-2 text-center">
                                <c:url var="urlUpdate" value="MainController">
                                    <c:param name="action" value="UpdateAccount" />
                                    <c:param name="account" value="${x.account}" />
                                </c:url>
                                <a href="${urlUpdate}" class="px-3 py-1 mr-3 bg-blue-400 text-white rounded-lg hover:bg-blue-600 transition">Update</a>
                                <c:url var="urlToggleStatus" value="MainController">
                                    <c:param name="action" value="ToggleStatus" />
                                    <c:param name="account" value="${x.account}" />
                                    <c:param name="isUse" value="${x.isUse}" />
                                </c:url>
                                <a href="${urlToggleStatus}" class="px-3 py-1 mr-3 bg-green-400 text-white rounded-lg hover:bg-green-600 transition">
                                    ${x.isUse ? 'Deactivate' : 'Activate'}
                                </a>
                                <c:url var="urlDelete" value="MainController">
                                    <c:param name="action" value="DeleteAccount" />
                                    <c:param name="account" value="${x.account}" />
                                </c:url>
                                <a href="${urlDelete}" class="px-3 py-1 bg-red-400 text-white rounded-lg hover:bg-red-600 transition">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
