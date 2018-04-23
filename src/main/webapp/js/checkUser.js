var path = document.getElementById("path").value;
/*检查登录*/
function checkLogin(){
	var userName = document.getElementById("userName").value;
	var userPassword = document.getElementById("userPassword").value;
	//是否记住密码
	var bool = document.getElementById("rememberMe").checked;
	var flag = "no";
	if(bool){
		flag = "yes";
	}
	var la1 = document.getElementById("la1");
	var la2 = document.getElementById("la2");
	var xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var s = xmlHttpRequest.responseText;
			if(s==1){
				la1.className = "alert-success";
				la1.innerHTML="√";
				la2.className = "alert-danger";
				la2.innerHTML="密码错误！";
			}else if(s==2){
				la1.className = "alert-success";
				la1.innerHTML="";
				la2.className = "alert-success";
				la2.innerHTML="";
				alert("登陆成功！");
				window.location = path;
			}else{
				la1.className = "alert-danger";
				la1.innerHTML="用户不存在！";
			}
		}
	}
	xmlHttpRequest.open("post", path+"/user/check/checkLogin",true);
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttpRequest.send("userName="+userName+"&userPassword="+userPassword+"&flag="+flag);
}
/*检查注册*/
/*1名字 ， 2密码， 4邮箱。5电话，6公司，7地址  1g2b*/ 
function checkRegister(cs) {
	var newdata = "";
    var mb = 0;
	if(cs==1){
		var newUserName = document.getElementById("newUserName").value;
		mb = 1;
		newdata = newUserName;
	}else if(cs==2){
		var newPassword = document.getElementById("newPassword").value;
		mb = 2;
		newdata = newPassword;
	}else if(cs==3){
		var cpswd = document.getElementById("newPassword").value;
		var copyPassword = document.getElementById("copyPassword").value;
		var lab3 = document.getElementById("lab3");
		if(null!=cpswd){
			if(cpswd == copyPassword){
				lab3.className = "alert-success";
				lab3.innerHTML="√";
				crButton();
			}else{
				lab3.className = "alert-danger";
				lab3.innerHTML="与上面密码不一致！";
				yincButton();
			}
		}else{
			la1.className = "alert-danger";
			la1.innerHTML="把上面密码补上";
		}
		return;
	}else if(cs==4){
		var newEmail = document.getElementById("newEmail").value;
		mb = 4;
		newdata = newEmail;
	}else if(cs==5){
		var newPhone = document.getElementById("newPhone").value;
		mb = 5;
		newdata = newPhone;
	}else if(cs==6){
		var newCompany = document.getElementById("newCompany").value;
		mb = 6;
		newdata = newCompany;
	}else if(cs==7){
		var newAddress = document.getElementById("newAddress").value;
		mb = 7;
		newdata = newAddress;
	}
	var xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var s = xmlHttpRequest.responseText;
			if(s == 11){
				var lab11 = document.getElementById("lab1");
				lab11.className = "alert-success";
				lab11.innerHTML="√";
				crButton();
			}else if(s == 12){
				var lab12 = document.getElementById("lab1");
				lab12.className = "alert-danger";
				lab12.innerHTML="重新输入用户名！";
				yincButton();
			}else if(s == 21){
				var lab21 = document.getElementById("lab2");
				lab21.className = "alert-success";
				lab21.innerHTML="√";
				crButton();
			}else if(s == 22){
				var lab22 = document.getElementById("lab2");
				lab22.className = "alert-danger";
				lab22.innerHTML="密码不合规范，重输！";
				yincButton();
			}else if(s == 41){
				var lab41 = document.getElementById("lab4");
				lab41.className = "alert-success";
				lab41.innerHTML="√";
				crButton();
			}else if(s == 42){
				var lab42 = document.getElementById("lab4");
				lab42.className = "alert-danger";
				lab42.innerHTML="邮箱不合规范，重输！";
				yincButton();
			}else if(s == 51){
				var lab51 = document.getElementById("lab5");
				lab51.className = "alert-success";
				lab51.innerHTML="√";
				crButton();
			}else if(s == 52){
				var lab52 = document.getElementById("lab5");
				lab52.className = "alert-danger";
				lab52.innerHTML="电话不合规范，重输！";
				yincButton();
			}else if(s == 61){
				var lab61 = document.getElementById("lab6");
				lab61.className = "alert-success";
				lab61.innerHTML="√";
				crButton();
			}else if(s == 62){
				var lab62 = document.getElementById("lab6");
				lab62.className = "alert-danger";
				lab62.innerHTML="请输入公司名！";
				yincButton();
			}else if(s == 71){
				var lab71 = document.getElementById("lab7");
				lab71.className = "alert-success";
				lab71.innerHTML="√";
				crButton();
			}else if(s == 72){
				var lab72 = document.getElementById("lab7");
				lab72.className = "alert-danger";
				lab72.innerHTML="请输入地址！";
				yincButton();
			}
		}
	}
	xmlHttpRequest.open("post", path+"/user/check/checkRegister",true);
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttpRequest.send("mb="+mb+"&newdata="+newdata);
}

//button的显示
function crButton(){
	var b = "alert-success";
	var lab1 = document.getElementById("lab1").className;
	var lab2 = document.getElementById("lab2").className;
	var lab3 = document.getElementById("lab3").className;
	var lab4 = document.getElementById("lab4").className;
	var lab5 = document.getElementById("lab5").className;
	var lab6 = document.getElementById("lab6").className;
	var lab7 = document.getElementById("lab7").className;	
	if((b==lab1)&(b==lab2)&(b==lab3)&(b==lab4)&(b==lab5)&(b==lab6)&(b==lab7)){
		alert("以上信息符合标准，可以准备提交！");
		var db= document.getElementById("cRegisterBut");
		db.disabled = false;
	}else{
		alert("检查漏填的信息！");
		return;
	}
}
//隐藏button
function yincButton(){
	var dbb= document.getElementById("cRegisterBut");
	dbb.disabled = true;
}

//退出时刷新状态
function refreshClass(){
	var labr1 = document.getElementById("lab1");
	var labr2 = document.getElementById("lab2");
	var labr3 = document.getElementById("lab3");
	var labr4 = document.getElementById("lab4");
	var labr5 = document.getElementById("lab5");
	var labr6 = document.getElementById("lab6");
	var labr7 = document.getElementById("lab7");
	yincButton();
	labr1.className="";labr1.innerHTML="";
	labr2.className="";labr1.innerHTML="";
	labr3.className="";labr1.innerHTML="";
	labr4.className="";labr1.innerHTML="";
	labr5.className="";labr1.innerHTML="";
	labr6.className="";labr1.innerHTML="";
	labr7.className="";labr1.innerHTML="";
	//////
	document.getElementById("newUserName").value="";
	document.getElementById("newPassword").value="";
	document.getElementById("copyPassword").value="";
	document.getElementById("lab3").value="";
	document.getElementById("newEmail").value="";
	document.getElementById("newPhone").value="";
	document.getElementById("newCompany").value="";
	document.getElementById("newAddress").value="";
}



