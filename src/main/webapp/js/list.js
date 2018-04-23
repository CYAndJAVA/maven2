//1.获取所有内容行的cks
var cks = document.getElementsByName("cks");

/**实现的是全选功能**/
function selectAll(obj){
	//2.判断标题行的复选框是否选中
	if(obj.checked){
		for(var i in cks){
			cks[i].checked=true;
		}
	}else{
		for(var i in cks){
			cks[i].checked=false;
		}
	}
}

/**删除**/
function delMore(){
	//1.判断复选框是否选中内容.
	//定义一个计数器
	var count = 0;
	for(var i in cks){
		if(cks[i].checked){
			count++;
		}
	}
	if(count==0){
		alert("对不起!请您先选中删除数据行!");
		return;
	}
	
	//确认删除
	var flag = window.confirm("确定删除吗?");
	
	if(flag){
		//想办法获取到勾选的复选框的值.最终是将需要删除的id传入后台.
		//定义一个变量,用来保存删除的id
		var sids = "";
		
		for(var i in cks){
			if(cks[i].checked){
				sids+=cks[i].value+":";
			}
		}
		//发送到后台
		window.location="/StuMvnSystem/stu/handle/delMore?sids="+sids.substring(0,sids.length-1);
	}
}