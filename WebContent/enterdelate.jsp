<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>核酸录入</title>
<link rel="stylesheet" href="login.css">
</head>
<body>

<br><br><br><br><br><br>

<center>
<h1>欢迎来到核酸检测样本采集界面：删除</h1>
</center>

<br><br>

<form  method="get" action="/BigProjectJSP/ServletAdd" >

<center>
<%
session.setAttribute("value1", "qiunannan");
session.setAttribute("value2", "qiunannan");
session.setAttribute("value3", "qiunannan");
session.setAttribute("value4", "qiunannan");
%>


删除序号：<input type="text" name="id"><br><br>

<input type="submit" value="确认">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="取消">

</center>

</form>

</body>
</html>