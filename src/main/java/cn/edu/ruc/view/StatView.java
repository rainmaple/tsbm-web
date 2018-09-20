package cn.edu.ruc.view;

import java.io.Serializable;

public class StatView implements Serializable {
	private static final long serialVersionUID = 1L;
	private StatDataView importData;
	private StatDataView readData;
	private StatDataView appendData;
	private StatDataView mulAppendData;
	private StatDataView mulReadData;
	public StatDataView getImportData() {
		return importData;
	}
	public void setImportData(StatDataView importData) {
		this.importData = importData;
	}
	public StatDataView getReadData() {
		return readData;
	}
	public void setReadData(StatDataView readData) {
		this.readData = readData;
	}
	public StatDataView getAppendData() {
		return appendData;
	}
	public void setAppendData(StatDataView appendData) {
		this.appendData = appendData;
	}
	public StatDataView getMulAppendData() {
		return mulAppendData;
	}
	public void setMulAppendData(StatDataView mulAppendData) {
		this.mulAppendData = mulAppendData;
	}
	public StatDataView getMulReadData() {
		return mulReadData;
	}
	public void setMulReadData(StatDataView mulReadData) {
		this.mulReadData = mulReadData;
	}
}
