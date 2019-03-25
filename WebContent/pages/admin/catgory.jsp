<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../common.jsp" %>
<% 
   String flag=request.getParameter("flag");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书分类添加</title>
<script type="text/javascript">
    var flag = '<%=flag%>';
	if ("1" == flag) {
		alert("添加分类成功！");
	}
	if ("2" == flag) {
		alert("添加分类信息错误，ID，名字和描述不能留空！");
	}
	if ("3" == flag) {
		alert("添加分类信息错误，ID不能非数字！");
	}
</script>
</head>
<body>
	<center>
		<h1>图书分类添加</h1>
		<form action="<%=basePath%>/CatgoryServlet" method="post">
			<table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>分类ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>名&nbsp;字</td>
					<td><input type="text" name="catgoryName"></td>
				</tr>
				<tr>
					<td>描&nbsp;述</td>
					<td><input type="text" name="description"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="添加">
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>