package com.gw.servlet;

import com.gw.mapper.UsersMapper;
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

@WebServlet(name = "registerServlet", urlPatterns = "/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
//        int id = 0;
//        try {
//            id = usersMapper.add(username, password, email);
//        }catch (Exception e2) {
//            e2.printStackTrace();
//        }
//
//        sqlSession.close();
        UserService userService=new UserService();
        Users users=userService.Register(username,password,email);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        System.out.println(users);
        if(users!=null)
        {
            writer.write("register success");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }
        else
        {
            writer.write("register failed");
            writer.write(" <p>back to  <a href=\"register.html\">Register</a> now!</p>");
            writer.write(" <p>back to  <a href=\"login.html\">Login</a> now!</p>");
        }

    }
}
