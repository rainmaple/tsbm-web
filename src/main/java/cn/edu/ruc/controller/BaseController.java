package cn.edu.ruc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String bindingSave(HttpServletRequest request,TsdbBinding tsdbBinding){
		tsdbBindingMapper.insertTsbinding(tsdbBinding);
		return "redirect:/base/param/list";
	}
	@RequestMapping("binding/update")
	public String bindingUpdate(HttpServletRequest request,TsdbBinding tsdbBinding){
		tsdbBindingMapper.updateById(tsdbBinding);
		return "redirect:/base/param/list";
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
	public String tsdbCfgsave(HttpServletRequest request,TsdbCfg cfg){
		tsdbCfgMapper.insert(cfg);
		return "redirect:/base/param/list";
	}
	@RequestMapping("db_cfg/update")
	public String tsdbCfgUpdate(HttpServletRequest request,TsdbCfg cfg){
		tsdbCfgMapper.updateByPrimaryKeySelective(cfg);
		return "redirect:/base/param/list";
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
		TsbmTemplate model = templateMapper.selectByPrimaryKey(id.intValue());
		view.addObject("model",model);
		return view;
	}
	@RequestMapping("template/update")
	public String tsdbCfgsave(HttpServletRequest request,TsbmTemplate record,BindingResult bindingResult){
		templateMapper.updateByPrimaryKeySelective(record);
		return "redirect:/base/param/list";
	}
	@Resource
	TsbmBatchMapper batchMapper;
	@RequestMapping("list/batch")
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
			//避免重复导入相同，数据重复加载
			if(progressDouble>=100) progressDouble=100;
			batch.setProgress((int)(progressDouble*100)+"%");
		}
		view.addObject("list",list);
		List<Object> dblist = tsdbCfgMapper.selectList();
		view.addObject("dblist",dblist);
		List<Object> tmpList = templateMapper.selectList();
		view.addObject("tmplist",tmpList);
		return view;
	}
	@RequestMapping("db/start_test")
	@ResponseBody
	public Object startTestDB(HttpServletRequest request,@RequestParam("tmpIds[]")final Integer[] tmpIds,final Integer cfgId) {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateStr = sdf.format(new Date());
		// 1，新增对应批次
		final TsdbCfg cfg = tsdbCfgMapper.selectByPrimaryKey(cfgId);
		List<TsbmTemplate> tmps = templateMapper.selectListByIds(tmpIds);
		final List<TsbmBatch> batchs=new ArrayList<TsbmBatch>();
		for(Object obj:tmps) {
			TsbmTemplate tmp=(TsbmTemplate)obj;
			TsbmBatch batch= new TsbmBatch();
			batch.setCfgId(cfgId);//db_id
			batch.setTemplateId(tmp.getId().toString());
			batch.setTestStatus(1);
			batch.setName(cfg.getName()+"_"+tmp.getName()+"_"+dateStr);
			batchMapper.insert(batch);
			batchs.add(batch);
		}
		// 2，开始测试对应数据库   测试模板
		ExecutorService pool = Executors.newFixedThreadPool(5);
		pool.execute(new Runnable() {
			@Override
			public void run() {
				for(TsbmBatch batch:batchs) {
					Integer cfgId = batch.getCfgId();
					String tmpId = batch.getTemplateId();
					TsdbCfg cfg = tsdbCfgMapper.selectByPrimaryKey(cfgId);
					TsdbBinding binding = tsdbBindingMapper.selectById(cfg.getBindingId());
					TsbmTemplate tmp = templateMapper.selectByPrimaryKey(Integer.parseInt(tmpId));
					boolean main = checkCore.main(binding, cfg, tmp,batch.getId());
				}
			}
		});
		return ResponseMap.okMap(null);
	}
}
