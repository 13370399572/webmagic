package com.music.dao;

import org.apache.ibatis.annotations.Mapper;

import com.music.common.Order;
import com.music.util.BaseMapper;

@Mapper
public interface OrderDao  extends  BaseMapper<Order>{
	

}
