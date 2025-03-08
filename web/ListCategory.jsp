<%-- 
    Document   : ListCategories
    Created on : Feb 23, 2025, 4:41:59 PM
    Author     : Windows
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of categories</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="Header.jspf" %>
        <div class="mx-auto p-6 bg-gray-800 shadow-lg min-h-screen overflow-x-auto">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">
                LIST OF CATEGORIES
            </h1>
            <table class="table-auto w-full border-collapse border-2 border-gray-300">
                <thead>
                    <tr class="bg-gray-800 text-gray-100">
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Type ID</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Category name</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2 xl:w-150">Memo</th>
                        <th class="border border-gray-300 bg-gray-900 px-4 py-2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="x" items="${listCategory}">
                        <tr class="border border-gray-300 hover:bg-gray-700 transition">
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${x.typeId}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">${x.categoryName}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 xl:w-150 text-center">${x.memo}</td>
                            <td class="border border-gray-300 px-4 py-2 text-gray-100 text-center">
                                <c:url var="urlUpdate" value="MainController">
                                    <c:param name="action" value="UpdateCategory" />
                                    <c:param name="typeId" value="${x.typeId}" />
                                </c:url>
                                <a href="${urlUpdate}" class="px-3 py-1 mr-3 bg-blue-400 text-white rounded-lg hover:bg-blue-600 transition">Update</a>
                                <c:url var="urlDelete" value="MainController">
                                    <c:param name="action" value="DeleteCategory" />
                                    <c:param name="typeId" value="${x.typeId}" />
                                </c:url>
                                <a href="${urlDelete}" class="px-3 py-1 mr-3 bg-red-400 text-white rounded-lg hover:bg-red-600 transition">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
