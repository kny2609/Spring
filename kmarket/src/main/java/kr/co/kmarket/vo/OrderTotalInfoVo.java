package kr.co.kmarket.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OrderTotalInfoVo {

	int count;
	int price;
	int sale;
	int delivery;
	int point;
	int total;
	
	
	
}
