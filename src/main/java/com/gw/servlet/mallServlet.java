package com.gw.servlet;

import com.gw.pojo.Goods;
import com.gw.service.GoodsService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mallServlet", urlPatterns = "/mallServlet")
public class mallServlet extends HttpServlet {
    String name=null;
    String id=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService goodsService=new GoodsService();
        List<Goods> goodsList=goodsService.showlist();
        HttpSession session=request.getSession() ;
        session.setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("/mall.jsp").forward(request,response);
    }
}
