package com.music.dao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.common.Order;
import com.music.common.Record;
import com.music.common.Superlotto;

@FeignClient("provider-music")
public interface MusicFeign {
	@RequestMapping("/music/{test}")
	public String music(@PathVariable String test);
	
	@PostMapping(value= "/super/add", produces="application/json;charset=UTF-8")
	public String  add(@RequestBody Superlotto superlotto);
	
	@GetMapping("selectAll")
	public List<Superlotto> selectList();
	
	@PostMapping("addOrder")
	public void AddOrder(@RequestBody Order order);
	
	@PostMapping("addRecord")
	public void AddRecord(@RequestBody Record record);
}
