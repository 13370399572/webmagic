package com.music.util;



import org.apache.commons.lang3.StringUtils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T> extends Mapper<T> , MySqlMapper<T>{
	
	String MAPPER = "Mapper";

	static String builerMapper(String entityName) {
		StringBuilder beanName = new StringBuilder();
		beanName.append(StringUtils.uncapitalize(entityName));
		beanName.append(MAPPER);
		return beanName.toString();
	}
}

