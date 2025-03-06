<%-- 
    Document   : ListProduct
    Created on : Feb 23, 2025, 7:23:39 PM
    Author     : Windows
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of products</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="Header.jspf" %>
        <div class="mx-auto p-6 bg-gray-800 shadow-lg min-h-screen overflow-x-auto">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">
                LIST OF PRODUCTS
            </h1>
            
            <form action="ListProduct" method="GET" class="mb-4 flex justify-center">
                <input type="text" name="search" placeholder="Search for products"
                       class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none placeholder-gray-400 
                              text-gray-100 focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out" 
                       value="${param.search}" autocomplete="off">
                <button type="submit" class="ml-2 px-4 py-2 bg-emerald-500 text-white rounded-lg hover:bg-emerald-700">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                    <path stroke-linecap="round" stroke-linejoin="round" d="m21 21-5.197-5.197m0 0A7.5 7.5 0 1 0 5.196 5.196a7.5 7.5 0 0 0 10.607 10.607Z" />
                    </svg>
                </button>
            </form>
                
            <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-8 mt-10">
                <c:forEach var="x" items="${listProduct}">
                    <div class="bg-gray-700 p-4 rounded-lg shadow-lg flex flex-col justify-between h-full">
                        <img src="<c:url value='${x.productImage}'/>" alt="${x.productName}" class="w-full h-48 object-cover rounded-t-lg">
                        <h2 class="text-gray-100 text-lg font-bold mt-2">${x.productName}</h2>
                        <p class="text-lg font-bold text-green-400 mt-2">
                                <fmt:formatNumber value="${x.price * (100 - x.discount) / 100}"
                                                  type="number" maxFractionDigits="0"/>đ 
                                <c:if test="${x.discount > 0}">(-${x.discount}%)</c:if>
                                </p>
                            <c:if test="${x.discount > 0}">
                                <p class="text-red-400 font-bold mt-2 line-through">
                                    <fmt:formatNumber value="${x.price}" type="number" maxFractionDigits="0" />đ
                                </p>
                            </c:if>
                        <div class="flex-grow"></div>
                        <div class="mt-4 flex text-blue-400 hover:underline text-center self-center gap-2">
                            <c:url var="urlDetails" value="ViewProduct?productId=${x.productId}"/>
                            <a href="${urlDetails}">More Details </a>
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                                <path stroke-linecap="round" stroke-linejoin="round" d="M17.25 8.25 21 12m0 0-3.75 3.75M21 12H3" />
                            </svg>
                        </div>
                    </div>
                </c:forEach>
            </div> 
        </div>
    </body>
</html>
