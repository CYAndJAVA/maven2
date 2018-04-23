var path = document.getElementById("path").value;
// 显示更多地址...
function dispalyMoreAddr(obj) {
	var addr = document.getElementById("address");
	var lis = addr.getElementsByTagName("li");
	for (var i = 0; i < lis.length; i++) {
		lis[i].className = "list-group-item";
	}

	var div = document.getElementById("addrDiv");

	obj.style.display = "none";

	var aa = document.getElementById("down");

	if (aa == null) {
		var a = document.createElement("a");
		a.href = "#";
		a.id = "down";
		a.className = "text-info";
		a.innerHTML = "收起地址↑&nbsp;&nbsp;";

		div.appendChild(a);

		var adr = document.getElementById("addAddr");

		div.insertBefore(a, adr);

		a.onclick = function() {
			this.style.display = "none";
			obj.style.display = "inline";

			for (var i = 2; i < lis.length; i++) {
				lis[i].className = "list-group-item hidden";
			}
		}
	} else {
		aa.style.display = "inline";
	}
}

/* 检查注册 */
/* 5电话 1g2b */
function checkAddress() {
	var fleg = 1;
	var locaddress = "";
	var province = document.getElementById("province1").value;
	var city = document.getElementById("city1").value;
	var district = document.getElementById("district1").value;
	locaddress = province + city + district;

	var addressdeatails = document.getElementById("addressdeatails").value;
	var addressyoubian = document.getElementById("addressyoubian").value;
	var addressusername = document.getElementById("addressusername").value;
	var addresstel = document.getElementById("addresstel").value;

	var setDefaultAddr = document.getElementById("setDefaultAddr");
	if (setDefaultAddr.checked) {
		alert("这是默认地址")
		fleg = 0;
	}

	var xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function() {
		if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			var s = xmlHttpRequest.responseText;
			if(s == 1){
				alert("地址录入成功");
			}else{
				alert("地址录入失败");
			}
		}
	}
	xmlHttpRequest.open("post", path + "/user/cart/order/checkAddress", true);
	xmlHttpRequest.setRequestHeader("Content-type",
			"application/x-www-form-urlencoded");

	xmlHttpRequest.send("fleg=" + fleg + "&locass=" + locaddress + "&addtail="
			+ addressdeatails + "&youbian=" + addressyoubian + "&reciver="
			+ addressusername + "&recivtel=" + addresstel);
}

