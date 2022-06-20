<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>核酸结果界面</title>

<link rel="stylesheet" href="login.css">

</head>
<body>

<br><br><br><br><br><br>

<center>
<h1>欢迎来到核酸结果显示界面</h1><br>

<%
String v1=(String)request.getAttribute("value1");
String v2=(String)request.getAttribute("value2");
String v3=(String)request.getAttribute("value3");
String v4="等待";
String v5="阳性";
String v6="阴性";
%>
学号：<%=v1%><br><br>

姓名：<%=v2%><br><br>

<%if(v3.equals("0")){ %>
核酸结果：<%=v4%>
<%}else{if(v3.equals("1")){ %>
核酸结果：<%=v5%>
<%}else{%>
核酸结果：<%=v6%>
<%}}%>


<br><br>

</center>


<center>


<a href="login.jsp">
<input type="button" value="返回" onclick="window.location.href('login.jsp')">
</a>&nbsp;&nbsp;&nbsp;&nbsp;

<a href="final.jsp">
<input type="button" value="大结局" onclick="window.location.href('final.jsp')">
</a>&nbsp;&nbsp;&nbsp;&nbsp;


</center>


</body>
</html>