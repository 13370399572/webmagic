package com.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {
    
	@RequestMapping("/music/{test}")
	public String music(@PathVariable String test) {
		return "天才张炳鑫"+test;
	}
}
