
<%@ page import="java.util.List" %>
<%@ page import="edu.bjtu.javaee.homework.model.Homework" %>
<%@ page import="edu.bjtu.javaee.homework.model.Student" %>
<%@ page import="edu.bjtu.javaee.homework.model.Submit" %><%--
  Created by IntelliJ IDEA.
  User: 10067
  Date: 2020/3/13
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看学生作业</title>
</head>
<body>

<%
    List<Submit> submitList = (List<Submit>) request.getAttribute("submitList");

    for(Submit submit : submitList){
        String status;
        if (submit.getStatus() == 0)    status = "未提交";
        else status = "已提交";
        out.print("<p></p><p></p><form action=\"/assign\">\n" +
                "    <label>作业ID：<input type=\"text\" value=" + "'" + submit.getHid() + "' readonly></label>\n" +
                "    <label>学生ID：<input type=\"text\" value=" + "'" + submit.getSid() + "'></label>\n" +
                "    <label>提交状态：<input type=\"text\" value=" + "'" + status + "' readonly></label>\n" +
                "    <label>提交时间：<input type=\"text\" value=" + "'" + submit.getSubmit_time() + "' readonly></label>\n" +
                "    <label>作业详情：<input type=\"text\" value=" + "'" + submit.getContent() + "'></label>\n" +
                "</form>");
    }
%>
</body>
</html>
