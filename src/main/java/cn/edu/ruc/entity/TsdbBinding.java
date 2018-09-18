package cn.edu.ruc.entity;

import java.io.Serializable;
/**
 * 
 * @author fasape
 *
 */
public class TsdbBinding implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String dbName;
	private String dbClass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbClass() {
		return dbClass;
	}
	public void setDbClass(String dbClass) {
		this.dbClass = dbClass;
	}
}
