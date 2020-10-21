// 추천, 최신, 할인 상태변수
var isCompleteReco = false;
var isCompleteNew = false;
var isCompleteDisc = false;

$(document).ready(function(){
	// section 객체 선택
	var sectionHit 		 = $('section.hit');
	var sectionRecommend = $('section.recommend');
	var sectionNew 		 = $('section.new');
	var sectionDiscount  = $('section.discount');
	
	$(window).scroll(function(){
		
		var pos = $(this).scrollTop();

		if(pos >= 200 && !isCompleteReco){
			isCompleteReco = true;
			getProducts(sectionRecommend, '/kmarket/main/recommend')
		}else if(pos >= 400 && !isCompleteNew){
			isCompleteNew = true;
			getProducts(sectionNew, '/kmarket/main/newItems')
		}else if(pos >= 600 && !isCompleteDisc){
			isCompleteDisc = true;
			getProducts(sectionDiscount, '/kmarket/main/discountItems')
		}
	}); // scroll end
	
	function getProducts(section, url) {
		$.ajax({
			url: url,
			type: 'get',
			dataType: 'json',
			success: function(data){

				section.find('img').remove();
				
				$.each(data, function(i, item){
					
					var dom = $('.hit > article:eq(0)').clone();
					var imgUrl = '/kmarket/thumb/'+item.cate1+"/"+item.cate2+"/"+item.thumb1;
					
					dom.find('.thumb > img').attr('src', imgUrl);
					dom.find('h2').text(item.name);
					dom.find('p').text(item.descript);
					dom.find('.org_price > del').text(item.price.toLocaleString());
					dom.find('.org_price > span').text(item.discount+'%');
					dom.find('.dis_price > ins').text(item.salePrice.toLocaleString());
					
					if(item.delivery > 0){
						dom.find('.dis_price > span').remove();
					}
					
					section.append(dom);
				});	
			}
		});
	}
	

	
	
	
});// jquery end