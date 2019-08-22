function inputScore() {
	if(document.scoreWriteForm.studNo.value == "") {
		alert("학번을 입력하세요.");
		document.scoreWriteForm.studNo.focus();
	} else if(document.scoreWriteForm.name.value == "") {
		alert("이름을 입력하세요.");
		document.scoreWriteForm.name.focus();
	} else if(document.scoreWriteForm.kor.value == "") {
		alert("국어점수를 입력하세요.");
		document.scoreWriteForm.kor.focus();
	}else if(document.scoreWriteForm.eng.value == "") {
		alert("영어점수를 입력하세요.");
		document.scoreWriteForm.eng.focus();
	}else if(document.scoreWriteForm.mat.value == "") {
		alert("수학점수를 입력하세요.");
		document.scoreWriteForm.mat.focus();
	}else {
		document.scoreWriteForm.submit();
	}
	
}

function modifyScore() {
	if(document.scoreModifyForm.kor.value == "") {
		alert("국어점수를 입력하세요.");
		document.scoreWriteForm.kor.focus();
	} else if(document.scoreModifyForm.eng.value == "") {
		alert("영어점수를 입력하세요.");
		document.scoreModifyForm.eng.focus();
	} else if(document.scoreModifyForm.mat.value == "") {
		alert("수학점수를 입력하세요.");
		document.scoreModifyForm.mat.focus();
	}else {
		document.scoreModifyForm.submit();
	}
}
