<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>tsbm - web</title>
  <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body class="layui-layout-body">
  <div style="padding: 15px;padding-bottom: 1px;" id="body">
   	 	<button class="layui-btn add">新增</button>
	   <div>
	   		<table class="layui-table" >
	   			  <thead>
				    <tr>
				      <th>批次名称</th>
				      <th>数据库配置</th>
				      <th>模版</th>
				      <th>进度</th>
				    </tr> 
				  </thead>
				   <tbody id="tbody">
				   	<#if list?exists>
				   		<#list list as data>
				   			<tr><td>${data.name}</td><td>${data.cfgId}</td><td>${data.templateId}</td>
				   			<td>
				   				<div class="layui-progress layui-progress-big" lay-showpercent="false">
 								 	<div class="layui-progress-bar" lay-percent="80%"></div>	
								</div>
				   			</td> </tr>
				   		</#list>
				   </#if>
				  </tbody>
	   		</table>
	   </div>
    </div>
<script src="/js/jquery.js"></script>
<script src="/layer/layer.js"></script>
<script>
layui.use('element', function(){
  var element = layui.element;
  element.init();	
});
//JavaScript代码区域
$(function(){
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