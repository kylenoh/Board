<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>
	<div id="login">
		<form action="go.bye" id="logForm">
			<table>
				<tr>
					<td>
						<div>
							<img alt="" src="resources/img/${sessionScope.loginMember.js_photo }" id ="loginImg">
						</div>
					</td>
					<td>${sessionScope.loginMember.js_name }님 접속을 환영합니다.</td>
					<td><button class="logButton">로그아웃</button></td>
				</tr>
			</table>
		</form>
		<button class="updateButton" onclick="goUpdate();">회원정보수정</button>
	</div>
</body>
</html>