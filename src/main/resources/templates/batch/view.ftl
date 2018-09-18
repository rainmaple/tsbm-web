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
    <form class="layui-form" action="#">
    		  <div class="layui-form-item">
		    <label class="layui-form-label">批次名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" id="name"  autocomplete="off" class="layui-input">
		    </div>
		    </div>
    		  <div class="layui-form-item">
		    <label class="layui-form-label">数据库配置</label>
		     <div class="layui-input-block">
		      <select name="dbCfgId"  class="" id="dbCfgId" >
		      		<#list cfgs as cfg>
		    			<option value="${cfg.id!}">${cfg.name!}</option>
		    		</#list>
		      </select>
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">模板选择${tmp!}</label>
		    <div class="layui-input-block ">
		    		<select name="templateId"  class="template-id"  id="template-id">
		    			<#list tmps as cfg>
		    			<option value="${cfg.id!}">${cfg.name!}</option>
		    		</#list>
		    		</select>
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
<script src="/layer/layer.js"></script>
<script src="/layui/layui.js"></script>
<script>
//JavaScript代码区域
$(function(){
	layui.use('form', function(){
		  var form = layui.form;
		  //各种基于事件的操作，下面会有进一步介绍
		});
	$('.layui-layout-body').on('click','#save',function(){
		var name = $('#name').val()
		var templateId=$('#template-id').val()
		var dbCfgId=$('#dbCfgId').val()
		$.ajax({
			url:'/base/add/batch',
			type:'post',
			data:{name:name,templateId:templateId,cfgId:dbCfgId},
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