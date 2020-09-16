$(function(){

		$('input[name=nick]').focusout(function(){

			var nick = $(this).val();
			var json = {'nick': nick};
			
			$.ajax({
				url: '/sboard/user/nickCheck',
				type: 'get',
				data: json, 
				dataType: 'json',
				success: function(data){

					if(data.result == 0){
						$('.resultNick').css('color', 'green').text('사용할 수 있는 별명 입니다.');
					}else{
						$('.resultNick').css('color', 'red').text('사용할 수 없는 별명 입니다.');
					}
				}
			});
		});
		
	});