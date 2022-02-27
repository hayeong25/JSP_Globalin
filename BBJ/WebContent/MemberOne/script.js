function idCheck(id) {
	if(id == "") {
		alert("아이디를 입력해주세요");
		document.RegForm.id.focus();
	}
	else {
		url = "idCheck.jsp?id=" + id;
		window.open(url, "post", "width=300, height=150");
	}
}

function zipCheck() {
	url="zipCheck.jsp?check=y";
	
	window.open(url, "post", "toolbar=no, width=500, height=300, directories=no, status=yes, scrollbars=yes, menubar=no");
	
	function win_close(){
		self.close();
	}
}

function dongCheck() {
	if(document.zipForm.dong.value == "") {
		alert("동 이름을 입력하세요.");
		document.zipForm.dong.focus();
		return;
	}
	document.zipForm.submit();
}

function inputCheck() {
	if(document.RegForm.id.value == "") {
		alert("아이디를 입력해주세요.");
		document.RegForm.id.focus();
		return;
	}
	
	if(document.RegForm.pass.value == "") {
		alert("비밀번호를 입력해주세요.");
		document.RegForm.pass.focus();
		return;
	}
	
	if(document.RegForm.pass.value != document.RegForm.repass.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.RegForm.pass.value = "";
		document.RegForm.repass.value = "";
		document.RegForm.pass.focus();
		return;
	}
	
	if(document.RegForm.name.value == "") {
		alert("이름을 입력해주세요.");
		document.RegForm.name.focus();
		return;
	}
	
	if(document.RegForm.phone1.value == "") {
		alert("통신사를 입력해주세요.");
		document.RegForm.phone1.focus();
		return;
	}
	
	if(document.RegForm.phone2.value == "") {
		alert("전화번호를 입력해주세요.");
		document.RegForm.phone2.focus();
		return;
	}
	
	var str = document.RegForm.email.value;
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	
	if(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos+1 < dotPos && dotPos+1 < eMailSize);
	else {
		alert("이메일 주소 형식이 잘못되었습니다.\n다시 입력해주세요.");
		document.RegForm.email.value = "";
		document.RegForm.email.focus();
		return;
	}
	
	if(document.RegForm.zipcode.value == "") {
		alert("우편번호를 입력해주세요.");
		document.RegForm.zipcode.focus();
		return;
	}
	
	if(document.RegForm.address1.value == "") {
		alert("주소를 입력해주세요.");
		document.RegForm.address1.focus();
		return;
	}
	
	if(document.RegForm.address2.value == "") {
		alert("상세 주소를 입력해주세요.");
		document.RegForm.address2.focus();
		return;
	}
	
	document.RegForm.submit();
}

function updateCheck() {
	if(document.RegForm.pass.value == "") {
		alert("비밀번호를 입력해주세요.");
		document.RegForm.pass.focus();
		return;
	}
	
	if(document.RegForm.pass.value != document.RegForm.repass.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.RegForm.pass.value = "";
		document.RegForm.repass.value = "";
		document.RegForm.pass.focus();
		return;
	}
	
	if(document.RegForm.phone1.value == "") {
		alert("통신사를 입력해주세요.");
		document.RegForm.phone1.focus();
		return;
	}
	
	if(document.RegForm.phone2.value == "") {
		alert("전화번호를 입력해주세요.");
		document.RegForm.phone2.focus();
		return;
	}
	
	var str = document.RegForm.email.value;
	var atPos = str.indexOf('@');
	var atLastPos = str.lastIndexOf('@');
	var dotPos = str.indexOf('.');
	var spacePos = str.indexOf(' ');
	var commaPos = str.indexOf(',');
	var eMailSize = str.length;
	
	if(atPos > 1 && atPos == atLastPos && dotPos > 3 && spacePos == -1 && commaPos == -1 && atPos+1 < dotPos && dotPos+1 < eMailSize);
	else {
		alert("이메일 주소 형식이 잘못되었습니다.\n다시 입력해주세요.");
		document.RegForm.email.value = "";
		document.RegForm.email.focus();
		return;
	}
	
	if(document.RegForm.zipcode.value == "") {
		alert("우편번호를 입력해주세요.");
		document.RegForm.zipcode.focus();
		return;
	}
	
	if(document.RegForm.address1.value == "") {
		alert("주소를 입력해주세요.");
		document.RegForm.address1.focus();
		return;
	}
	
	if(document.RegForm.address2.value == "") {
		alert("상세 주소를 입력해주세요.");
		document.RegForm.address2.focus();
		return;
	}
	
	document.RegForm.submit();
}

function checkIt() {
	if(!document.myForm.pass.value) {
		alert("비밀번호를 입력해주세요");
		document.myForm.pass.focus();
		return false;
	}
}

function begin() {
	doument.myForm.pass.focus();
}