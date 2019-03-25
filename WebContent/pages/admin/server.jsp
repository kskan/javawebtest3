<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp" %>
<% 
   String flag=request.getParameter("flag");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理系统</title>
<script type="text/javascript">
    var flag = '<%=flag%>';
    if("1"==flag){
    	alert("登陆成功，欢迎进入图书管理系统！");
    }
</script>

</head>
<frameset rows="20%,*">
	<frame src="<%=basePath%>/pages/admin/top.jsp"></frame>
	<frameset cols="10%,*">
		<frame src="<%=basePath%>/pages/admin/left.jsp"></frame>
		<frame name="main"></frame>
	</frameset>
</frameset>
</html>