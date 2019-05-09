<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/memo.css">
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>
	<table id="SearchTable">
		<tr>
			<td align="center">
				<c:if	test="${curPage != 1 && curPage != null}">
					<a href="page.change?p=${curPage-1 }" class="curPoint">&lt;</a>
				</c:if></td>
			<td align="center">
				<form action="mens.search" name="SearchForm">
					<input name="js_txt"placeholder="찾을 내용" id="searchBox">
					<button id="searchButton">검색</button>
				</form>
				<div>${curPage }/${pageCount }</div>
			</td>
			<td align="center">
				<c:if test="${curPage != pageCount }">
					<a href="page.change?p=${curPage+1 }" class="curPoint">&gt;</a>
				</c:if>
			</td>
		</tr>
	</table>


	<c:forEach var="i" items="${AllMemo}">
		<div style="width:200px; height:200px; float:left; clear:both;">
			<img alt="" src="resources/img/${i.js_file}" style="width:200px; height:200px;">
		</div>
		
			<table class="memoInfoTable">
				<tr>
					<th>작성일</th>
					<td>${i.js_date }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${i.js_txt }</td>	
				</tr>
				<tr>
					<td colspan="2"><button class="delButton" onclick="goDelMan(${i.js_no });">삭제</button></td>
				</tr>
			</table>
	</c:forEach>


<div id="writeYourMemo">
		<form action="go.writeMan" method="post" enctype="multipart/form-data">
			<table class="memoTable">
				<tr>
					<td id="WriteSummonImg">손잡이</td>
				</tr>
				<tr>
					<td class="memoTd"colspan="2"><textarea name="js_txt" id="memoTxt"></textarea></td>
				</tr>
				<tr>
					<td class="memoTd"><input type="file" name="js_file"></td>
					<td class="memoTd"><button>작성</button></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>