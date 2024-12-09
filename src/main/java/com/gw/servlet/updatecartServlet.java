package com.gw.servlet;

import com.gw.service.CartService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatecartServlet", urlPatterns = "/updatecartServlet")
public class updatecartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Id=request.getParameter("id");
        String Quantity=request.getParameter("quantity");
        int quantity=Integer.parseInt(Quantity);
        int id=Integer.parseInt(Id);
        CartService cartService=new CartService();
        cartService.update(id,quantity);
        request.getRequestDispatcher("/cartServlet").forward(request,response);
    }
}
