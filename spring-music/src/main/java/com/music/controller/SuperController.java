package com.music.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.music.common.Order;
import com.music.common.Record;
import com.music.common.Superlotto;
import com.music.service.OrderService;
import com.music.service.RecordService;
import com.music.service.SuperlittoService;

@RestController
public class SuperController {

	
	@Autowired
	private SuperlittoService superlittoService;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private RecordService recordService;
	
	@PostMapping(value ="/super/add" ,produces="application/json;charset=UTF-8")
	public String  add(@RequestBody Superlotto superlotto) {
		String id = UUID.randomUUID().toString();
		superlotto.setId(id);
	 int  i = superlittoService.add(superlotto);
	 if (i>=1) {
		return "添加成功";
	}else {
		return "添加失败";
	}
	
	}
   
	@GetMapping("selectAll")
	public List<Superlotto> selectList(){
     List<Superlotto> xxList=	superlittoService.selectList();
		return xxList;
	}
	
	@PostMapping("addOrder")
	public void AddOrder(@RequestBody Order order) {
		orderService.insertOrder(order);
	}
	
	@PostMapping("addRecord")
	public void AddRecord(@RequestBody Record record) {
		recordService.inserRecord(record);
	}
}
