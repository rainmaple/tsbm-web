package cn.edu.ruc.view;

import java.io.Serializable;

public class StatBar implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cfgName;
	private Long cfgId;
	private Long batchId;
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	private Long pps;
	private Long costTime;
	private Integer clients;
	private Long sum;
	private Long meanTimeout;
	private Long minTimeout;
	private Long maxTimeout;
	private Long th50Timeout;
	private Long th95Timeout;
	private Double successRatio;
	public String getCfgName() {
		return cfgName;
	}
	public void setCfgName(String cfgName) {
		this.cfgName = cfgName;
	}
	public Long getPps() {
		return pps;
	}
	public void setPps(Long pps) {
		this.pps = pps;
	}
	public Long getCostTime() {
		return costTime;
	}
	public void setCostTime(Long costTime) {
		this.costTime = costTime;
	}
	public Integer getClients() {
		return clients;
	}
	public void setClients(Integer clients) {
		this.clients = clients;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	public Long getMeanTimeout() {
		return meanTimeout;
	}
	public void setMeanTimeout(Long meanTimeout) {
		this.meanTimeout = meanTimeout;
	}
	public Long getMinTimeout() {
		return minTimeout;
	}
	public void setMinTimeout(Long minTimeout) {
		this.minTimeout = minTimeout;
	}
	public Long getMaxTimeout() {
		return maxTimeout;
	}
	public void setMaxTimeout(Long maxTimeout) {
		this.maxTimeout = maxTimeout;
	}
	public Long getTh50Timeout() {
		return th50Timeout;
	}
	public void setTh50Timeout(Long th50Timeout) {
		this.th50Timeout = th50Timeout;
	}
	public Long getTh95Timeout() {
		return th95Timeout;
	}
	public void setTh95Timeout(Long th95Timeout) {
		this.th95Timeout = th95Timeout;
	}
	public Double getSuccessRatio() {
		return successRatio;
	}
	public void setSuccessRatio(Double successRatio) {
		this.successRatio = successRatio;
	}
	public Long getCfgId() {
		return cfgId;
	}
	public void setCfgId(Long cfgId) {
		this.cfgId = cfgId;
	}
}
