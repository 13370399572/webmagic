package com.music.service;

import java.util.List;

import com.music.common.Superlotto;

public interface SuperlittoService {

	int add(Superlotto superlotto);	
	
	int update(Superlotto superlotto);
	
	int deletesuperlitto(Long id);
	
	Superlotto selete(Long id) ;
	
	List<Superlotto> selectList();
}
