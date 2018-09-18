package cn.edu.ruc.entity;

import java.io.Serializable;

public class TsdbCfg implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer bindingId;

    private String name;

    private String dbIp;

    private String dbPort;

    private String dbUser;

    private String dbPasswd;
    private String dbName;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBindingId() {
        return bindingId;
    }

    public void setBindingId(Integer bindingId) {
        this.bindingId = bindingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbIp() {
        return dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    public String getDbPort() {
        return dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPasswd() {
        return dbPasswd;
    }

    public void setDbPasswd(String dbPasswd) {
        this.dbPasswd = dbPasswd;
    }

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}