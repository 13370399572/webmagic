package com.music.dao;

import com.music.entity.Superlotto;

public interface SuperlottoMapper {

	int addSuper(Superlotto superlotto);
	
	int selectSuper(Long periods);
}
