<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta http-equiv="refresh" content="2;url=pictureSetting.action">
</head>
<body>


<h1 style="color: red" align="center">
<% out.print("上传失败"); %>
</h1>

<h3 style="color: red;">${error}</h3>

<p>3秒后返回........</p>



</body>
</html>