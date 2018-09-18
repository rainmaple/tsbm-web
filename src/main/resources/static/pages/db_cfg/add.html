<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>tsbm - web</title>
  <link rel="stylesheet" href="../../layui/css/layui.css">
</head>
<body class="layui-layout-body">
  <div style="padding: 15px;padding-bottom: 1px;" id="body">
    <form class="layui-form" action="#">
    		  <div class="layui-form-item">
		    <label class="layui-form-label">配置名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" id="name"  autocomplete="off" class="layui-input">
		    </div>
		    </div>
    		  <div class="layui-form-item">
		    <label class="layui-form-label">数据库名称</label>
		     <div class="layui-input-block">
		      <select name="bindingId"  class="layui-input" id="bindingId" >
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">ip</label>
		    <div class="layui-input-block">
		      <input type="text" name="ip" id="ip"  autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">port</label>
		    <div class="layui-input-block">
		      <input type="text" name="port" id="port"  autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">username</label>
		    <div class="layui-input-block">
		      <input type="text" name="username" id="username"  autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">password</label>
		    <div class="layui-input-block">
		      <input type="text" name="passwd" id="passwd"  autocomplete="off" class="layui-input">
		    </div>
		  </div>
		    <div class="layui-form-item">
			    <div class="layui-input-block">
			      <button id="save" class="layui-btn" type="button" >立即提交</button>
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    </div>
			  </div>
    </form>
    </div>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="../../../layer/layer.js"></script>
<script src="../../../layui/layui.js"></script>
<script>
//JavaScript代码区域
	//初始化option
	$.ajax({
		url:'/base/list/binding',
		dataType:'json',
		type:'post',
		dataType:'json',
		success:function(res){
			var data=res.data;
			$('#bindingId').html('');
/* 			 option='<option value="">--请选择--</option>'
 */			/* $('#bindingId').append(option) */
			$(data).each(function(){
				var b_id=this.id;
				var bName=this.dbName
				var option='<option value="'+b_id+'">'+bName+'</option>';
				$('#bindingId').append(option)
			});
		}
	})
$(function(){
	layui.use('form', function(){
		  var form = layui.form;
		  //各种基于事件的操作，下面会有进一步介绍
		});
	$('.layui-layout-body').on('click','#save',function(){
		var name = $('#name').val()
		var bindingId=$('#bindingId').val()
		var dbIp=$('#ip').val()
		var dbUser= $('#username').val()
		var dbPasswd=$('#passwd').val()
		var dbPort =$('#port').val()
		$.ajax({
			url:'/base/add/db_cfg',
			type:'post',
			data:{name:name,bindingId:bindingId,dbIp:dbIp,dbUser:dbUser,dbPasswd:dbPasswd,dbPort:dbPort},
			dataType:'json',
			success:function(res){
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	})
});
</script>
</body>
</html>