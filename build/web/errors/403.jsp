<%-- 
    Document   : AccessDenied
    Created on : Mar 11, 2025, 7:58:43 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body class="flex items-center justify-center min-h-screen bg-gray-800">
        <div class="w-2xl max-w-screen flex flex-col justify-center align-center">
            <h1 class="text-3xl font-bold mt-4 mb-8 text-gray-100 text-center">ACCESS DENIED</h1>
            <p class="text-lg mt-4 mb-8 text-gray-100 text-center">Sorry, you are not authorized to access this page.</p>
            <a href="${pageContext.request.contextPath}/"
               class="px-4 py-2 mt-4 font-bold bg-emerald-300 rounded-lg text-center hover:bg-emerald-500 hover:text-white  
                      focus:outline-none focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out cursor-pointer">Return to Home</a>
        </div>
    </body>
</html>