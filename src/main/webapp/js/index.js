/**图书类型下拉框改变事件**/
function changeType(obj){
	//获取当前选中的option的value
	var styleId = obj.value;
	//alert(styleId);
	//获取搜索框中的数据
	var bookName = document.getElementById("bookName").value;
	//发送到/book/list
	//如果js文件就是存在于jsp文件中,那么EL表达式可以直接使用
	//如果js是一个单独的文件,则EL表达式不允许使用
	//我们可以将${path}放入到一个隐藏域中.
	window.location="/Book_Store_Hbm/book/list?styleId="+styleId+"&bookName="+bookName;
}


/**改变图书显示条数**/
function changeSize(obj){
	alert("=========");
	//获取当前显示的条数
	var size = obj.value;
	//获取搜索框中的数据
	var bookName = document.getElementById("bookName").value;
	//获取当前图书的类型
	var styleId = document.getElementById("style").value;
	
	window.location="/Book_Store_Hbm/book/pageContorl?sty_id="+styleId+"&sName="+bookName+"&pgSize="+size;
}
/**跳转页**/
function goPage(){
	//1.获取跳转框中的数据
	var v = document.getElementById("toPages").value;
	
	//2.进行参数有效性判断..判断输入的数据是一个整数
	var regex = /^[0-9]+$/;
	
	if(!regex.test(v)){
		alert("输入的数据不合法!");
		return;
	}
	//获取搜索框中的数据
	var bookName = document.getElementById("bookName").value;
	//获取当前图书的类型
	var styleId = document.getElementById("style").value;
	//获取条数
	var size = document.getElementById("size").value;
	window.location="/Book_Store_Hbm/book/list?styleId="+styleId+"&bookName="+bookName+"&pageSize="+size+"&pageNow="+v;
}

/**批量删除**/
function delMore(){
	var firstDiv = document.getElementById("first");
	var twoDiv = document.getElementById("two");
	
	firstDiv.style.display="none";
	twoDiv.style.display="none";
	
	var cks = document.getElementsByName("cks");
	//定义一个计数器
	var count = 0;
	for(var i in cks){
		if(cks[i].checked){
			count++;
		}
	}
	if(count==0){
		//提示...
		firstDiv.style.display="block";
		return;
	}
	
	twoDiv.style.display="block";
}

/**确认删除**/
function delMoreReal(){
	var cks = document.getElementsByName("cks");
	//定义一个计数器
	var sids = "";
	for(var i in cks){
		if(cks[i].checked){
			sids+=cks[i].value+":";
		}
	}
	//mapper service book/delMore 删除操作...
	window.location="/Book_Store_Hbm/book/del/more?sids="+sids.substring(0,sids.length-1);
}

