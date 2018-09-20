package cn.edu.ruc.view;

import java.io.Serializable;

public class LineMap implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long cfgId;
	private Long key;
	private Double value;
	public Long getCfgId() {
		return cfgId;
	}
	public void setCfgId(Long cfgId) {
		this.cfgId = cfgId;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
}
