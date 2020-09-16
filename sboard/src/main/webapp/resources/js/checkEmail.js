$(function(){

		$('input[name=email]').focusout(function(){

			var email = $(this).val();
			var json = {'email': email};
			
			$.ajax({
				url: '/sboard/user/emailCheck',
				type: 'get',
				data: json, 
				dataType: 'json',
				success: function(data){

					if(data.result == 0){
						$('.resultEmail').css('color', 'green').text('사용할 수 있는 이메일 입니다.');
					}else{
						$('.resultEmail').css('color', 'red').text('사용할 수 없는 이메일 입니다.');
					}
				}
			});
		});
		
	});