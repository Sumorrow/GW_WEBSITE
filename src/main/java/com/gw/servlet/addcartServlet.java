package com.gw.servlet;

import com.gw.service.CartService;
import com.gw.service.GoodsService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addcartServlet", urlPatterns = "/addcartServlet")
public class addcartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Usersid=request.getParameter("usersid");
        String Goodsid=request.getParameter("goodsid");
        String goodsname=request.getParameter("goodsname");
        String Price=request.getParameter("price");
        String Quantity=request.getParameter("quantity");
        double price=Double.valueOf(Price);
        int usersid=Integer.parseInt(Usersid);
        int goodsid=Integer.parseInt(Goodsid);
        int quantity=Integer.parseInt(Quantity);
        CartService cartService=new CartService();
        cartService.add(usersid,goodsid,quantity,price,goodsname);
        request.getRequestDispatcher("/mallServlet").forward(request,response);
    }
}
