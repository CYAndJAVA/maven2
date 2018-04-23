var path = document.getElementById("path").value;
//轮播
$(function() {
	//每过2秒钟进行一次轮播
	$('#myCarousel').carousel({
		interval: 1000
	});
});

//搜索框
function searchBookByName(){
	var name = document.getElementById("searchName").value;
	window.location=path+"/book/booksview?searchName="+name;
}