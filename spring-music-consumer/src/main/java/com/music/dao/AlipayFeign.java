package com.music.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.music.common.Order;
import com.music.common.vo.OrderSo;

@FeignClient("provider-zhifubao")
public interface AlipayFeign {

	
	 @PostMapping("/alipay/test")
	 public OrderSo alipay(@RequestBody Order order);
	 
	 @GetMapping("/zhifubao")
	 public String zhangtest();
	 
	 @PostMapping("/alipay/selelct/{orderId}")
	 public String alipayOrder(@PathVariable String orderId);
	 
	 
}
