package cn.edu.ruc.view;

import java.io.Serializable;

public class BarMap implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long cfgId;
	private Long pps;
	private Long sum;
	private Long costTime;
	private Double successRatio;
	private Long clients;
	private Long batchId;
    private Long maxTimeout;
    private Long minTimeout;
    private Long avgTimeout;
    private Long th50Timeout;
    private Long th95Timeout;
	public Long getCfgId() {
		return cfgId;
	}
	public void setCfgId(Long cfgId) {
		this.cfgId = cfgId;
	}
	public Long getPps() {
		return pps;
	}
	public void setPps(Long pps) {
		this.pps = pps;
	}
	public Long getSum() {
		return sum;
	}
	public void setSum(Long sum) {
		this.sum = sum;
	}
	public Long getCostTime() {
		return costTime;
	}
	public void setCostTime(Long costTime) {
		this.costTime = costTime;
	}
	public Double getSuccessRatio() {
		return successRatio;
	}
	public void setSuccessRatio(Double successRatio) {
		this.successRatio = successRatio;
	}
	public Long getClients() {
		return clients;
	}
	public void setClients(Long clients) {
		this.clients = clients;
	}
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	public Long getMaxTimeout() {
		return maxTimeout;
	}
	public void setMaxTimeout(Long maxTimeout) {
		this.maxTimeout = maxTimeout;
	}
	public Long getMinTimeout() {
		return minTimeout;
	}
	public void setMinTimeout(Long minTimeout) {
		this.minTimeout = minTimeout;
	}
	public Long getAvgTimeout() {
		return avgTimeout;
	}
	public void setAvgTimeout(Long avgTimeout) {
		this.avgTimeout = avgTimeout;
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
}
