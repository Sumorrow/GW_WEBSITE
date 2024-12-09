package com.gw.servlet;

import com.gw.pojo.Cart;
import com.gw.service.CartService;
import com.gw.service.GoodsService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "purchaseServlet", urlPatterns = "/purchaseServlet")
public class purchaseServlet extends HttpServlet {
    String operation=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operation=request.getParameter("operation");
        System.out.println("结算中");
        HttpSession session=request.getSession();
//          if(operation==null)
//          {
//              request.getRequestDispatcher("/mall.jsp").forward(request,response);
//          }
        CartService cartService=new CartService();
        List<Cart> cartList=(List<Cart>) session.getAttribute("cartList");

        for (int i=0;i<cartList.size();i++)
        {
            cartService.purchase(cartList.get(i));
        }
//       request.getRequestDispatcher("test.html").forward(request,response);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        writer.write("<h1>购买成功<h1><br>");
        writer.write("  <a href=\"mall.jsp\">返回商城首页</a> </p>");

    }
}

