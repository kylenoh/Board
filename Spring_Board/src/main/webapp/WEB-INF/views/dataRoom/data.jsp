<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/data.css">
</head>
<body>

<h1>데이터 페이지입니다.</h1>


<c:forEach var="i" items="${datas }">
	<table class="dataInfoTable">
		<tr>
			<td class="infoTd">${i.js_title }</td>
			<td class="infoTd">${i.js_date }</td>
		</tr>
		<tr>
			<td class="infoTd">${i.js_uploader }</td>
			<td class="infoTd">${i.js_cate }</td>
		</tr>
		<tr>
			<td colspan="2" class="infoTd">
				<a href="resources/file/${i.js_file }">
					<img src="resources/file/cloud_download_black_18dp.png" style="height: 50px; cursor: pointer; text-align:center">
				</a>
			</td>
		</tr>
			<tr>
				<td colspan="2" style="height:20px;">
					<c:if test="${sessionScope.loginMember.js_id == i.js_uploader }">		
						<button class="infoButton" onclick="deleteData(${i.js_no});">삭제</button>
					</c:if>	
				</td>
			</tr>
	</table>
</c:forEach>



<div id="uploadFile">
		<form action="go.upload" method="post" enctype="multipart/form-data">
			<table class="dataTable">
				<tr>
					<td><input value="${sessionScope.loginMember.js_id }" readonly="readonly" name="js_uploader" type="hidden"></td>
					<td class="dataTd"><input name="js_title" placeholder="제목 입력"></td>
					<td class="dataTd">
						<select name="js_cate">
							<option value="book">교재</option>
							<option value="preview">예제</option>
							<option value="program">프로그램</option>
							<option value="etc">기타</option>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="dataTd"><input type="file" name="js_file"></td>
					<td class="dataTd"><button>작성</button></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>