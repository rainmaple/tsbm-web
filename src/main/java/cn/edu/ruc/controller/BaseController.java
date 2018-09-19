package cn.edu.ruc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.ruc.check.CheckCore;
import cn.edu.ruc.entity.TsbmBatch;
import cn.edu.ruc.entity.TsbmTemplate;
import cn.edu.ruc.entity.TsdbBinding;
import cn.edu.ruc.entity.TsdbCfg;
import cn.edu.ruc.mapper.ImportLogMapper;
import cn.edu.ruc.mapper.TsbmBatchMapper;
import cn.edu.ruc.mapper.TsbmRResultMapper;
import cn.edu.ruc.mapper.TsbmTemplateMapper;
import cn.edu.ruc.mapper.TsbmWResultMapper;
import cn.edu.ruc.mapper.TsdbBindingMapper;
import cn.edu.ruc.mapper.TsdbCfgMapper;

@RequestMapping("/base/")
@Controller
public class BaseController {
	@Resource
	TsdbBindingMapper tsdbBindingMapper;
	@Resource
	ImportLogMapper importLogMapper;
	@Resource
	TsbmWResultMapper tsbmWResultMapper;
	@Resource
	TsbmRResultMapper tsbmRResultMapper;
	@Resource
	CheckCore checkCore;
	@RequestMapping("param/list")
	@ResponseBody
	public ModelAndView listTsdbBinding(HttpServletRequest request,TsdbBinding tsdbBinding){
		ModelAndView view =new ModelAndView("/param/list");
		List<Object> bindingList = tsdbBindingMapper.selectList();
		view.addObject("bindingList",bindingList);
		List<Object> dbList = tsdbCfgMapper.selectList();
		view.addObject("dbList",dbList);
		List<Object> tmpList = templateMapper.selectList();
		view.addObject("tmpList",tmpList);
		return view;
	}
	@RequestMapping("add/binding")
	@ResponseBody
	public Object insertTsdbBinding(HttpServletRequest request,TsdbBinding tsdbBinding){
		tsdbBindingMapper.insertTsbinding(tsdbBinding);
		return tsdbBinding;
	}
	@RequestMapping("list/binding")
	@ResponseBody
	public Object bindingList(HttpServletRequest request) {
		List<Object> list = tsdbBindingMapper.selectList();
		return ResponseMap.okMap(list);
	}
	@RequestMapping("remove/binding")
	@ResponseBody
	public Object bindingRemove(HttpServletRequest request,Long id) {
		tsdbBindingMapper.deleteById(id);
		return ResponseMap.okMap(null);
	}
	
	
	// db_cfg
	@Resource
	TsdbCfgMapper tsdbCfgMapper;
	@RequestMapping("add/db_cfg")
	@ResponseBody
	public Object insertTsdbCfg(HttpServletRequest request,TsdbCfg cfg){
		tsdbCfgMapper.insert(cfg);
		// TODO 新增批次
		return cfg;
	}
	@RequestMapping("list/db_cfg")
	@ResponseBody
	public Object dbCfgList(HttpServletRequest request) {
		List<Object> list = tsdbCfgMapper.selectList();
		return ResponseMap.okMap(list);
	}
	@RequestMapping("remove/db_cfg")
	@ResponseBody
	public Object dbCfgRemove(HttpServletRequest request,Long id) {
		tsdbCfgMapper.deleteByPrimaryKey(id.intValue());
		return ResponseMap.okMap(null);
	}
	
	
	@Resource
	TsbmTemplateMapper templateMapper;
	//template
	@RequestMapping("add/template")
	@ResponseBody
	public Object insertTemplate(HttpServletRequest request,TsbmTemplate template){
		//写入
		templateMapper.insert(template);
		return template;
	}
	@RequestMapping("list/template")
	@ResponseBody
	public Object templateList(HttpServletRequest request) {
		List<Object> list = templateMapper.selectList();
		return ResponseMap.okMap(list);
	}
	@RequestMapping("remove/template")
	@ResponseBody
	public Object templateRemove(HttpServletRequest request,Long id) {
		templateMapper.deleteByPrimaryKey(id.intValue());
		return ResponseMap.okMap(null);
	}
	
	@Resource
	TsbmBatchMapper batchMapper;
	//template
	@RequestMapping("add/batch")
	@ResponseBody
	public Object insertbatch(HttpServletRequest request,TsbmBatch batch){
		System.out.println(batch);
		//写入
		batchMapper.insert(batch);
		return batch;
	}
	@RequestMapping("/batch/to_add")
	public ModelAndView toBatch(HttpServletRequest request,ModelAndView view) {
	    List<Object> cfgs = tsdbCfgMapper.selectList();
	    System.out.println(cfgs.size());
	    view.addObject("cfgs", cfgs);
	    List<Object> tmps = templateMapper.selectList();
	    view.addObject("tmps", tmps);
	    view.setViewName("/batch/add");
		return view;
	}
	@RequestMapping("list/batch")
//	@ResponseBody
	public ModelAndView batchList(HttpServletRequest request,ModelAndView view) {
		 view.setViewName("/batch/list");
		List<TsbmBatch> list = batchMapper.selectList();
		for(TsbmBatch batch:list){
			Integer id = batch.getId();
			Integer tmpId = Integer.parseInt(batch.getTemplateId());
			double progressDouble=0.2;
			if(tmpId.equals(1)){
				//导入进度查询 import_log
				progressDouble = importLogMapper.selectProgressByBatchId(id);
			}else if(tmpId.equals(2)||tmpId.equals(4)){
				//写入进度查询 write_result
				int count = tsbmWResultMapper.countByBatchId(id);
				TsbmTemplate tmp = templateMapper.selectByPrimaryKey(2);
				String dynValues = tmp.getDynValues();
				String[] split = dynValues.split(",");
				int dynSum=split.length;
				progressDouble=count/(double)dynSum;
				
			}else if(tmpId.equals(3)||tmpId.equals(5)){
				//读取进度查询 read_result
				int count = tsbmRResultMapper.countByBatchId(id);
				TsbmTemplate tmp = templateMapper.selectByPrimaryKey(3);
				String dynValues = tmp.getDynValues();
				String[] split = dynValues.split(",");
				int dynSum=split.length;
				progressDouble=count/(double)dynSum;
			}
			batch.setProgress((int)(progressDouble*100)+"%");
		}
		view.addObject("list",list);
		List<Object> dblist = tsdbCfgMapper.selectList();
		view.addObject("dblist",dblist);
		List<Object> tmpList = templateMapper.selectList();
		view.addObject("tmplist",tmpList);
		return view;
	}
	@RequestMapping("remove/batch")
	@ResponseBody
	public Object batchRemove(HttpServletRequest request,Long id) {
		batchMapper.deleteByPrimaryKey(id.intValue());
		return ResponseMap.okMap(null);
	}
	@RequestMapping("batch/start")
	@ResponseBody
	public Object batchStart(HttpServletRequest request,Long id) {
		//校验是否有执行中的，有的话不可以进行别的
		
		return ResponseMap.okMap(null);
	}
	@RequestMapping("batch/end")
	@ResponseBody
	public Object batchEnd(HttpServletRequest request,Long id) {
		return ResponseMap.okMap(null);
	}
	@RequestMapping("batch/view")
	public ModelAndView batchView(HttpServletRequest request,Long id,ModelAndView view) {
		view.setViewName("/batch/view");
		List<TsbmBatch> list = batchMapper.selectList();
		view.addObject("list",list);
		return view;
	}
	@RequestMapping("db/start_test")
	@ResponseBody
	public Object startTestDB(HttpServletRequest request,final Integer id) {
		// 1，新增对应批次
		final TsdbCfg cfg = tsdbCfgMapper.selectByPrimaryKey(id);
		final List<Object> tmps = templateMapper.selectList();
		final List<TsbmBatch> batchs=new ArrayList<TsbmBatch>();
		for(Object obj:tmps) {
			TsbmTemplate tmp=(TsbmTemplate)obj;
			TsbmBatch batch= new TsbmBatch();
			batch.setCfgId(id);//db_id
			batch.setTemplateId(tmp.getId().toString());
			batch.setTestStatus(1);
			batch.setName(cfg.getDbName()+"_"+tmp.getName());
			batchMapper.insert(batch);
			batchs.add(batch);
			System.out.println(batch.getId());
		}
		// 2，开始测试对应数据库   5个测试模板
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.execute(new Runnable() {
			@Override
			public void run() {
				TsdbBinding binding = tsdbBindingMapper.selectById(id);
				for(TsbmBatch batch:batchs) {
					Integer cfgId = batch.getCfgId();
					String tmpId = batch.getTemplateId();
					TsdbCfg cfg = tsdbCfgMapper.selectByPrimaryKey(cfgId);
					TsbmTemplate tmp = templateMapper.selectByPrimaryKey(Integer.parseInt(tmpId));
					boolean main = checkCore.main(binding, cfg, tmp,batch.getId());
				}
			}
		});
		return ResponseMap.okMap(null);
	}
}
