package cn.edu.ruc.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.ruc.mapper.ImportLogMapper;
import cn.edu.ruc.mapper.StatMapper;
import cn.edu.ruc.mapper.TsbmRResultMapper;
import cn.edu.ruc.mapper.TsbmTemplateMapper;
import cn.edu.ruc.mapper.TsbmWResultMapper;
import cn.edu.ruc.mapper.TsdbBindingMapper;
import cn.edu.ruc.mapper.TsdbCfgMapper;
import cn.edu.ruc.view.LineMap;
import cn.edu.ruc.view.StatBar;
import cn.edu.ruc.view.StatDataView;
import cn.edu.ruc.view.StatLine;
import cn.edu.ruc.view.StatView;

@RequestMapping("/stat/")
@Controller
public class StatController {
	@Resource
	TsbmWResultMapper tsbmWResultMapper;
	@Resource
	TsbmRResultMapper tsbmRResultMapper;
	@Resource
	ImportLogMapper importLogMapper;
	@Resource
	TsdbCfgMapper tsdbCfgMapper;
	@Resource
	TsbmTemplateMapper templateMapper;
	@Resource
	TsdbBindingMapper tsdbBindingMapper;
	@Resource
	StatMapper statMapper;
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView view =new ModelAndView("/stat/index");
		List<Object> dblist = tsdbCfgMapper.selectList();
		view.addObject("dblist",dblist);
		return view;
	}
	@RequestMapping("/get")
	@ResponseBody
	public Object initStatData(@RequestParam(required=false)Integer[] cfgIds) {
		List<StatBar> importBar = statMapper.importBar(cfgIds);
		Map<Long,String> cfgKeyValue=new HashMap<Long,String>();
		Map<Long,StatLine> cfgKeyLines=new HashMap<Long,StatLine>();
		for(StatBar bar:importBar) {
			cfgKeyValue.put(bar.getCfgId(), bar.getCfgName());
			StatLine statLine = new StatLine();
			statLine.setCfgName(bar.getCfgName());
			cfgKeyLines.put(bar.getCfgId(), statLine);
		}
		List<LineMap> importLines = statMapper.importLine(cfgIds);
		for(int i=1;i<=importLines.size();i++) {
			StatLine statLine = cfgKeyLines.get(importLines.get(i-1).getCfgId());
			statLine.getKeys().add(statLine.getKeys().size()+1);
			statLine.getValues().add(importLines.get(i-1).getValue());
		}
		List<StatLine> lines=new ArrayList<StatLine>();
		for(StatBar bar:importBar) {
			lines.add(cfgKeyLines.get(bar.getCfgId()));
		}
		StatDataView importDataView = new StatDataView(importBar, lines);
		return importDataView;
	}
}
