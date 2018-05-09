$(function(){
	var user = window.sessionStorage.getItem('userData');
	$('#userBar').tmpl(JSON.parse(user)).appendTo(".user-bar");
});