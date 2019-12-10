package com.music.entity;

import java.io.Serializable;

import com.alibaba.druid.support.monitor.annotation.MTable;

@MTable(name="")
public class Superlotto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7362096594748019759L;
    
	private String  id;	
	
    private Integer	first;	
    
    private Integer	secondArea;
	
    private Integer threeAreas;
	
    private Integer fourAreas;
	
    private Integer  fiveArea;
	
    private Integer  sixArea;
	
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getSecondArea() {
		return secondArea;
	}

	public void setSecondArea(Integer secondArea) {
		this.secondArea = secondArea;
	}

	public Integer getThreeAreas() {
		return threeAreas;
	}

	public void setThreeAreas(Integer threeAreas) {
		this.threeAreas = threeAreas;
	}

	public Integer getFourAreas() {
		return fourAreas;
	}

	public void setFourAreas(Integer fourAreas) {
		this.fourAreas = fourAreas;
	}

	public Integer getFiveArea() {
		return fiveArea;
	}

	public void setFiveArea(Integer fiveArea) {
		this.fiveArea = fiveArea;
	}

	public Integer getSixArea() {
		return sixArea;
	}

	public void setSixArea(Integer sixArea) {
		this.sixArea = sixArea;
	}

	public Integer getSevenArea() {
		return sevenArea;
	}

	public void setSevenArea(Integer sevenArea) {
		this.sevenArea = sevenArea;
	}

	public Long getPeriods() {
		return periods;
	}

	public void setPeriods(Long periods) {
		this.periods = periods;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Integer sevenArea;
	
    private Long  periods;

	
}
