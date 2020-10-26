package kr.co.ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConcertController {
	
	@GetMapping("/concert/rank")
	public String rank() {
		return "/concert/rank";
	}
	
	@GetMapping("/concert/view")
	public String view() {
		return "/concert/view";
	}
	
	@GetMapping("/concert/order_seat")
	public String orderSeat() {
		return "/concert/order_seat";
	}

	@GetMapping("/concert/order_price")
	public String orderPrice() {
		return "/concert/order_price";
	}
	
	@GetMapping("/concert/order_final")
	public String orderFinal() {
		return "/concert/order_final";
	}
	
	@GetMapping("/concert/order_check")
	public String orderCheck() {
		return "/concert/order_check";
	}
	
	
}
