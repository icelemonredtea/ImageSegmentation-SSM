<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript">

	//获取当前时间，组合成格式方便存入数据库，不需要格式转换器
	function showtime() {
		var date = new Date();
		
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var hour = date.getHours();
		var minute = date.getMinutes();
		var second = date.getSeconds();
		
		//alert(year+'年'+month+'月'+day+'日 '+hour+':'+minute+':'+second)
		//拼接空格时''中要有一个空格，如' '所示。
		var time = year+'-'+month+'-'+day+' '+hour+':'+minute+':'+second;
		//alert( year+'-'+onth+'-'+day+' '+hour+':'+minute+':'+second);	
	
		document.getElementById("time").value=time;
	}
	
	//验证表单是否为空（时间和文件）
	function checkForm(){
		if (document.getElementById("time").value == "" || 
				document.getElementById("upfile").value == "") {
			alert("时间或文件未选取");
			return false;
		} else {
			return true;
		}
	}
	
	
</script>
</head>
<body>
<h1 align="center">遥感图像分割</h1>
<a href="${pageContext.request.contextPath}/solution.action">进行处理</a>
<div align="center">
	<form action="${pageContext.request.contextPath}/savePicture.action" method="post" 
	enctype="multipart/form-data" onsubmit="return checkForm()">
	提交时间：<input type="text" id="time" name="picture.date" readonly="readonly"/>
		   <input type="button" value="获取当前时间" onclick="showtime()"/>
		   <br/><br/>
	分割类型：<input type="radio" name="picture.method" value="K-means" checked="checked"/>K均值分割
		   <input type="radio" name="picture.method" value="xxx"/>xxx分割
		   <br/><br/>
	上传图片：<input type="file" id="upfile" name="uploadpicture" style="color: red">
		   <br/><br/>
		<input type="submit"/>
		<input type="reset"/> 
	</form>
</div><hr/>

<table align="center" width="1100px">
	<tr>
		<th>原始图像</th>
		<th>分割图像</th>
	</tr>
	<tr>
	<td height="500px"><img alt="未加载" src="${pageContext.request.contextPath}/upload/src/${uploadpictureFileName}"
						width="800" height="460">
	</td>
	<td height="500px"><img alt="无图像" src="${pageContext.request.contextPath}/upload/dest/${uploadpictureFileName}"
						width="800" height="460">
	
	</td>
	
	</tr>
	<tr><td colspan="6" align="center">${fileName}</td></tr>
</table>


</body>
</html>