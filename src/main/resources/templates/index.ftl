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
<div class="layui-layout layui-layout-admin">
   <header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
      <span class="logo-mini"><b>T</b>S</span>
      <span class="logo-lg"><b>TSBM </b>WEB</span>
    </a>
    <nav class="navbar navbar-static-top" role="navigation">
		     
    </nav>
  </header>
    <aside class="main-sidebar">

    <section class="sidebar">

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="active" id="bashboard_li"><a href="#"><i class="fa fa-link"></i> <span>监控</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>参数配置</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#" id="binding_li">绑定参数</a></li>
            <li><a href="#" id="db_config_li">数据库参数</a></li>
            <li><a href="#" id="template_dd">测试模板参数</a></li>
          </ul>
        </li>
        <li><a href="#" id="batch"><i class="fa fa-link"></i> <span>性能测试</span></a></li>
      </ul>
    </section>
  </aside>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
   <!--  <div>
	    
    </div> -->
    <!-- <div style="padding: 15px;padding-bottom: 1px;" id="body">
    </div> -->
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
  </div>
</div>
<script src="/layui/layui.js"></script>
<script src="/js/jquery.js"></script>
<script src="/"></script>
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