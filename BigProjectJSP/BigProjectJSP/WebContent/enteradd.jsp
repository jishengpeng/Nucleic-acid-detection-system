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
<h1>欢迎来到核酸检测样本采集界面：增加</h1>
</center>

<br><br>

<form  method="get" action="/BigProjectJSP/ServletAdd" >

<center>
<%
String v1=(String)request.getAttribute("value1");
String v2=(String)request.getAttribute("value2");
String v3=(String)request.getAttribute("value3");
String v4=(String)request.getAttribute("value4");
session.setAttribute("value1", v1);
session.setAttribute("value2", v2);
session.setAttribute("value3", v3);
session.setAttribute("value4", v4);
%>

学号：<%=v1%><br><br>

姓名：<%=v2%><br><br>

序号：<%=v3%><br><br>




<input type="submit" value="确认">
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="取消">

</center>

</form>

</body>
</html>