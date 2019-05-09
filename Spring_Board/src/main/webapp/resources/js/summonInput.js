function connectSummonEvent() {
	
	var summon = false;
	
	$("#WriteSummonImg").click(function() {
		if (!summon) {
			$("#writeYourMemo").css("bottom","0px");
		}else {
			$("#writeYourMemo").css("bottom","-150px");
		}
		summon = !summon;
	});
}