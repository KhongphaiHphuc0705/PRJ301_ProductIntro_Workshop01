<%-- 
    Document   : Login
    Created on : Feb 26, 2025, 9:05:16 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body class="flex items-center justify-center min-h-screen bg-linear-45 from-[#0a8f63] to-[#ceff88]">
        <div class="w-2xl max-w-screen bg-white/25 p-6 rounded-lg shadow-md">
            <h2 class="text-3xl font-bold text-center mb-4">LOG IN</h2>
            
            <form action="Login" method="POST">
                <div class="mb-4">
                    <label for="account" class="block text-sm font-medium">Email</label>
                    <input type="text" name="account" placeholder="Enter username" required
                           class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none 
                                  focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out"
                                  autocomplete="off">
                </div>
                <div class="mb-4">
                    <label for="pass" class="block text-sm font-medium">Password</label>
                    <input type="password" name="pass" placeholder="Enter password" required
                           class="w-full px-4 py-2 mt-1 border rounded-lg focus:outline-none 
                                  focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out">
                </div>
                <div class="flex items-center justify-between mb-4">
                    <label>
                        <input type="checkbox">
                        <span class="ml-2 text-md">Remember me</span>
                    </label>
                    <a href="#" class="text-md text-emerald-500 hover:underline">Forgot password?</a>
                </div>
                <button type="submit" class="w-full px-4 py-2 font-bold bg-emerald-300 rounded-lg hover:bg-emerald-500 hover:text-white
                        focus:outline-none focus:ring-2 focus:ring-emerald-300 transition duration-500 ease-in-out cursor-pointer">Login
                </button>
            </form>
            <p class="mt-4 text-center text-md text-gray-600">
                Don't have an account? <a href='#' class='text-emerald-500 hover:underline'>Sign up</a>
            </p>
        </div>
    </body>
</html>