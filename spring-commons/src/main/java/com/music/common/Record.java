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
@Table(name="record")
public class Record implements Serializable {
  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4956185607379760358L;

	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name="id")
	private String id;
	
	@Column(name="text")
	private String text;
}