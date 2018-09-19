package cn.edu.ruc.entity;

import java.io.Serializable;
import java.util.Date;

public class TsbmBatch implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String templateId;
    private String templateName;

    private Integer cfgId;
    private String cfgName;

    private Integer testStatus=1;

    private Integer testType=1;//1 导入，2 写入 ，3 读 ，4 读背景下写 ， 5 写背景下读
    private String progress;
    public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getCfgName() {
		return cfgName;
	}

	public void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}

	private Date createTime = new Date();

    private Date startTime;

    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Integer getCfgId() {
        return cfgId;
    }

    public void setCfgId(Integer cfgId) {
        this.cfgId = cfgId;
    }

    public Integer getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(Integer testStatus) {
        this.testStatus = testStatus;
    }

    public Integer getTestType() {
        return testType;
    }

    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

	@Override
	public String toString() {
		return "TsbmBatch [id=" + id + ", name=" + name + ", templateId=" + templateId + ", cfgId=" + cfgId
				+ ", testStatus=" + testStatus + ", testType=" + testType + ", createTime=" + createTime
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}