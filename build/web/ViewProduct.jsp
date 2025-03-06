<%-- 
    Document   : ViewProduct
    Created on : Mar 6, 2025, 3:33:39 PM
    Author     : Windows
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Product</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <%@include file="Header.jspf" %>
        <div class="bg-gray-800 mx-auto p-6 min-h-screen">
            <a href="ListProduct" class="px-4 py-2 bg-gray-700 text-white rounded hover:bg-gray-600 transition flex gap-2 w-fit">
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                <path stroke-linecap="round" stroke-linejoin="round" d="M6.75 15.75 3 12m0 0 3.75-3.75M3 12h18" />
                </svg>
                Back
            </a>

            <div class="mt-6 flex flex-col md:flex-row items-center md:items-center justify-center gap-8">
                <div class="w-full md:w-1/3">
                    <img src="<c:url value='${product.productImage}'/>" 
                         alt="${product.productName}" 
                         class="w-full h-auto rounded shadow-lg">
                </div>

                <div class="w-full md:w-1/2 md:pl-6">
                    <h1 class="text-3xl font-bold text-gray-100">${product.productName}</h1>
                    <p class="text-green-400 text-2xl font-bold mt-2">
                        <fmt:formatNumber value="${product.price * (100 - product.discount) / 100}"
                                          type="number" maxFractionDigits="0"/>đ 
                        <c:if test="${product.discount > 0}">(-${product.discount}%)</c:if>
                        </p>
                    <c:if test="${product.discount > 0}">
                        <p class="text-red-400 font-bold mt-2 line-through">
                            <fmt:formatNumber value="${product.price}" type="number" maxFractionDigits="0" />đ
                        </p>
                    </c:if>

                    <div class="bg-gray-800 p-4 mt-4 rounded">
                        <p class="text-gray-100"><strong>Posted:</strong> ${product.postedDate}</p>
                        <p class="text-gray-100"><strong>Category:</strong> ${product.type.categoryName}</p>
                        <p class="text-gray-100"><strong>Unit:</strong> ${product.unit}</p>
                        <p class="text-gray-100"><strong>Posted by:</strong> ${product.account.account}</p>
                    </div>

                    <p class="mt-4 text-gray-300">${product.brief}</p>

                    <div class="mt-6 flex">
                        <a href="UpdateProduct?productId=${product.productId}" 
                           class="px-4 py-2 bg-blue-500 text-white rounded mr-4 hover:bg-blue-600 transition flex gap-2">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                            <path stroke-linecap="round" stroke-linejoin="round" d="m16.862 4.487 1.687-1.688a1.875 1.875 0 1 1 2.652 2.652L6.832 19.82a4.5 4.5 0 0 1-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 0 1 1.13-1.897L16.863 4.487Zm0 0L19.5 7.125" />
                            </svg> Update
                        </a>
                        <a href="DeleteProduct?deletePd=${product.productId}" 
                           class="px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600 transition flex gap-2">
                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" class="size-6">
                            <path stroke-linecap="round" stroke-linejoin="round" d="m14.74 9-.346 9m-4.788 0L9.26 9m9.968-3.21c.342.052.682.107 1.022.166m-1.022-.165L18.16 19.673a2.25 2.25 0 0 1-2.244 2.077H8.084a2.25 2.25 0 0 1-2.244-2.077L4.772 5.79m14.456 0a48.108 48.108 0 0 0-3.478-.397m-12 .562c.34-.059.68-.114 1.022-.165m0 0a48.11 48.11 0 0 1 3.478-.397m7.5 0v-.916c0-1.18-.91-2.164-2.09-2.201a51.964 51.964 0 0 0-3.32 0c-1.18.037-2.09 1.022-2.09 2.201v.916m7.5 0a48.667 48.667 0 0 0-7.5 0" />
                            </svg> Delete
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
