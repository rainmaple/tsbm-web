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
    <link rel="stylesheet" href="/bower_components/select2/dist/css/select2.min.css">
</head>
<body class="skin-blue">
<#include  "/common/left.ftl"/>
  <div class="layui-body content-wrapper">
    <!-- 内容主体区域 -->
   <!--  <div>
	    
    </div> -->
    <!-- <div style="padding: 15px;padding-bottom: 1px;" id="body">
    </div> -->
	<section></section>
	<section class="content content-wrapper">
		<div class="row">
		<div class="col-xs-12" >
			  <div class="box" id="body">
			  	   <div class="box-header">
			           <h3 class="box-title">选择数据库进行性能测试</h3>
			       </div>
				   <div class="box-body  no-padding col-xs-6">
				  	 <div class="input-group input-group-sm">
		                  <select class="form-control">
		                		<#if dblist?exists>
							   		<#list dblist as data>
							   			<option value="${data.id}">${data.name}</option>
							   		</#list>
							   	</#if>
		                  </select>
		                  <select class="form-control select2 select2-hidden-accessible" multiple="" data-placeholder="Select Templates" style="width: 100%;" tabindex="-1" aria-hidden="true">
		                		<#if tmplist?exists>
							   		<#list tmplist as data>
							   			<option value="${data.id}">${data.name}</option>
							   		</#list>
							   	</#if>
			                </select>
		                    <span class="input-group-btn">
		                      <button type="button" id="test_button" class="btn btn-info btn-flat">Go Test!</button>
		                    </span>
		              </div>
				   </div>
				   	<div class="col-xs-6"></div>	
			    </div>
		</div>
		</div>
		<div class="row">
		<div class="col-xs-12" >
			  <div class="box" id="body">
			  	   <div class="box-header">
			           <h3 class="box-title">测试进度</h3>
			       </div>
				   <div class="box-body table-responsive no-padding">
				   		<table class="table table-hover" >
				   			  <thead>
							    <tr>
							      <th>批次名称</th>
							      <th>数据库</th>
							      <th>模版</th>
							      <th>进度</th>
							    </tr> 
							  </thead>
							   <tbody id="tbody">
							   	<#if list?exists>
							   		<#list list as data>
							   			<tr><td>${data.name}</td><td>${data.cfgName}</td><td>${data.templateName}</td>
							   			<td>
											<div class="progress progress-xs progress-striped active col-xs-10">
			                    			  <div class="progress-bar progress-bar-primary" style="width: ${data.progress!}"></div>
			                   				 </div><a>${data.progress!}</a>
							   			</td> </tr>
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
<script src="/bower_components/select2/dist/js/select2.full.min.js"></script>
<script>
//JavaScript代码区域
$(function(){
	$('.select2').select2()
	$('.add').on('click',function(){
		var layer = layui.layer;
		  layer.open({
			  type:2,
			  title:'新增',
			  area:['960px','640px'],
			  content:'/base/batch/to_add',
			  yes: function(index, layero){
				    //do something
				    layer.closeAll();
			}
		  })
	})
	$('.layui-layout-body').on('click','.remove',function(){
		var dataId=$(this).attr('data-id')
		$.ajax({
			url:'/base/remove/batch',
			data:{id:dataId},
			type:'post',
			async:false,
			success:function(res){
				getList();
			}
		})
		return false
	});
	$('.layui-layout-body').on('click','.cls_start',function(){
		var dataId=$(this).attr('data-id')
		$.ajax({
			url:'/base/batch/start',
			data:{id:dataId},
			type:'post',
			async:false,
			success:function(res){
			}
		})
		return false
	});
	$('.layui-layout-body').on('click','.cls_end',function(){
		var dataId=$(this).attr('data-id')
		$.ajax({
			url:'/base/batch/end',
			data:{id:dataId},
			type:'post',
			async:false,
			success:function(res){
			}
		})
		return false
	});
    $('.layui-layout-body').on('click','.cls_view_progress',function(){
		var dataId=$(this).attr('data-id')
		$('.layui-body').load('/base/batch/view?id='+dataId)
	});
});
</script>
</body>
</html>