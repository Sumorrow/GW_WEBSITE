package com.gw.servlet;

import com.gw.pojo.Goods;
import com.gw.service.GoodsService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updategoodsServlet", urlPatterns = "/updategoodsServlet")
public class updategoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String id=request.getParameter("id");
        String Price=request.getParameter("price");
        String description=request.getParameter("description");
        double price=Double.valueOf(Price);
        Goods goods=new Goods();
        goods.setId(Integer.parseInt(id));
        goods.setName(name);
        goods.setPrice(price);
        goods.setDescription(description);
        GoodsService goodsService=new GoodsService();
        int flag=goodsService.update(goods);
        if(flag==1)
        {
            request.getRequestDispatcher("/mallServlet").forward(request,response);}
        else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer=response.getWriter();
            writer.write("update failed");
            writer.write(" <p>back to  <a href=\"mall.jsp\">mall</a> now!</p>");
        }
    }
}

