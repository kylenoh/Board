<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/detail.css">
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>

	<div id="ImgSection">
		<img alt="" src="resources/img/${sessionScope.loginMember.js_photo }" style="width:500px; height:500px;">
	</div>


<div id="infoDiv">
	<form action="run.update" method="post" enctype="multipart/form-data">
		<table id="detailTable">
			<tr>
				<th>아이디</th>
				<td class="detailTd"><input value="${sessionScope.loginMember.js_id }" readonly="readonly" name="js_id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td class="detailTd"><input value="${sessionScope.loginMember.js_pw }" name="js_pw"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td class="detailTd"><input value="${sessionScope.loginMember.js_name }" name="js_name"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td class="detailTd"><input value="${sessionScope.loginMember.js_email }" name="js_email"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td class="detailTd"><input value="${sessionScope.loginMember.js_addr }" name="js_addr">	</td>
			</tr>
			<tr>
				<th>파일</th>
				<td class="detailTd"><input type="file" name="js_photo" value="${sessionScope.loginMember.js_photo }"></td>
			</tr>
			<tr>
				<td class="detailTd" colspan="2"><button>수정</button></td>
			</tr>
		</table>
	</form>
</div>
		<button onclick="runDelete('${sessionScope.loginMember.js_id }');" class="deleteButton">삭제</button>

</body>
</html>