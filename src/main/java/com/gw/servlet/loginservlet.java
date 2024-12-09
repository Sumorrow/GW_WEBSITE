package com.gw.servlet;

import com.gw.mapper.GoodsMapper;
import com.gw.mapper.UsersMapper;
import com.gw.pojo.Goods;
import com.gw.pojo.Users;
import com.gw.service.UserService;
import com.gw.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "loginservlet", urlPatterns = "/loginservlet")
public class loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService=new UserService();
        Users users=userService.Login(username,password);
        System.out.println(users);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        if(users!=null)
        {
            writer.write("login success");
            HttpSession session=request.getSession() ;
            session.setAttribute("user",users);
            request.getRequestDispatcher("/mallServlet").forward(request,response);
        }
        else
        {
            writer.write("login failed");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }
    }
}
