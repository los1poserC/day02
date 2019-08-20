package com.dfbz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        Object id=  request.getAttribute("id");
        System.out.println(id);
        try {
            //连接数据库
            String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, "root", "123456");
            Statement stmt = conn.createStatement();

            String sql="delete from sys_user where id="+id+"";
            PreparedStatement prst = conn.prepareStatement(sql);
            prst.executeUpdate();
            PrintWriter out=response.getWriter();
            out.print("<html><head></head><body><h3>删除成功</h3><a href='login'>返回</a></body></html>");
            out.write("true");
//            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
//            <input type='button' action='login' value='返回'>
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
