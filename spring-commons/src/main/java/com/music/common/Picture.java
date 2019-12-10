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
@Table(name="music")
public class Picture implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6687291598387559780L;
	//主键id
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "JDBC")
	private Long id;
	//图片路径
	@Column(name="path")
	private String path;
	
	//音乐路径
	@Column(name="musicpath")
	private String musicpath;
	
	//音乐名称
	@Column(name="name")
	private String name;
	

}
