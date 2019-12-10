package com.music.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name="superlotto")
public class Superlotto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7362096594748019759L;
    
	@Id
	@Column(name="id")
	private String  id;	
	
	@Column(name="first")
    private Integer	first;	
	
	@Column(name="second_area")
    private Integer	secondArea	;
	
	@Column(name="three_areas")
    private Integer threeAreas;
	
	@Column(name="four_areas")
    private Integer fourAreas	;
	
	@Column(name="five_area")
    private Integer  fiveArea;
	
	@Column(name="six_area")
    private Integer  sixArea	;
	
	@Column(name="seven_area")
    private Integer sevenArea;
	
	@Column(name="periods")
    private Long  periods;

	
}
