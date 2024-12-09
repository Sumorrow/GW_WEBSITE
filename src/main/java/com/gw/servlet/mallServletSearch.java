package com.gw.servlet;

import com.gw.pojo.Goods;
import com.gw.service.GoodsService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mallServletSearch", urlPatterns = "/mallServletSearch")
public class mallServletSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String Id =request.getParameter("id");

        int id =0;
        if(!Id.equals(""))
        {
            id=Integer.parseInt(Id);
        }
        GoodsService goodsService=new GoodsService();
        List<Goods> goodsList=goodsService.showlistbycondition(name,id);
        HttpSession session=request.getSession() ;
        session.setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("/mall.jsp").forward(request,response);

    }
}
