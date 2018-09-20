package cn.edu.ruc.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StatDataView implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<StatBar> bar=new ArrayList<StatBar>();
	private List<StatLine> line=new ArrayList<StatLine>();
	public List<StatBar> getBar() {
		return bar;
	}
	public void setBar(List<StatBar> bar) {
		this.bar = bar;
	}
	public List<StatLine> getLine() {
		return line;
	}
	public void setLine(List<StatLine> line) {
		this.line = line;
	}
}
