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
	   		<table class="layui-table">
	   			  <thead>
				    <tr>
				      <th>数据库名称</th>
				      <th>对应类名</th>
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
	getList();
	$('.add').on('click',function(){
		var layer = layui.layer;
		  layer.open({
			  type:2,
			  title:'新增',
			  area:['500px','300px'],
			  content:'/pages/binding/add.html',
			  yes: function(index, layero){
				    //do something
				    layer.closeAll();
			}
		  })
	})
	$('.layui-layout-body').on('click','.remove',function(){
		var dataId=$(this).attr('data-id')
		$.ajax({
			url:'/base/remove/binding',
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
		url:'/base/list/binding',
		dataType:'json',
		success:function(res){
			var data = res.data
			$(data).each(function(){
				var dbId=this.id
				var dbName=this.dbName
				var dbClass=this.dbClass
				var tr='<tr><td data-id="'+dbId+'">'+dbName+'</td><td>'+dbClass+'</td><td><button class="layui-btn layui-btn-sm remove"  data-id="'+dbId+'">删除</button></td></tr>'
				$('#tbody').append(tr)
			})
		}
	});
}
</script>
</body>
</html>