<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<form action="memo.search" name="SearchForm">
						<input name="js_txt" placeholder="찾을 내용" id="searchBox">
						<button id="searchButton">검색</button>
					</form>
					<div>${curPage }/${pageCount }</div>
				</td>
			</tr>
	</table>
	
	<c:forEach var="i" items="${AllMemo}">
		<div style="width:200px; height:200px; float:left; clear:both;">
			<img alt="" src="resources/img/${i.js_file}" style="width:200px; height:200px;">
		</div>
		
			<table class="memoInfoTable">
				<tr>
					<th>작성자</th>
					<td>${i.js_writer }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${i.js_date }</td>
				</tr>
				<tr style="border-bottom:1px solid #757575;">
					<th>내용</th>
					<td>${i.js_txt }</td>	
				</tr>
				<c:forEach var="sr" items="${i.js_memo_Reply}">
					<c:if test="${sr.jmr_js_no == i.js_no }">
						<tr style="color:red;">
							<th>${sr.jmr_writer }</th>
							<td>
								${sr.jmr_txt }&nbsp;&nbsp;${sr.jmr_date } 
									<c:if test="${sessionScope.loginMember.js_id==sr.jmr_writer }">
										<button onclick="deleteReply(${sr.jmr_no})" class="replyDelete">삭제</button>
									</c:if>
							</td>				
						</tr>				
					</c:if>
				</c:forEach>
				<c:if test="${sessionScope.loginMember !=null }">
					<tr>
						<th >댓글작성</th>
						<td>
							<form action="write.Reply">
								<input type="hidden" value="${i.js_no}" name="jmr_js_no">
								<input type="hidden" value="${sessionScope.loginMember.js_id}" name="jmr_writer">
								<input id="replyTxt" name="jmr_txt">
								<button class="replyButton">작성</button>
							</form>
						</td>
					</tr>
				</c:if>
			<c:if test="${i.js_writer == sessionScope.loginMember.js_id }">
				<tr>
					<td><button class="updateButton" onclick="goUpdateMemo(${i.js_no}, '${i.js_txt }');">수정</button></td>
					<td><button class="delButton" onclick="goDelMemo(${i.js_no });">삭제</button></td>
				</tr>
			</c:if>
			</table>
			
	</c:forEach>
	
	<div id="memoPage">
				<c:forEach var="z" begin="1" end="${pageCount }">
					&nbsp;<a href="Memopage.change?p=${z }">${z }</a>&nbsp;
				</c:forEach>
	</div>
	
	<div id="writeYourMemo">
		<form action="go.write" method="post" enctype="multipart/form-data">
			<table class="memoTable">
				<tr>
					<td id="WriteSummonImg">손잡이</td>
				</tr>
				<tr>
					<th colspan="2"><input value="${sessionScope.loginMember.js_id }" readonly="readonly" name="js_writer" type="hidden"></th>
				</tr>
				<tr>
					<td class="memoTd"colspan="2"><textarea name="js_txt" id="memoTxt" maxlength="200"></textarea></td>
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