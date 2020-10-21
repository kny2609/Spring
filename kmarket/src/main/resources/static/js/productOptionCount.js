//상품수량 +, - 기능구현
  $(document).ready(function(){
  	
  	var btnPlus  = $('.option > input[name=plus]');
  	var btnMinus = $('.option > input[name=minus]');
  	var txtCount = $('.option > input[name=count]');
  	var priceTag = $('.dis_price > ins');
  	var totPriceTag = $('.total > span');
  	
  	btnPlus.click(function(){
  		var count = txtCount.val();			
  		var num = parseInt(count) + 1;
  		var txtPrice = priceTag.text();
  		var intPrice = parseInt(txtPrice.replace(/,/g,""));
  		var totPrice = num*intPrice;
  		
  		txtCount.val(num);
  		totPriceTag.text(totPrice.toLocaleString());
  	});
  	
  	btnMinus.click(function(){
  		var count = txtCount.val();			
  		var num = parseInt(count) - 1;
  		
  		if(num <= 0){
  			alert('최소 수량은 1개 입니다.');
  			return;
  		}
  		
  		var txtPrice = priceTag.text();
  		var intPrice = parseInt(txtPrice.replace(/,/g,""));
  		var totPrice = num*intPrice;
  		
  		txtCount.val(num);
  		totPriceTag.text(totPrice.toLocaleString());
  	});  			
  	
  });
