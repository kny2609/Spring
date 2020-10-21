// 상품분류 select 기능구현
$(function(){
	
	var select1 = $('select[name=cate1]');
	var select2 = $('select[name=cate2]');
	
	var cate1Url = "/kmarket/admin/product/cate1";
	var cate2Url = "/kmarket/admin/product/cate2";
	
	$.get(cate1Url, function(cate1List){
		$.each(cate1List, function(i, data){
			select1.append("<option value='"+data.code1+"'>"+data.title+"</option>");
		});
	});
	
	select1.change(function(){
		
		var code1 = $(this).val();
		var param = {'code1':code1};
		
		$.get(cate2Url, param, function(cate2List){
			select2.empty();
			select2.append("<option value='0'>2차 분류 선택</option>");
			$.each(cate2List, function(i, data){
				select2.append("<option value='"+data.code2+"'>"+data.title+"</option>");
			});
		});
	});
});

