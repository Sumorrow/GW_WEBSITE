package com.gw.servlet;

import com.gw.service.CartService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deletecartServlet", urlPatterns = "/deletecartServlet")
public class deletecartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id=request.getParameter("id");
        int id=Integer.parseInt(Id);
        CartService cartService=new CartService();
        cartService.del(id);
        request.getRequestDispatcher("/cartServlet").forward(request,response);
    }
}
