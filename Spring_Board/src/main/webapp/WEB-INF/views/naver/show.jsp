<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/memo.css">
</head>
<body>
	<c:forEach var="i" items="${items }">
		<div style="width:200px; height:220px; float:left; clear:both;">
			<img alt="" src="${i.image }" style="width:150px; height:150px;">
		</div>
		
			<table class="naverInfoTable">
				<tr>
					<th>이름</th>
					<td>${i.title }</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>최저가:${i.lprice } - 최고가:${i.hprice }(원)</td>
				</tr>
				<tr>
					<th>링크</th>
					<td><a href="${i.link }">${i.link }</a></td>	
				</tr>
			</table>
	</c:forEach>
	

			
	
</body>
</html>