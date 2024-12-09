package com.gw.servlet;

import com.gw.pojo.Cart;
import com.gw.pojo.Goods;
import com.gw.service.CartService;
import com.gw.service.GoodsService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "selectcartServlet", urlPatterns = "/selectcartServlet")
public class selectcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        String operation=request.getParameter("operation");
        CartService cartService=new CartService();
        Cart cart=cartService.selectById(Integer.parseInt(id));
        request.setAttribute("cart",cart);
        System.out.println(cart);
        if(operation.equals("1"))
            request.getRequestDispatcher("/updatecart.jsp").forward(request,response);
        else if(operation.equals("2"))
            request.getRequestDispatcher("/deletecart.jsp").forward(request,response);

    }
}

