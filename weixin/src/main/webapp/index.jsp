<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>首页</title>
</head>
<body>

	<div style="margin: 0 auto; padding-top: 100px; font-size: 18px;"
		align="center">
		<h2>Add Book</h2>
		<form method="post" action="<%=request.getContextPath()%>/book/add">
			book:<input type="text" name="name" id="name"> author:<input
				type="text" name="author" id="author"> <input type="submit"
				value="Add">
		</form>
	</div>
</body>
</html>
