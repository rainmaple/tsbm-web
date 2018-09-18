package cn.edu.ruc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.ruc.mapper.ImportLogMapper;
import cn.edu.ruc.mapper.TsbmRResultMapper;
import cn.edu.ruc.mapper.TsbmTemplateMapper;
import cn.edu.ruc.mapper.TsbmWResultMapper;
import cn.edu.ruc.mapper.TsdbBindingMapper;
import cn.edu.ruc.mapper.TsdbCfgMapper;

@RequestMapping("/base/")
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
}
