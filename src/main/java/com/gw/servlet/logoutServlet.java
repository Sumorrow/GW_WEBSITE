package com.gw.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logoutServlet", urlPatterns = "/logoutServlet")
public class logoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("user",null);
        session.setAttribute("goodsList",null);
        session.setAttribute("goods",null);
        session.setAttribute("cart",null);
        session.setAttribute("cartList",null);
        request.getRequestDispatcher("/login.html").forward(request,response);
    }
}

