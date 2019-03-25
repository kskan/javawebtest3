<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<body>
	<center>
		<h1>
			图书后台管理系统
			<c:if test="${session.loginUser!=null}">
				<span style="font-size: 12px">您好，${sessionScope.loginUser}</span>
			</c:if>
		</h1>
	</center>
</body>
</html>
