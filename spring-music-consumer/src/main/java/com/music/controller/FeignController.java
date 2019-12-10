package com.music.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.music.common.Order;
import com.music.common.Record;
import com.music.common.Superlotto;
import com.music.common.vo.OrderSo;
import com.music.dao.AlipayFeign;
import com.music.dao.MusicFeign;
import com.music.dao.WebsocketFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
@RequestMapping("index")
public class FeignController {
    
	@Autowired
	private MusicFeign musicFeign;
	
	@Autowired
	private AlipayFeign alipayFeign;
	
	@Autowired
	private WebsocketFeign websocketFeign;
	
	private static String url = null;
	
	@GetMapping("/html")
	public String indexhtml() {
		return "/index.html";
	}
	
	
	
	@RequestMapping("/music/{test}")
	@ResponseBody
	@HystrixCommand(fallbackMethod="zhang")
	public String  index(@PathVariable String test) {
		return musicFeign.music(test);
	}
	
	@PostMapping(value= "super/add",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String add(@RequestBody Superlotto superlotto) {
		return  musicFeign.add(superlotto);
	}
	
	@GetMapping("/selectAll")
	@ResponseBody
	public List<Superlotto> selectList() {
	return	musicFeign.selectList();
	}
	
	@GetMapping("/text")
	@ResponseBody
	public void getText(String text, HttpSession session) {
		session.setAttribute("text", text);
	}
	
	
	 @PostMapping("/alipay/test")
	 @ResponseBody
	 public OrderSo alipay(HttpSession httpSession) {
		    Order order = new Order();
			order.setId(UUID.randomUUID().toString());
            order.setShulian(1L);
			order.setName("2222");
			order.setPrice(order.getShulian()*2);
			musicFeign.AddOrder(order);
			Record record = new Record();
			record.setId(UUID.randomUUID().toString());
			String text= (String)httpSession.getAttribute("text");
			record.setText(text);
			musicFeign.AddRecord(record);
			
		 return alipayFeign.alipay(order);
	 }
	 
	 @GetMapping("/zhifubao")
	 @ResponseBody
	 public String zhangtest() {
		 return alipayFeign.zhangtest();
	 }
	
	@GetMapping("/checkcenter/socket/{cid}")
	public ModelAndView websoketServer(@PathVariable String cid) {
	return websocketFeign.socket(cid);
	}
	
	@GetMapping("/zhangbing/{cid}")
	@ResponseBody
	public void getHttpSession(@PathVariable String cid) {
		url = cid;
	}
	
	@Scheduled(fixedDelay = 2000)
	public void pushToWeb() {
		if (org.apache.commons.lang.StringUtils.isEmpty(url)) {
			System.out.println("空的");
		}else {
			 String message =  alipayFeign.alipayOrder(url);
			 if (message.equals("支付成功")) {
				 websocketFeign.pushToWeb(url,message);
			}
			System.out.println("有了有了");
		}
	System.out.println("定时任务已启动");
	}
	
	public String zhang(String name) {
		return "亲爱的网站已经炸了";
	}
}
