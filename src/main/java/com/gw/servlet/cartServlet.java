package com.gw.servlet;

import com.gw.pojo.Cart;
import com.gw.pojo.Goods;
import com.gw.pojo.Users;
import com.gw.service.CartService;
import com.gw.service.GoodsService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cartServlet", urlPatterns = "/cartServlet")
public class cartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService=new CartService();
        HttpSession session=request.getSession() ;
        Users users=(Users) session.getAttribute("user");
        if (users == null) {
            response.sendRedirect("/untitled1_war/login.html");  // 如果没有登录，跳转到登录页面
            return;  // 停止进一步处理
        }

        System.out.println(users.getId());
        List<Cart> cartList=cartService.showlist(users.getId());

        session.setAttribute("cartList",cartList);
        double totalprice=0;
        for(int i=0;i<cartList.size();i++)
        {
            totalprice=totalprice+cartList.get(i).getPrice()*cartList.get(i).getQuantity();
            System.out.println(cartList.get(i));
        }
        session.setAttribute("totalprice",totalprice);
        request.getRequestDispatcher("/cart.jsp").forward(request,response);
    }
}

