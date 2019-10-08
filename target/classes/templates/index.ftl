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
  <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
</head>
<body class="layui-layout-body hold-transition skin-blue sidebar-mini">
<#include  "/common/left.ftl"/>
  <div class="layui-body content-wrapper">
    <!-- 内容主体区域 -->
   <!--  <div>
	    
    </div> -->
    <!-- <div style="padding: 15px;padding-bottom: 1px;" id="body">
    </div> -->
  </div>
<script src="/layui/layui.js"></script>
<script src="/js/jquery.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
$(function(){
	//点击控制面板
	$('.layui-layout-body').on('click','#bashboard_li',function(){
		$('#body_title').text($(this).text())
		$('#body').html('')
	});
	//点击绑定参数管理
	$('.layui-layout-body').on('click','#binding_li',function(){
		$('#body_title').text($(this).text())
		$('.layui-body').load('/base/binding/list')
	}); 
	
	//点击数据库配置
	$('.layui-layout-body').on('click','#db_config_li',function(){
		$('#body_title').text($(this).text())
		$('.layui-body').load('/base/db_cfg/list')
	});
	//点击模版管理
	$('.layui-layout-body').on('click','#template_dd',function(){
		$('#body_title').text($(this).text())
		$('.layui-body').load('/base/template/list')
	});
	//点击性能测试
	$('.layui-layout-body').on('click','#batch',function(){
		$('#body_title').text($(this).text())
		$('.layui-body').load('/base/list/batch')
	});
})

</script>
</body>
</html>