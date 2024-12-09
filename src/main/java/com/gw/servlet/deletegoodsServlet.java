package com.gw.servlet;

import com.gw.pojo.Goods;
import com.gw.service.GoodsService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deletegoodsServlet", urlPatterns = "/deletegoodsServlet")
public class deletegoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        Goods goods=new Goods();
        goods.setId(Integer.parseInt(id));
        GoodsService goodsService=new GoodsService();
        int flag=goodsService.delete(goods);
        if(flag==1)
        {
            request.getRequestDispatcher("/mallServlet").forward(request,response);}
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer=response.getWriter();
            writer.write("login failed");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }
    }
}
