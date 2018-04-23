/*单击一次添加一个*/
var path = document.getElementById("path").value;
function addItem(obj,n){
	var xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var s = xmlHttpRequest.responseText;
			if(s == 1){
				alert("此书已添加成功！");
			}else{
				alert("此书添加失败！");
			}
		}
	}
	xmlHttpRequest.open("post", path+"/user/cart/getItem",true);
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttpRequest.send("bookIsbn="+obj+"&number="+n);
}

/*单击添加多个,details.jsp里*/
function addItems(obj){
	var n = document.getElementById("itemCNumber").value;
	var xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = function(){
		if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
			var st = xmlHttpRequest.responseText;
			var bs = JSON.parse(st);
			if(bs[2] == 1){
				var d1 = document.getElementById("numw1").innerText;
				var d2 = document.getElementById("numw2").innerText;
				d1 = bs[0]; 
				d2 = bs[1];
				alert(d1+"====="+d2);
				alert("添加成功");
				
			}else{
				alert("添加商品失败！");
			}
			
		}
	}
	xmlHttpRequest.open("post", path+"/user/cart/getItems",true);
	xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttpRequest.send("bookIsbn="+obj+"&number="+n);
}

function time(){
	timer = setInterval(function(){
	
	},500)
	setTimeout(function(){
		clearInterval(timer)
	},500)
}

