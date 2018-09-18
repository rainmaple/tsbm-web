<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>tsbm - web</title>
  <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body class="layui-layout-body">
  <div style="padding: 15px;padding-bottom: 1px;" id="body">
   	 	<!-- <button class="layui-btn add">新增</button> -->
	   <div>
	   		<table class="layui-table">
	   			  <thead>
				    <tr>
				      <th>模板名称</th>
				      <th>测试模式</th>
				      <th>负载均衡</th>
				      <th>是否动态及参数</th>
				      <th>写</th>
				      <th>读</th>
				      <th>操作</th>
				    </tr> 
				  </thead>
				   <tbody id="tbody">
				  </tbody>
	   		</table>
	   </div>
    </div>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="/layer/layer.js"></script>
<script>
//JavaScript代码区域
$(function(){
	getList()
	$('.add').on('click',function(){
		var layer = layui.layer;
		  layer.open({
			  type:2,
			  title:'新增',
			  area:['800px','600px'],
			  content:'/pages/template/add.html',
			  yes: function(index, layero){
				    //do something
				    layer.closeAll();
			}
		  })
	})
	$('.layui-layout-body').on('click','.remove',function(){
		var dataId=$(this).attr('data-id')
		$.ajax({
			url:'/base/remove/template',
			data:{id:dataId},
			type:'post',
			async:false,
			success:function(res){
				getList();
			}
		})
		return false
	});
});
function getList(){
	$('#tbody').html('');
	$.ajax({
		url:'/base/list/template',
		dataType:'json',
		success:function(res){
			var data = res.data
			$(data).each(function(){
				var cfgId=this.id
				var name=this.name
				var testMode=this.testMode
				var dbName=this.dbName
				var dbIp=this.dbIp;
				var dbPort=this.dbPort
				var dbUser=this.dbUser
				var dbPasswd=this.dbPasswd
				var tr='<tr><td data-id="'+cfgId+'">'+name+'</td><td>'+
				dbName+'</td><td>'+
				dbIp+'</td><td>'+
				dbPort+'</td><td>'+
				dbUser+'</td><td>'+
				dbPasswd+'</td><td><button data-id="'+cfgId+'" class="layui-btn layui-btn-sm remove" >删除</buttion></td><tr>'
				$('#tbody').append(tr)
			})
		}
	});
	return false
}
</script>
</body>
</html>