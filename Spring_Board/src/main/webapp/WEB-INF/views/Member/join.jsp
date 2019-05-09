<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/join.css">
</head>
<body>

	<h1>회원가입 페이지 입니다.</h1>
	
	<form action="go.reg" method="post" enctype="multipart/form-data">
		<table id="joinTable">
			<tr>
				<th>ID</th>
				<td class="joinTd"><input name="js_id"><span>ID확인</span></td>
			</tr>
			<tr>
				<th>PW</th>
				<td class="joinTd"><input name="js_pw"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td class="joinTd"><input name="js_name"></td>
			</tr>
			<tr>
				<th>EMail</th>
				<td class="joinTd"><input name="js_email"></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td class="joinTd"><input><span>검색</span></td>
			</tr>	
			<tr>
				<th>주소</th>
				<td class="joinTd"><input name="js_addr"></td>
			</tr>		
			<tr>
				<th>사진</th>
				<td class="joinTd"><input name="js_photo" type="file"></td>				
			</tr>
			<tr>
				<td colspan="2" class="joinTd"><button>등록</button></td>
			</tr>
		</table>
	</form>
	
</body>
</html>