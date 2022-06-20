<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户上传界面</title>

<link rel="stylesheet" href="login.css">

</head>
<body>

<br><br><br><br><br><br>

<center>
<h1>欢迎来到检测结果上传界面</h1>
</center>
	
	
<form  method="get" action="/BigProjectJSP/Servlet7" >

<center>

试管编号：<input type="text" name="tubeid"><br><br>

检测结果：
<select name="hesuan">
	<option value="1">阳性</option>
	<option value="2">阴性</option>
</select><br><br>





<input type="submit" value="提交">
&nbsp;&nbsp;&nbsp;&nbsp;



</center>
</form>


</body>
</html>