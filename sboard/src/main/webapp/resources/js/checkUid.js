$(function(){

		$('input[name=uid]').focusout(function(){

			var uid = $(this).val();
			var json = {'uid': uid};
			
			$.ajax({
				url: '/sboard/user/uidCheck',
				type: 'get',
				data: json, 
				dataType: 'json',
				success: function(data){

					if(data.result == 0){
						$('.resultId').css('color', 'green').text('사용할 수 있는 아이디 입니다.');
					}else{
						$('.resultId').css('color', 'red').text('사용할 수 없는 아이디 입니다.');
					}
				}
			});
		});
		
	});