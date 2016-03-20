function createXMLHttpRequest(){
	var xmlHttpRequest = null;
	if(window.XMLHttpRequest){ //Mozilla
		xmlHttpRequest = new XMLHttpRequest();
		if (xmlHttpRequest.overrideMimeType) {//Set MIME type
			xmlHttpRequest.overrideMimeType("text/xml");
		}
	} else if(window.ActiveXObject){ //IE
		try{
			xmlHttpRequest = new ActiveXObject( "Msxm12.XMLHTTP" );
		}catch(e){
			try{
				xmlHttpRequest = new ActiveXObject( "Microsoft.XMLHTTP" );
			}catch(e){}
		}
	}
	return xmlHttpRequest;
}

function trim(s) {
	var tempStr;
	tempStr = s.replace(/\s+$/g,'');
	tempStr = tempStr.replace(/^\s+/g,'');
	return tempStr;
}
function isEmpty(s){
	return ((s == null) || (trim(s).length == 0))
}

function isValidComb(newPwd){
	var counter = 0;
	var letters = /[a-zA-Z]/;
	if (letters.exec(newPwd)) counter++;
	var number = /[0-9]/;
	if(number.exec(newPwd)) counter++;
	var spec = /[~`\!\?,\.\:;\-_\'\"\(\)\{\}\[\]\/@#$%\^&*+\|\\\=<>]/; 
	if(spec.exec(newPwd)) counter++;
	return counter == 3;
}

function checkPwdComb(newPwd){
	var letters = /[a-zA-Z]/;
	if (!letters.exec(newPwd)) {
		return 1;
	}  
	var number = /[0-9]/;
	if(!number.exec(newPwd)) {
		return 2;
	}
	var spec = /[~`\!\?,\.\:;\-_\'\"\(\)\{\}\[\]\/@#$%\^&*+\|\\\=<>]/; 
	if(!spec.exec(newPwd)) {
		return 3;
	}
	return 0;
}

function toAgree(obj){
	if(obj.checked){
		document.getElementById("regbtn").disabled=false; 	
	}else{
		document.getElementById("regbtn").disabled=true;
	}
}

//show account tips
function showTips(){		
	var tempx = document.getElementById("ac_tips");
	tempx.style.display="block";		
}

//hide account tips
function hideTips(){
	var tempx = document.getElementById("ac_tips");		
	tempx.style.display="none";	
}

//show password tips
function showTips_pw(){	
	var tempx = document.getElementById("pwd_tips");
	tempx.style.display="block";		
}

//hide password tips
function hideTips_pw(){
	var tempx = document.getElementById("pwd_tips");		
	tempx.style.display="none";	
}
	
//show confirm password tips
function showTips_repwd(){	
	var tempx = document.getElementById("repwd_tips");
	tempx.style.display="block";		
}

//hide confirm password tips
function hideTips_repwd(){
	var tempx = document.getElementById("repwd_tips");		
	tempx.style.display="none";	
}

//show phone tips
function showTips_phone(){	
	var tempx = document.getElementById("phone_tips");
	tempx.style.display="block";		
}

//hide phone tips
function hideTips_phone(){
	var tempx = document.getElementById("phone_tips");		
	tempx.style.display="none";	
}

function trim( str ) {
	str = str.match(/\S+(?:\s+\S+)*/);
	return str ? str[0] : '';
}

function showTipsMail(){
	var tempx = document.getElementById("email_tips");
	tempx.style.display="block";
}

function hideTipsMail(){
	var tempx = document.getElementById("email_tips");		
	tempx.style.display="none";	
}
