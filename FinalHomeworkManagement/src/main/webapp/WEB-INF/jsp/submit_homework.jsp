<%@ page import="java.util.List" %>
<%@ page import="edu.bjtu.javaee.homework.model.Homework" %>

<%--
  Created by IntelliJ IDEA.
  User: 10067
  Date: 2020/3/13
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>

<%
    int sid = (int) request.getAttribute("sid");
    List<Homework> homeworkList = (List<Homework>) request.getAttribute("homeworkList");
    List<String> contentList = (List<String>)request.getAttribute("contentList");

    for(int i = 0; i < homeworkList.size(); i++){
        Homework homework = homeworkList.get(i);
        String content = contentList.get(i);
        out.print("<form action=\"/submit\">\n" +
                "    <label>作业ID：<input type=\"text\" name=\"hid\" value=" + "'" + homework.getId() + "' readonly></label>\n" +
                "    <label>作业标题：<input type=\"text\" name=\"hid\" value=" + "'" + homework.getTitle() + "' readonly></label>\n" +
                "    <input type=\"text\" name=\"sid\" value=" + "'" + sid + "'" +  " hidden>\n" +
                "    <label>添加内容：<input type=\"text\" name=\"content\" value='" + content + "'></label>\n" +
                "    <input type=\"submit\" value=\"提交\">\n" +
                "</form>");
    }
%>

</body>
</html>
