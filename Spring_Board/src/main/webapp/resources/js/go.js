function goJoin() {
	location.href="go.join";
}
function goLogin(){
	location.href="chk.login";
}
function goBye() {
	location.href="go.bye"
}
function goUpdate() {
	location.href="go.update"
}
function runDelete(js_id) {
	if (confirm("정말 탈퇴하시겠습니까?")) {
		location.href="run.delete?js_id="+js_id;
	}
}
function goMan() {
	if (confirm("정말 입장하시겠습니까?")) {
		location.href="run.man";
	}
}
function goIndex() {
	location.href="go.index";
}
function goContact() {
	location.href="go.contact";
}
function goDelMan(js_no) {
	location.href="go.delMan?js_no="+js_no;
}
function goDelMemo(js_no) {
	location.href="go.delMemo?js_no="+js_no;
}
function goUpdateMemo(js_no, js_txt) {
	js_txt = prompt("수정내용", js_txt);
	if (!js_txt && js_txt.length > 300) {
		alert("수정할꺼?");
	} else {
		location.href = "update.Memo?js_no=" + js_no + "&js_txt=" + js_txt;
	}
}
function deleteReply(jmr_no) {
	location.href="delete.Reply?jmr_no="+jmr_no;
}
function deleteData(js_no) {
	location.href="delete.data?js_no="+js_no;
}
