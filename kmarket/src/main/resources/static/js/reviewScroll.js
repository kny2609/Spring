$(document).ready(function(){
		
	var review = $('h5.rating > a')
	
	$('#top').click(function(){
		$('html, body').animate({'scrollTop' : 0});
	});
	
	var scrollHeight = $(document).height();
	var sbHeight = window.innerHeight * (window.innerHeight / document.body.offsetHeight);
	var scrollHeight = scrollHeight-sbHeight-1000;
	review.click(function(e){
		e.preventDefault();
		//var i = $(this).parent().index();
		$('html, body').animate({'scrollTop' : scrollHeight});
	});
});