function functionMainRolling(containerID, slideID, autoPlay , timeSpeed){
	// 濡ㅻ쭅�� 媛앹껜瑜� 蹂��섏뿉 �댁븘�붾떎.
	var el = $('#'+containerID).find('#'+slideID);
	var lastChild;
	var speed = 3000;
	var timer = 0;
	var timeSpeed = timeSpeed;
	el.data('prev', $('#'+containerID).find('.prev'));	//�댁쟾踰꾪듉�� data()硫붿꽌�쒕� �ъ슜�섏뿬 ���ν븳��.
	el.data('next', $('#'+containerID).find('.next'));	//�ㅼ쓬踰꾪듉�� data()硫붿꽌�쒕� �ъ슜�섏뿬 ���ν븳��.
	el.data('play', $('#'+containerID).find('.play'));	//�댁쟾踰꾪듉�� data()硫붿꽌�쒕� �ъ슜�섏뿬 ���ν븳��.
	el.data('stop', $('#'+containerID).find('.stop'));	//�ㅼ쓬踰꾪듉�� data()硫붿꽌�쒕� �ъ슜�섏뿬 ���ν븳��.
	el.data('size', el.children().width());		//濡ㅻ쭅媛앹껜�� �먯떇�붿냼�� �볦씠瑜� ���ν븳��.
	el.data('len', el.children().length);				//濡ㅻ쭅媛앹껜�� �꾩껜�붿냼 媛쒖닔
	el.data('animating',false);

	el.css('width',el.data('size')*el.data('len'));		//濡ㅻ쭅媛앹껜�� �꾩껜�볦씠 吏��뺥븳��.

	if (autoPlay == true){
		el.data('play').hide();
		el.data('stop').show();
	}else{
		el.data('play').show();
		el.data('stop').hide();
	}
	//el�� 泥⑤��� prev �곗씠��瑜� �대┃�대깽�몄뿉 諛붿씤�쒗븳��.
	el.data('prev').bind({
		click:function(e){
			e.preventDefault();
			movePrevSlide();
		}
	});

	//el�� 泥⑤��� next �곗씠��瑜� �대┃�대깽�몄뿉 諛붿씤�쒗븳��.
	el.data('next').bind({
		click:function(e){
			e.preventDefault();
			moveNextSlide();
		}
	});
	el.data('play').bind({
		click:function(){
			$(this).hide();
			el.data('stop').show();
			timer = setInterval(moveNextSlide, timeSpeed);
			el.bind({
				'mouseenter': function(){
					clearInterval(timer);
				},
				'mouseleave': function(){
					timer = setInterval(moveNextSlide, timeSpeed);
				}
			});
		}
	});
	el.data('stop').bind({
		click:function(){
			$(this).hide();
			el.data('play').show();
			clearInterval(timer);
			el.bind({
				'mouseenter': function(){
					clearInterval(timer);
				},
				'mouseleave': function(){
					clearInterval(timer);
				}
			});
		}
	});

	if(autoPlay == true){
		timer = setInterval(moveNextSlide, timeSpeed);
		el.bind({
			'mouseenter': function(){
				clearInterval(timer);
			},
			'mouseleave': function(){
				timer = setInterval(moveNextSlide, timeSpeed);
			}
		});
	}else{
		clearInterval(timer);
	}
	function liSelecter(num){
		el.children().removeClass('on');
		el.children().eq(num+2).addClass('on');
		el.children().eq(num+3).addClass('on');
		el.children().eq(num+4).addClass('on');
	}
	var target = el.children().children();
	$(target).hover(function(){
		var checkOn = $(this).parent().hasClass('on');
		if (checkOn == true){
			$(this).addClass('hover');
		}
	},function(){
		var checkOn = $(this).parent().hasClass('on');
		if (checkOn == true){
			$(this).removeClass('hover');
		}
	});
	$(target).focus(function(){
		var checkOn = $(this).parent().hasClass('on');
		if (checkOn == true){
			$(this).addClass('hover');
		}
	});
	$(target).blur(function(){
		var checkOn = $(this).parent().hasClass('on');
		if (checkOn == true){
			$(this).removeClass('hover');
		}
	});
	function movePrevSlide(){
		if(!el.data('animating')){
			//濡ㅻ쭅媛앹껜�� �앹뿉�� �붿냼瑜� �좏깮�섏뿬 蹂듭궗�쒗썑 蹂��섏뿉 ���ν븳��.
			var lastItem = el.children().eq(-2).nextAll().clone(true);
			lastItem.prependTo(el);		//蹂듭궗�� �붿냼瑜� 濡ㅻ쭅媛앹껜�� �욎뿉 遺숈뿬�볥뒗��.
			el.children().eq(-2).nextAll().remove();	//�좏깮�� �붿냼�� �앹뿉�� �쒓굅�쒕떎
			el.css('left','-'+(el.data('size')*5+'px'));	//濡ㅻ쭅媛앹껜�� left�꾩튂媛믪쓣 �ъ꽕�뺥븳��.
		
			el.data('animating',true);	//�좊땲硫붿씠�� 以묐났�� 留됯린 �꾪빐 泥⑤��� animating �곗씠��瑜� true濡� �ㅼ젙�쒕떎.

			el.animate({'left': '-'+(el.data('size')*4)+'px'},'normal',function(){		//濡ㅻ쭅媛앹껜瑜� left:0留뚰겮 �좊땲硫붿씠�� �쒗궓��.
				el.data('animating',false);
				liSelecter(1);
			});
		}
		return false;
	}

	function moveNextSlide(){
		if(!el.data('animating')){
			el.data('animating',true);

			el.animate({'left':'-'+(el.data('size')*5)+'px'},'normal',function(){	//濡ㅻ쭅媛앹껜瑜� �좊땲硫붿씠�� �쒗궓��.
				//濡ㅻ쭅媛앹껜�� �욎뿉�� �붿냼瑜� �좏깮�섏뿬 蹂듭궗�쒗썑 蹂��섏뿉 ���ν븳��.
				var firstChild = el.children().filter(':lt('+1+')').clone(true);
				firstChild.appendTo(el);	//蹂듭궗�� �붿냼瑜� 濡ㅻ쭅媛앹껜�� �앹뿉 遺숈뿬�볥뒗��.
				el.children().filter(':lt('+1+')').remove();	//�좏깮�� �붿냼瑜� �욎뿉�� �쒓굅�쒕떎
				el.css('left','-'+(el.data('size')*4+'px'));	////濡ㅻ쭅媛앹껜�� left�꾩튂媛믪쓣 �ъ꽕�뺥븳��.

				el.data('animating',false);
				liSelecter(1);
			});
		}
		return false;
	}
	var lastItem = el.children().eq(-4).nextAll().clone(true);
	lastItem.prependTo(el);		//蹂듭궗�� �붿냼瑜� 濡ㅻ쭅媛앹껜�� �욎뿉 遺숈뿬�볥뒗��.
	el.children().eq(-4).nextAll().remove();	//�좏깮�� �붿냼�� �앹뿉�� �쒓굅�쒕떎
	el.css('left','-'+(el.data('size')*4+'px'));
	liSelecter(1);
}