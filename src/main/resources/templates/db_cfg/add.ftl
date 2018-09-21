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
		<div class="col-xs-8" >
			  <div class="box" id="body">
			  	   <div class="box-header">
			           <h3 class="box-title">数据对象</h3>
			       </div>
				   <form class="form-horizontal" action="/base/db_cfg/save" method="post">
              <div class="box-body col-xs-12">
                <div class="form-group">
                  <label for="cfgName" class="col-sm-2 control-label">配置名称</label>

                  <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" id="name" placeholder="name">
                  </div>
                </div>
                <div class="form-group">
                  <label for="cfgName" class="col-sm-2 control-label">数据库名称</label>

                  <div class="col-sm-10">
                  	 <select class="form-control" name="bindingId">
			                		<#if bdlist?exists>
											   		<#list bdlist as data>
											   			<option value="${data.id}">${data.dbName}</option>
											   		</#list>
											   	</#if>
			                  </select>	
                  </div>
                </div>
                <div class="form-group">
                  <label for="ip" class="col-sm-2 control-label">ip</label>

                  <div class="col-sm-10">
                    <input type="text" name="dbIp"  class="form-control" id="ip" placeholder="ip">
                  </div>
                </div>
                <div class="form-group">
                  <label for="port" class="col-sm-2 control-label">port</label>

                  <div class="col-sm-10">
                    <input type="text" name="dbPort" class="form-control" id="port" placeholder="dbName">
                  </div>
                </div>
                <div class="form-group">
                  <label for="username" class="col-sm-2 control-label">username</label>

                  <div class="col-sm-10">
                    <input type="text" name="dbUser"  class="form-control" id="username" placeholder="username">
                  </div>
                </div>
                <div class="form-group">
                  <label for="passwd" class="col-sm-2 control-label">password</label>

                  <div class="col-sm-10">
                    <input type="text" name="dbPasswd" class="form-control" id="passwd" placeholder="password">
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