package com.alipay.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.demo.test.Main;
import com.music.common.Order;
import com.music.common.vo.OrderSo;

@RestController
public class AlipayController {
	@Autowired
	private Main main;

	 @PostMapping("/alipay/test")
	 public OrderSo alipay(@RequestBody Order order) {
		return	main.test_trade_precreate(order);
	}
	 
	 @GetMapping("/zhifubao")
	 public String zhangtest() {
		 return "sandas";
	 }
	 
	 @PostMapping("/alipay/selelct/{orderId}")
	 public String alipayOrder(@PathVariable String orderId) {
		return main.test_trade_query(orderId);
	 }
//	 @GetMapping
//	 public String callback() {
//		 
//	 }
		 
}
