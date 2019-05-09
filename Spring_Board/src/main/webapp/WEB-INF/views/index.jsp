<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/summonInput.js"></script>
<script type="text/javascript">
	$(function(){
		connectSummonEvent();
	});
</script>
</head>
<body>
	<header id="bodyInHeader">
		<div id="logSection" style="border-bottom:1px solid #757575;">
			<jsp:include page="${loginPage }"></jsp:include>
		</div>
			<h1 onclick="goIndex();" style=" display: block;">자바 보안 코딩 빅데이터 개발자 양성과정.Spring</h1>
			
			<p style="float:right;">${w.description } : ${w.temp }℃ (${w.humidity }%)</p>
			<div>
				<form action="search.naver" style="display: inline;">
					<span>네이버쇼핑</span><input name="query" id="searchNaver"><button id="searchButton">실행</button>
				</form>
			</div>
			<ul class="nav-list" style="clear: both;">
				<li><a href="go.index">Home</a></li>
				<li><a href="go.contact">Contact Us</a></li>
				<li><a href="go.memo">Memo</a></li>
				<li onclick="goMan();"><a>Only Man</a></li>
				<li><a href="go.data">DataRoom</a></li>
			</ul>
	</header>
	
		<img alt="" src="resources/img/beach.jpg" id="sliderArticle">

	<section style="margin:0 auto; width:1100px; margin-top:30px;">
		<jsp:include page="${contentPage}"></jsp:include>
	</section>

	<footer> </footer>

</body>
</html>