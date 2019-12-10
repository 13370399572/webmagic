package com.music.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.common.Order;
import com.music.dao.OrderDao;

@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
	private OrderDao orderDao;
	
	public int insertOrder(Order order) {
	return	orderDao.insert(order);
	}
	
}
