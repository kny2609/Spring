$(function(){
    	
    	var pass1 = $('input[name=pass1]');
    	var pass2 = $('input[name=pass2]');
    	
    	pass2.focusout(function(){
    		
    		var value1 = pass1.val();
    		var value2 = pass2.val();
    		
    		if(value1 == value2){
    			$('.resultPass').css('color', 'green').text('비밀번호가 서로 일치합니다.');
    		}else{
    			$('.resultPass').css('color', 'red').text('비밀번호가 서로 일치하지 않습니다.');
    		}
    		
    	});
    	
    });