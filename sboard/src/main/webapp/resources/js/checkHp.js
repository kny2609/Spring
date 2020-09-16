$(function(){

		$('input[name=hp]').focusout(function(){

			var hp = $(this).val();
			var json = {'hp': hp};
			
			$.ajax({
				url: '/sboard/user/hpCheck',
				type: 'get',
				data: json, 
				dataType: 'json',
				success: function(data){

					if(data.result == 0){
						$('.resultHp').css('color', 'green').text('사용할 수 있는 번호 입니다.');
					}else{
						$('.resultHp').css('color', 'red').text('사용할 수 없는 번호 입니다.');
					}
				}
			});
		});
		
	});