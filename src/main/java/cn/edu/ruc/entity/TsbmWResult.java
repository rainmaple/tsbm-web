package cn.edu.ruc.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TsbmWResult {
    private Long id;

    private Integer batchId;

    private Integer clients;

    private Long pointsSum;

    private Long costTime;

    private Long pps;

    private BigDecimal successRatio;

    private Long maxTimeout;

    private Long minTimeout;

    private Long avgTimeout;

    private Long th50Timeout;

    private Long th95Timeout;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public Long getPointsSum() {
        return pointsSum;
    }

    public void setPointsSum(Long pointsSum) {
        this.pointsSum = pointsSum;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    public Long getPps() {
        return pps;
    }

    public void setPps(Long pps) {
        this.pps = pps;
    }

    public BigDecimal getSuccessRatio() {
        return successRatio;
    }

    public void setSuccessRatio(BigDecimal successRatio) {
        this.successRatio = successRatio;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}