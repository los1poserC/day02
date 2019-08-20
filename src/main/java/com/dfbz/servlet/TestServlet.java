package com.dfbz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");

//            String id=request.getParameter("id");
//            String username=request.getParameter("username");

//            int id=Integer.parseInt(request.getParameter("id"));

            try {
                //连接数据库
                String url="jdbc:mysql://127.0.0.1:3306/mydatabase";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, "root", "123456");
                Statement stmt = conn.createStatement();

                //操作
//                String spl="insert into sys_user(id,name) values('"+id+"','"+username+"')";
//                PreparedStatement prstt = conn.prepareStatement(spl);
//                prstt.executeUpdate(spl);
                String sql = "select * from sys_user";
                PreparedStatement prst = conn.prepareStatement(sql);
                //结果集
                ResultSet rs = prst.executeQuery();
                ArrayList<User> list=new ArrayList<>();
                while (rs.next()) {
                    System.out.println("用户名:" + rs.getString("name")+"id:"+rs.getString("id"));
                    String name=rs.getString("name");
                    String id1=rs.getString("id");
                    User user=new User(id1,name);
                    list.add(user);
                }
                request.setAttribute("list", list);
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
                rs.close();
                prst.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
