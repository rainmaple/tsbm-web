<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>tsbm - web</title>
   <link rel="stylesheet" href="/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="/dist/css/skins/skin-blue.min.css">
</head>
<body class="layui-layout-body skin-blue">
<#include  "/common/left.ftl"/>
  <div class="layui-body content-wrapper">
    <!-- 内容主体区域 -->
   <!--  <div>
	    
    </div> -->
    <!-- <div style="padding: 15px;padding-bottom: 1px;" id="body">
    </div> -->
	<section class="content-header">
		<h1>
                 新增配置绑定参数
        <small>功能:该配置可以绑定名称和数据库Adapter的全类</small>
      </h1>
	</section>
	<section class="content content-wrapper">
		<div class="row">
		<div class="col-xs-12" >
			  <div class="box" id="body">
			  	   <div class="box-header">
			           <h3 class="box-title">模板对象</h3>
			       </div>
				   <form class="form-horizontal" action="/base/template/update" method="post">
				   		<input type="hidden" name="id" value="${model.id}" />
              <div class="box-body col-xs-12">
              	<div class="col-xs-6 left_div" style="margin-top: 25px;border-right-width: 1px;border-right-style: solid;border-right-color: #333333;"><!-- 左侧10条 -->
					   					<div class="form-group">
			                  <label for="name" class="col-sm-2 control-label">模板名称</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="name" class="form-control" value="${model.name}"  id="name" placeholder="name">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="testMode" class="col-sm-2 control-label">测试模式</label>
			
			                  <div class="col-sm-10">
			                  	 <input type="text" name="testMode" class="form-control" value="${model.testMode}" id="testMode" placeholder="read or write" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="dynStatus" class="col-sm-2 control-label">动态状态</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="dynStatus" value="${model.dynStatus}" class="form-control" id="dynStatus" placeholder="0 or 1">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="dynValues" class="col-sm-2 control-label">动态值</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="dynValues" value="${model.dynValues}" class="form-control" id="dynValues" placeholder="eg. 1,3,5,10" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="backgroundStatus" class="col-sm-2 control-label">是否均衡执行</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="backgroundStatus" value="${model.backgroundStatus}"  class="form-control" id="backgroundStatus" placeholder="0 or 1">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="sensorNum" class="col-sm-2 control-label">传感器数</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="sensorNum" class="form-control" value="${model.sensorNum}" id="sensorNum" placeholder="int,eg. 150" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="deviceNum" class="col-sm-2 control-label">设备数</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="deviceNum" class="form-control" value="${model.deviceNum}"  id="deviceNum" placeholder="int,eg. 100" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="startTime" class="col-sm-2 control-label">历史数据开始时间</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="startTime" class="form-control" value="${model.startTime?string("yyyy-MM-dd HH:mm:ss")}" id="startTime" placeholder="date,YYYY-MM-DD HH:mm:ss eg. 2018-01-01 00:00:00" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="endTime" class="col-sm-2 control-label">历史数据结束时间</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="endTime" class="form-control" value="${model.endTime?string("yyyy-MM-dd HH:mm:ss")}" id="endTime" placeholder="date,YYYY-MM-DD HH:mm:ss eg. 2018-01-03 00:00:00" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="step" class="col-sm-2 control-label">数据采集间隔</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="step" class="form-control" value="${model.step}" id="step" placeholder="int unit is ms,eg 7000" >
			                  </div>
			                </div>
	              </div>
				   			<div class="col-xs-6 left_div" style="margin-top: 25px;"><!-- 右侧10条 -->
					   					<div class="form-group">
			                  <label for="cacheTimes" class="col-sm-2 control-label">写入数据打包缓存次数</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="cacheTimes" class="form-control" value="${model.cacheTimes}" id="cacheTimes" placeholder="int">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="writeClients" class="col-sm-2 control-label">写入客户端</label>
			
			                  <div class="col-sm-10">
			                  		<input type="text" name="writeClients" class="form-control" value="${model.writeClients}" id="writeClients" placeholder="int" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="loseRatio" class="col-sm-2 control-label">写入数据丢失率</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="loseRatio"  class="form-control" value="${model.loseRatio}" id="loseRatio" placeholder="float" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="writePulse" class="col-sm-2 control-label">写入数据thinkTime</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="writePulse" class="form-control" value="${model.writePulse}" id="writePulse" placeholder="int">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="readPeriod" class="col-sm-2 control-label">读运行时间</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="readPeriod"  class="form-control" value="${model.readPeriod}" id="readPeriod"  placeholder="int">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="readClients" class="col-sm-2 control-label">读客户端数</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="readClients" class="form-control" value="${model.readClients}" id="readClients" placeholder="int" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="readPulse" class="col-sm-2 control-label">读thinkTime</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="readPulse" class="form-control" value="${model.readPulse}" id="readPulse" placeholder="int" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="readSimpleRatio" class="col-sm-2 control-label">简单读率</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="readSimpleRatio" class="form-control" value="${model.readSimpleRatio}" id="readSimpleRatio" placeholder="float,eg 0.8" >
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="readAggreRatio" class="col-sm-2 control-label">分析读率(非group by)</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="readAggreRatio" class="form-control" value="${model.readAggreRatio}" id="readAggreRatio" placeholder="float,eg 0.1">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label for="readShrinkRatio" class="col-sm-2 control-label">分析读率(group by)</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" name="readShrinkRatio" class="form-control" value="${model.readShrinkRatio}" id="readShrinkRatio" placeholder="float,eg 0.1">
			                  </div>
			                </div>
			                
	              </div>
				   			</div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button type="submit" class="btn btn-info pull-right">提交</button>
              </div>
              <!-- /.box-footer -->
            </form>
			    </div> 
		</div>
		</div>
	</section>
  </div>
<script src="/js/jquery.js"></script>
<script src="/layer/layer.js"></script>
<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<script>
</script>
</body>
</html>