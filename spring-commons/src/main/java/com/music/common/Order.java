package com.music.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name="t_order")
public class Order implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -1435367518931362827L;

	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="shulian")
	private Long shulian;
	
	@Column(name="price")
	private Long price;
}
