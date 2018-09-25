package cn.edu.ruc.check;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.edu.ruc.base.TsDataSource;
import cn.edu.ruc.base.TsParamConfig;
import cn.edu.ruc.base.TsReadResult;
import cn.edu.ruc.base.TsWriteResult;
import cn.edu.ruc.biz.CoreBiz;
import cn.edu.ruc.entity.ImportLog;
import cn.edu.ruc.entity.TsbmRResult;
import cn.edu.ruc.entity.TsbmTemplate;
import cn.edu.ruc.entity.TsbmWResult;
import cn.edu.ruc.entity.TsdbBinding;
import cn.edu.ruc.entity.TsdbCfg;
import cn.edu.ruc.mapper.ImportLogMapper;
import cn.edu.ruc.mapper.TsbmRResultMapper;
import cn.edu.ruc.mapper.TsbmTemplateMapper;
import cn.edu.ruc.mapper.TsbmWResultMapper;
import cn.edu.ruc.mapper.TsdbBindingMapper;
import cn.edu.ruc.mapper.TsdbCfgMapper;
@Component
public class CheckCore {
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
	public  boolean main(TsdbBinding binding,TsdbCfg cfg,TsbmTemplate tmp,Integer batchId) {
		switch (tmp.getId().intValue()) {
		case 1:
			importTest(binding,cfg,tmp,batchId);
   			break;
		case 2:
			writeTest(binding,cfg,tmp,batchId);
			break;
		case 3:
			readTest(binding,cfg,tmp,batchId);
			break;
		case 4:
			bWriteTest(binding,cfg,tmp,batchId);
			break;
		case 5:
			bReadTest(binding,cfg,tmp,batchId);
			break;

		default:
			break;
		}
		return true;
	}
	//web显示5部分信息，测试数据结果，测试过程不显示，最后直接显示结果，统计结果，并且可以下载
	private  void importTest(TsdbBinding binding,TsdbCfg cfg,TsbmTemplate tmp,Integer batchId) {
		TsParamConfig tsParamConfig=getTsParamConfig(tmp, batchId);
		TsDataSource tds = getTsDataSource(cfg, batchId, binding);
		CoreBiz biz;
		try {
			biz = new CoreBiz(tsParamConfig, tds);
			final LinkedList<long[]> writeLogs = biz.writeLogs;
			ExecutorService pool = Executors.newFixedThreadPool(2);
			pool.execute(new Runnable() {
				@Override
				public void run() {
					while(true) {
						if(biz.writeLogs.size()>0) {
							long[] first = biz.writeLogs.removeFirst();
							ImportLog record = logArrays2Log(first, batchId);
							// 讲日志保存到数据库
							importLogMapper.insert(record);
							if(first[0]+1>=first[1]) {
								break;
							}
						}else{
							try {
								Thread.sleep(100L);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
			pool.shutdown();
			TsWriteResult result = biz.insertPoints();
			TsbmWResult baseResult2WebResult = baseResult2WebResult(result, batchId);
			baseResult2WebResult.setClients(tsParamConfig.getWriteClients());
			tsbmWResultMapper.insert(baseResult2WebResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private  void writeTest(TsdbBinding binding,TsdbCfg cfg,TsbmTemplate tmp,Integer batchId) {
		String dynValues = tmp.getDynValues();
		String[] cliStrNums = dynValues.split(",");
		long virtualBeginTime=tmp.getEndTime().getTime();
		for(int index=0;index<cliStrNums.length;index++) {
			String cliNumStr = cliStrNums[index];
			int cliNum = Integer.parseInt(cliNumStr);
			TsParamConfig tsParamConfig=getTsParamConfig(tmp,batchId);
			
			tsParamConfig.setWriteClients(cliNum);
			int loop=10;
			tsParamConfig.setStartTime(virtualBeginTime+tmp.getCacheTimes()*tmp.getStep()*loop*index);
			tsParamConfig.setEndTime(virtualBeginTime+tmp.getCacheTimes()*tmp.getStep()*loop*(index+1));
			
			TsDataSource tds = getTsDataSource(cfg, batchId,binding);
			CoreBiz biz;
			try {
				biz = new CoreBiz(tsParamConfig, tds);
				TsWriteResult result = biz.insertPoints();
				TsbmWResult baseResult2WebResult = baseResult2WebResult(result, batchId);
				baseResult2WebResult.setClients(cliNum);
				tsbmWResultMapper.insert(baseResult2WebResult);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}
	private  void readTest(TsdbBinding binding,TsdbCfg cfg,TsbmTemplate tmp,Integer batchId) {
		String dynValues = tmp.getDynValues();
		String[] cliStrNums = dynValues.split(",");
		for(int index=0;index<cliStrNums.length;index++) {
			String cliNumStr = cliStrNums[index];
			int cliNum = Integer.parseInt(cliNumStr);
			TsParamConfig tsParamConfig=getTsParamConfig(tmp,batchId);
			tsParamConfig.setReadClients(cliNum);
			TsDataSource tds = getTsDataSource(cfg, batchId,binding);
			CoreBiz biz;
			try {
				biz = new CoreBiz(tsParamConfig, tds);
				TsReadResult result = biz.queryTest();
				TsbmRResult baseResult2WebQueryResult = baseResult2WebQueryResult(result, batchId);
				baseResult2WebQueryResult.setClients(cliNum);
				tsbmRResultMapper.insert(baseResult2WebQueryResult);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}			
	}
	private  void bWriteTest(TsdbBinding binding,TsdbCfg cfg,TsbmTemplate tmp,Integer batchId) {
		//FIXME 需要再进行完善
		boolean[] statusFlag= {false};
		try {
			ExecutorService pool = Executors.newFixedThreadPool(2);
			pool.execute(new Runnable() {
				@Override
				public void run() {
					TsbmTemplate bgTmp = templateMapper.selectByPrimaryKey(4);//read 背景
					TsParamConfig tsParamConfig=getTsParamConfig(bgTmp,batchId);
					TsDataSource tds = getTsDataSource(cfg, batchId,binding);
					CoreBiz biz=null;
					try {
						biz = new CoreBiz(tsParamConfig, tds);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					while(!statusFlag[0]) {
						try {
							biz.queryTest();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
			pool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeTest(binding, cfg, templateMapper.selectByPrimaryKey(2), batchId);
		statusFlag[0]=true;
	}
	private  void bReadTest(TsdbBinding binding,TsdbCfg cfg,TsbmTemplate tmp,Integer batchId) {
		//FIXME 需要再进行完善
		boolean[] statusFlag= {false};
		try {
			ExecutorService pool = Executors.newFixedThreadPool(2);
			pool.execute(new Runnable() {
				@Override
				public void run() {
					TsbmTemplate bgTmp = templateMapper.selectByPrimaryKey(5);//read 背景
					TsParamConfig tsParamConfig=getTsParamConfig(bgTmp,batchId);
					TsDataSource tds = getTsDataSource(cfg, batchId,binding);
					CoreBiz biz=null;
					try {
						biz = new CoreBiz(tsParamConfig, tds);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					while(!statusFlag[0]) {
						try {
							biz.insertPoints();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
			pool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		readTest(binding, cfg, tmp, batchId);
		statusFlag[0]=true;
	}
	public TsbmWResult baseResult2WebResult(TsWriteResult result,Integer batchId) {
		TsbmWResult wResult=new TsbmWResult();
		wResult.setBatchId(batchId);
		wResult.setCreateTime(new Date(result.getStartTime()));
		wResult.setPointsSum(result.getSumPoints());
		wResult.setCostTime(result.getEndTime()-result.getStartTime());
		wResult.setPps(result.getPps().longValue());
		wResult.setSuccessRatio(new BigDecimal(1.0));
		wResult.setMaxTimeout(result.getMaxTimeout().longValue());
		wResult.setMinTimeout(result.getMinTimeout().longValue());
		wResult.setAvgTimeout(result.getMeanTimeout().longValue());
		wResult.setTh50Timeout(result.getFiftyTimeout().longValue());
		wResult.setTh95Timeout(result.getNinty5Timeout().longValue());
		return wResult;
	}
	public ImportLog logArrays2Log(long[] arr,Integer batchId) {
		ImportLog log =new ImportLog();
		log.setwId(batchId);
		log.setSeq((int)arr[0]);
		log.setSumSeq((int)arr[1]);
		log.setCurSumPoints(arr[2]);
		log.setSumPoints(arr[3]);
		log.setPps(arr[4]);
		log.setBeginTime(arr[5]);
		log.setEndTime(arr[6]);
		log.setStatus((int)arr[7]);
		return log;
	}
	private TsbmRResult baseResult2WebQueryResult(TsReadResult result, Integer batchId) {
		TsbmRResult rResult = new TsbmRResult();
		rResult.setBatchId(batchId);
		rResult.setCreateTime(new Date(result.getStartTime()));
		rResult.setQuerySum(result.getSumRequests());
		rResult.setCostTime(result.getEndTime()-result.getStartTime());
		rResult.setQps(result.getTps().longValue());
		rResult.setSuccessRatio(new BigDecimal(result.getSuccessRatio()));
		rResult.setMaxTimeout(result.getMaxTimeout().longValue());
		rResult.setMinTimeout(result.getMinTimeout().longValue());
		rResult.setAvgTimeout(result.getMeanTimeout().longValue());
		rResult.setTh50Timeout(result.getFiftyTimeout().longValue());
		rResult.setTh95Timeout(result.getNinty5Timeout().longValue());
		return rResult;
	}
	private TsParamConfig getTsParamConfig(TsbmTemplate tmp,Integer batchId) {
		TsParamConfig config =new TsParamConfig();
		config.setBatchCode(batchId.toString());
		config.setBackgroupStatus(tmp.getBackgroundStatus());
		config.setDeviceNum(tmp.getDeviceNum());
		config.setSensorNum(tmp.getSensorNum());
		config.setCacheTimes(tmp.getCacheTimes());
		config.setWriteClients(tmp.getWriteClients());
		config.setStartTime(tmp.getStartTime().getTime());
		config.setEndTime(tmp.getEndTime().getTime());
		config.setStep(tmp.getStep().longValue());
		config.setLoseRatio(tmp.getLoseRatio());
		config.setWritePulse(tmp.getWritePulse());
		config.setReadPeriod(tmp.getReadPeriod());
		config.setReadClients(tmp.getReadClients());
		config.setReadSimpleRatio(tmp.getReadSimpleRatio().doubleValue());
		config.setReadAggreRatio(tmp.getReadAggreRatio().doubleValue());
		config.setReadShrinkRatio(tmp.getReadShrinkRatio().doubleValue());
		config.setReadHighRatio(tmp.getReadHighRatio().doubleValue());
		config.setReadPulse(tmp.getReadPulse());
		return config;
	}
	private TsDataSource getTsDataSource(TsdbCfg cfg,Integer batchId,TsdbBinding binding) {
		TsDataSource ds= new TsDataSource();
		ds.setBatchCode(batchId.toString());
		ds.setDbType(cfg.getDbName());
		ds.setDriverClass(binding.getDbClass());
		ds.setIp(cfg.getDbIp());
		ds.setPasswd(cfg.getDbPasswd());
		ds.setPort(cfg.getDbPort());
		ds.setUser(cfg.getDbUser());
		return ds;
	}
}	
