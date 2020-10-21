package kr.co.kmarket.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "km_products_order")
public class ProductsOrderVo {
	
	@Id
	@GeneratedValue
	private int seq;
	private String uid;
	private String products;
	private int count;
	private int price;
	private int discount;
	private int point;
	private int applyPoint;
	private int delivery;
	private int total;
	private int payment;
	private int complete;
	private String orderer;
	private String hp;
	private String zip;
	private String addr1;
	private String addr2;
	private String rdate;
	
	@Transient
	private int cate1;

}
