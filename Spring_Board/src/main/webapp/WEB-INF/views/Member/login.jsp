<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>
	<div id="login">
		<form action="chk.login" id="logForm" method="post">
			<table id="logTable">
				<tr>
					<th style="margin:1px;">ID</th>
					<td style="margin:1px;"><input class="logInput" name="js_id"></td>
					<th style="margin:1px;">PW</th>
					<td style="margin:1px;"><input class="logInput" name="js_pw"></td>
					<td style="margin:1px;"><input type="checkbox" name="js_auto">자동로그인</td>
					<th style="margin:1px;"><button class="logButton1">로그인</button></th>
				</tr>
			</table>
		</form>
		<button onclick="goJoin();" class="joinButton">회원가입</button>
	</div>
</body>
</html>