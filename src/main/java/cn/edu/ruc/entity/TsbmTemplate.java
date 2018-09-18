package cn.edu.ruc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TsbmTemplate implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String testMode ="write";

    private Integer dynStatus =0 ;

    private String dynValues;

    private Integer backgroundStatus =0 ;

    private Integer sensorNum;

    private Integer deviceNum;

    private Date startTime;

    private Date endTime;

    private Integer step =7000;

    private Integer cacheTimes;

    private Integer writeClients;

    private double loseRatio;

    private Integer writePulse;

    private Long readPeriod;

    private Integer readClients;

    private BigDecimal readSimpleRatio;

    private BigDecimal readAggreRatio;

    private BigDecimal readShrinkRatio;
    private BigDecimal readHighRatio=new BigDecimal(0);

    private Integer readPulse;

    private BigDecimal functionLineRatio=new BigDecimal(0.036);

    private BigDecimal functionSinRatio = new BigDecimal(0.352);

    private BigDecimal functionSquareRatio = new BigDecimal(0.512);

    private BigDecimal functionRandomRatio = new BigDecimal(0.054);

    private BigDecimal functionConstantRatio = new BigDecimal(0.054);

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

    public String getTestMode() {
        return testMode;
    }

    public void setTestMode(String testMode) {
        this.testMode = testMode;
    }

    public Integer getDynStatus() {
        return dynStatus;
    }

    public void setDynStatus(Integer dynStatus) {
        this.dynStatus = dynStatus;
    }

    public String getDynValues() {
        return dynValues;
    }

    public void setDynValues(String dynValues) {
        this.dynValues = dynValues;
    }

    public Integer getBackgroundStatus() {
        return backgroundStatus;
    }

    public void setBackgroundStatus(Integer backgroundStatus) {
        this.backgroundStatus = backgroundStatus;
    }

    public Integer getSensorNum() {
        return sensorNum;
    }

    public void setSensorNum(Integer sensorNum) {
        this.sensorNum = sensorNum;
    }

    public Integer getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(Integer deviceNum) {
        this.deviceNum = deviceNum;
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

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getCacheTimes() {
        return cacheTimes;
    }

    public void setCacheTimes(Integer cacheTimes) {
        this.cacheTimes = cacheTimes;
    }

    public Integer getWriteClients() {
        return writeClients;
    }

    public void setWriteClients(Integer writeClients) {
        this.writeClients = writeClients;
    }


    public Integer getWritePulse() {
        return writePulse;
    }

    public void setWritePulse(Integer writePulse) {
        this.writePulse = writePulse;
    }

    public Long getReadPeriod() {
        return readPeriod;
    }

    public void setReadPeriod(Long readPeriod) {
        this.readPeriod = readPeriod;
    }

    public Integer getReadClients() {
        return readClients;
    }

    public void setReadClients(Integer readClients) {
        this.readClients = readClients;
    }

    public BigDecimal getReadSimpleRatio() {
        return readSimpleRatio;
    }

    public void setReadSimpleRatio(BigDecimal readSimpleRatio) {
        this.readSimpleRatio = readSimpleRatio;
    }

    public BigDecimal getReadAggreRatio() {
        return readAggreRatio;
    }

    public void setReadAggreRatio(BigDecimal readAggreRatio) {
        this.readAggreRatio = readAggreRatio;
    }

    public BigDecimal getReadShrinkRatio() {
        return readShrinkRatio;
    }

    public void setReadShrinkRatio(BigDecimal readShrinkRatio) {
        this.readShrinkRatio = readShrinkRatio;
    }

    public Integer getReadPulse() {
        return readPulse;
    }

    public void setReadPulse(Integer readPulse) {
        this.readPulse = readPulse;
    }

    public BigDecimal getFunctionLineRatio() {
        return functionLineRatio;
    }

    public void setFunctionLineRatio(BigDecimal functionLineRatio) {
        this.functionLineRatio = functionLineRatio;
    }

    public BigDecimal getFunctionSinRatio() {
        return functionSinRatio;
    }

    public void setFunctionSinRatio(BigDecimal functionSinRatio) {
        this.functionSinRatio = functionSinRatio;
    }

    public BigDecimal getFunctionSquareRatio() {
        return functionSquareRatio;
    }

    public void setFunctionSquareRatio(BigDecimal functionSquareRatio) {
        this.functionSquareRatio = functionSquareRatio;
    }

    public BigDecimal getFunctionRandomRatio() {
        return functionRandomRatio;
    }

    public void setFunctionRandomRatio(BigDecimal functionRandomRatio) {
        this.functionRandomRatio = functionRandomRatio;
    }

    public BigDecimal getFunctionConstantRatio() {
        return functionConstantRatio;
    }

    public void setFunctionConstantRatio(BigDecimal functionConstantRatio) {
        this.functionConstantRatio = functionConstantRatio;
    }

	public double getLoseRatio() {
		return loseRatio;
	}

	public void setLoseRatio(double loseRatio) {
		this.loseRatio = loseRatio;
	}

	public BigDecimal getReadHighRatio() {
		return readHighRatio;
	}

	public void setReadHighRatio(BigDecimal readHighRatio) {
		this.readHighRatio = readHighRatio;
	}
}