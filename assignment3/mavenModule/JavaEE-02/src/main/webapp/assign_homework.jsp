<%@ page import="model.Homework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 10067
  Date: 2020/3/13
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分配作业</title>
</head>
<body>
<%
    List<Homework> homeworkList = (List<Homework>) request.getAttribute("homeworkList");

    for(Homework homework:homeworkList){
        out.print("<p></p><p></p><form action=\"/assign\">\n" +
                "    <label>作业ID：<input type=\"text\" name=\"hid\" value=" + "'" + homework.getId() + "' readonly></label>\n" +
                "    <label>作业标题：<input type=\"text\" name=\"hid\" value=" + "'" + homework.getTitle() + "' readonly></label>\n" +
                "    <label>添加学生：<input type=\"text\" name=\"students\"></label>\n" +
                "    <input type=\"submit\" value=\"提交\">\n" +
                "</form>");
    }
%>
</body>
</html>
