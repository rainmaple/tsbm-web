package cn.edu.ruc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView listTsdbBinding(HttpServletRequest request){
		ModelAndView view =new ModelAndView("/param/list");
		List<Object> bindingList = tsdbBindingMapper.selectList();
		view.addObject("bindingList",bindingList);
		List<Object> dbList = tsdbCfgMapper.selectList();
		view.addObject("dbList",dbList);
		List<Object> tmpList = templateMapper.selectList();
		view.addObject("tmpList",tmpList);
		return view;
	}
	@RequestMapping("binding/add")
	public ModelAndView bindingadd(HttpServletRequest request){
		ModelAndView view=new ModelAndView("/binding/add");
		return view;
	}
	@RequestMapping("binding/edit")
	public ModelAndView bindingEdit(HttpServletRequest request,Long id){
		ModelAndView view=new ModelAndView("/binding/edit");
		TsdbBinding model = tsdbBindingMapper.selectById(id.intValue());
		view.addObject("model",model);
		return view;
	}
	@RequestMapping("binding/save")
	public ModelAndView bindingSave(HttpServletRequest request,TsdbBinding tsdbBinding){
		tsdbBindingMapper.insertTsbinding(tsdbBinding);
		return listTsdbBinding(request);
	}
	@RequestMapping("binding/update")
	public ModelAndView bindingUpdate(HttpServletRequest request,TsdbBinding tsdbBinding){
		tsdbBindingMapper.updateById(tsdbBinding);
		return listTsdbBinding(request);
	}
	@RequestMapping("binding/del")
	public ModelAndView bindingRemove(HttpServletRequest request,Long id) {
		tsdbBindingMapper.deleteById(id);
		return listTsdbBinding(request);
	}
	
	
	// db_cfg
	@Resource
	TsdbCfgMapper tsdbCfgMapper;
	@RequestMapping("db_cfg/add")
	public ModelAndView insertTsdbCfg(HttpServletRequest request){
		ModelAndView view=new ModelAndView("/db_cfg/add");
		List<Object> bdlist = tsdbBindingMapper.selectList();
		view.addObject("bdlist",bdlist);
		return view;
	}
	@RequestMapping("db_cfg/edit")
	public ModelAndView insertTsdbCfg(HttpServletRequest request,Long id){
		ModelAndView view=new ModelAndView("/db_cfg/edit");
		TsdbCfg cfg = tsdbCfgMapper.selectByPrimaryKey(id.intValue());
		List<Object> bdlist = tsdbBindingMapper.selectList();
		view.addObject("bdlist",bdlist);
		view.addObject("model",cfg);
		return view;
	}
	@RequestMapping("db_cfg/save")
	public ModelAndView tsdbCfgsave(HttpServletRequest request,TsdbCfg cfg){
		tsdbCfgMapper.insert(cfg);
		return listTsdbBinding(request);
	}
	@RequestMapping("db_cfg/update")
	public ModelAndView tsdbCfgUpdate(HttpServletRequest request,TsdbCfg cfg){
		tsdbCfgMapper.updateByPrimaryKeySelective(cfg);
		return listTsdbBinding(request);
	}
	@RequestMapping("db_cfg/del")
	public ModelAndView dbCfgRemove(HttpServletRequest request,Long id) {
		tsdbCfgMapper.deleteByPrimaryKey(id.intValue());
		return listTsdbBinding(request);
	}
	
	
	@Resource
	TsbmTemplateMapper templateMapper;
	@RequestMapping("template/edit/{id}")
	public ModelAndView editTemplate(HttpServletRequest request,@PathVariable(name="id")Long id){
		ModelAndView view=new ModelAndView("/template/edit");
		System.out.println(id);
		TsbmTemplate model = templateMapper.selectByPrimaryKey(id.intValue());
		view.addObject("model",model);
		return view;
	}
	@RequestMapping("template/update")
	public ModelAndView tsdbCfgsave(HttpServletRequest request,TsbmTemplate record,BindingResult bindingResult){
		templateMapper.updateByPrimaryKeySelective(record);
		return listTsdbBinding(request);
	}
//	//template
//	@RequestMapping("add/template")
//	@ResponseBody
//	public Object insertTemplate(HttpServletRequest request,TsbmTemplate template){
//		//写入
//		templateMapper.insert(template);
//		return template;
//	}
//	@RequestMapping("list/template")
//	@ResponseBody
//	public Object templateList(HttpServletRequest request) {
//		List<Object> list = templateMapper.selectList();
//		return ResponseMap.okMap(list);
//	}
//	@RequestMapping("remove/template")
//	@ResponseBody
//	public Object templateRemove(HttpServletRequest request,Long id) {
//		templateMapper.deleteByPrimaryKey(id.intValue());
//		return ResponseMap.okMap(null);
//	}
	
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
