package cn.edu.ruc.entity;

public class ImportLog {
    private Integer wId;

    private Integer seq;

    private Integer sumSeq;

    private Long curSumPoints;

    private Long sumPoints;

    private Long pps;

    private Long beginTime;

    private Long endTime;

    private Integer status;

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getSumSeq() {
        return sumSeq;
    }

    public void setSumSeq(Integer sumSeq) {
        this.sumSeq = sumSeq;
    }

    public Long getCurSumPoints() {
        return curSumPoints;
    }

    public void setCurSumPoints(Long curSumPoints) {
        this.curSumPoints = curSumPoints;
    }

    public Long getSumPoints() {
        return sumPoints;
    }

    public void setSumPoints(Long sumPoints) {
        this.sumPoints = sumPoints;
    }

    public Long getPps() {
        return pps;
    }

    public void setPps(Long pps) {
        this.pps = pps;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}