<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.imooc.domain.Book.*,java.util.*"%>
<%@ include file="../../common.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书查询</title>
<script type="text/javascript" src="<%=basePath%>/resources/js/jquery-3.3.1.js"></script>
<script>
	$(function(){
		$("#search").click(function(){
		$.ajax({
			"url" : "<%=basePath%>/SelectOneBookServlet",
			"type" : "get" ,
			"data" : {"bookID" : $("#bookID").val(),"bookName":$("#bookName").val(),"catgoryName":$("#catgoryName").val()}, 
			"dataType" : "json" ,
			"async": "ture",//异步请求
			"success" : function(json){
				for(var i = 0 ; i < json.length ; i++){
					console.log(json);
					//利用ajax特性，将原有的数据剔除，直接更换新的数据
					$("#cont").replaceWith("<tr><td>" + json[i].bookid + "</td>"+
							               "<td>" + json[i].bookname + "</td>"+
							               "<td>" + json[i].classification + "</td>"+
							               "<td>" + json[i].price + "</td>"+
							               "<td>" + json[i].describe + "</td></tr>");
				}
			},
			"error" : function(xmlhttp , errorText){
				console.log(xmlhttp);
				console.log(errorText);
				if(xmlhttp.status == "405"){
					alert("无效的请求方式");
				}else if(xmlhttp.status == "404"){
					alert("未找到URL资源");
				}else if(xmlhttp.status == "500"){
					alert("服务器内部错误，请联系管理员");
				}else{
					alert("产生异常，请联系管理员");
				}
			}
			
		})
	})
			})
</script>
</head>
<body>
	<center>
		<h1>图书查询</h1>
		<p>
			图书ID：<input type="text" name="bookID" id="bookID">
			图书名：<input type="text" name="bookName" id="bookName">
			分类：<input type="text" name="catgoryName" id="catgoryName">
			<button id="search" type="submit">提交</button>
		
		</p>
		<hr>
		<table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>分类</th>
					<th>价格</th>
					<th>描述</th>
				</tr>
			</thead>
			<tbody id="cont">
			<!-- 使用JSTL表达式显示所有的书目 -->
				
				 <c:forEach items="${list}" var="book">
					<tr>
						<td>${book.getBookid()}</td>
						<td>${book.getBookname()}</td>
						<td>${book.getClassification()}</td>
						<td>${book.getPrice()}</td>
						<td>${book.getDescribe()}</td>
					</tr>
					</c:forEach> 
				
			</tbody>
		</table>
	</center>
	</body>
</html>