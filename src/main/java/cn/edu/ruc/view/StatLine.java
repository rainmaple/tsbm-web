package cn.edu.ruc.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StatLine implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cfgName;
	private List<Integer> keys=new ArrayList<Integer>();
	private List<Double> values=new ArrayList<Double>();
	public String getCfgName() {
		return cfgName;
	}
	public void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}
	public List<Integer> getKeys() {
		return keys;
	}
	public void setKeys(List<Integer> keys) {
		this.keys = keys;
	}
	public List<Double> getValues() {
		return values;
	}
	public void setValues(List<Double> values) {
		this.values = values;
	}
}
