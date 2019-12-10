package com.music.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@FeignClient("provider-websocket")
public interface WebsocketFeign {
    
	//这个是注册服务器
	@GetMapping("/checkcenter/socket/{cid}")
	public ModelAndView socket(@PathVariable String cid);
	
	//这个是推送消息
	@RequestMapping("/checkcenter/socket/push/{cid}/{message}")
	public String pushToWeb(@PathVariable String cid,@PathVariable String message);
	
}
