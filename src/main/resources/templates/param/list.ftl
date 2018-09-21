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
        参数配置
        <small>配置绑定参数，数据库参数，模板参数</small>
      </h1>
	</section>
	<section class="content content-wrapper">
		<div class="row">
		<div class="col-xs-12" >
			  <div class="box" id="body">
			  	   <div class="box-header">
			           <h3 class="box-title">绑定参数</h3><div type="submit" class="bth-bd-add btn btn-sm btn-primary btn-flat" style="float: right;">新增</div>
			       </div>
				   <div class="box-body table-responsive no-padding">
				   		<table class="table table-hover" >
				   			  <thead>
							    <tr>
							      <th>数据库名称</th>
							      <th>对应类名</th>
							      <th>操作</th>
							    </tr> 
							  </thead>
							   <tbody id="tbody">
							   	<#if bindingList?exists>
							   		<#list bindingList as data>
							   			<tr><td>${data.dbName}</td><td>${data.dbClass}</td>
							   				<td><div type="submit" class="bth-bd-edit btn btn-sm btn-success  btn-flat" style="float: right;"  data-id="${data.id}">更新</div>&nbsp;
							   				<div type="submit" class="bth-bd-del btn btn-sm btn-success  btn-flat" style="float: right;" data-id="${data.id}">删除</div>
							   				</td>
							   			 </tr>
							   		</#list>
							   </#if>
							  </tbody>
				   		</table>
				   </div>
			    </div>
		</div>
		</div>
		<div class="row">
		<div class="col-xs-12" >
			  <div class="box" id="body">
			  	   <div class="box-header">
			           <h3 class="box-title">数据库参数</h3><div type="submit" class="bth-dbcfg-add  btn btn-sm btn-primary btn-flat" style="float: right;">新增</div>
			       </div>
				   <div class="box-body table-responsive no-padding">
				   		<table class="table table-hover" >
				   			  <thead>
							    <tr>
							      <tr>
							      <th>配置名称</th>
							      <th>数据库名称</th>
							      <th>ip</th>
							      <th>port</th>
							      <th>username</th>
							      <th>passwd</th>
							      <th>操作</th>
							    </tr> 
							    </tr> 
							  </thead>
							   <tbody id="tbody">
							   	<#if dbList?exists>
							   		<#list dbList as data>
							   			<tr>
							   			<td>${data.name}</td>
							   			<td>${data.bindingId}</td>
							   			<td>${data.dbIp}</td>
							   			<td>${data.dbPort}</td>
							   			<td>${data.dbUser}</td>
							   			<td>${data.dbPasswd}</td>
							   			<td><div type="submit" class="bth-dbcfg-edit btn btn-sm btn-success  btn-flat" style="float: right;" data-id="${data.id}">更新</div>&nbsp;
							   				<div type="submit" class="bth-dbcfg-del btn btn-sm btn-success  btn-flat" style="float: right;" data-id="${data.id}">删除</div>
							   				
							   			</td>
							   			 </tr>
							   		</#list>
							   </#if>
							  </tbody>
				   		</table>
				   </div>
			    </div>
		</div>
		</div>
		<div class="row">
		<div class="col-xs-12" >
			  <div class="box" id="body">
			  	   <div class="box-header">
			           <h3 class="box-title">模板参数</h3><div type="submit" class="btn btn-sm btn-primary btn-flat" style="float: right;">新增</div>
			       </div>
				   <div class="box-body table-responsive no-padding">
				   		<table class="table table-hover" >
				   			  <thead>
							    <tr>
							      <th>模板名称</th>
							      <th>测试模式</th>
							      <th>负载均衡</th>
							      <th>是否动态及参数</th>
							      <th>设备数</th>
							      <th>传感器数</th>
							      <th>操作</th>
							    </tr> 
							  </thead>
							   <tbody id="tbody">
							   	<#if tmpList?exists>
							   		<#list tmpList as data>
							   			<tr>
							   				<td><a href="/base/template/${data.id}"> ${data.name}</a></td>
							   				<td>${data.testMode}</td>
							   				<td>${data.backgroundStatus}</td>
							   				<td>${data.dynStatus}</td>
							   				<td>${data.deviceNum}</td>
							   				<td>${data.sensorNum}</td>
							   				<td>
								   				<div type="submit" class="bth-tmp-edit btn btn-sm  btn-success  btn-flat"  style="float: right;" data-id="${data.id}">更新</div>
							   				</td>
							   			 </tr>
							   		</#list>
							   </#if>
							  </tbody>
				   		</table>
				   </div>
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
		$(function(){
				//新增 绑定参数
				$('.content-wrapper').on('click','.bth-bd-add',function(){
						window.location.href='/base/binding/add';
				});
				$('.content-wrapper').on('click','.bth-bd-edit',function(){
						window.location.href='/base/binding/edit?id='+$(this).attr('data-id');
				});
				$('.content-wrapper').on('click','.bth-bd-del',function(){
						if(confirm('请确定是否删除')){
							window.location.href='/base/binding/del?id='+$(this).attr('data-id');
						}
						
				});
				//新增 数据库配置参数
				$('.content-wrapper').on('click','.bth-dbcfg-add',function(){
						window.location.href='/base/db_cfg/add';
				});
				$('.content-wrapper').on('click','.bth-dbcfg-edit',function(){
						window.location.href='/base/db_cfg/edit?id='+$(this).attr('data-id');
				});
				$('.content-wrapper').on('click','.bth-dbcfg-del',function(){
					if(confirm('请确定是否删除')){
							window.location.href='/base/db_cfg/del?id='+$(this).attr('data-id');
					}
				});
				$('.content-wrapper').on('click','.bth-tmp-edit',function(){
						window.location.href='/base/template/edit/'+$(this).attr('data-id');
				});
		})
</script>
</body>
</html>