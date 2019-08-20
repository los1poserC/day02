<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dfbz.servlet.User" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jws.soap.SOAPBinding" %><%--
  Created by IntelliJ IDEA.
  com.dfbz.servlet.User: DFBZ
  Date: 2019/8/17
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        td{
            text-align: center;
            width: 100px;
            height: 50px;
            border: 1px solid #000;
        }
        input[type="text"]{
            display: none;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
    <table cellspacing="0" cellpadding="0">
        <tr>
            <td>用户id</td>
            <td>用户名</td>
            <td>操作</td>
        </tr>
        <%
            Object obj=request.getAttribute("list");
            ArrayList<User> list=null;
            if(obj instanceof List){
                list=(ArrayList<User>) obj;
            }
            for (User user:list){

                %>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getUsername()%></td>
                    <td>
                        <form action="delete" method="post">
                            <input type="text" value="<%=user.getId()%>" name="id">
                            <input type="submit" value="删除">
                        </form>
                    </td>
                </tr>
            <%
                }
        %>
    </table>
</body>
</html>
