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
 	<section class="content-header">
		<h1>
        性能分析
        <small>配置选项进行性能分析</small>
      </h1>
	</section> 		
	<section class="content content-wrapper">
		<div class="row">
			<div class="col-xs-12" >
				 <div class="box" id="body">
				 		<div class="box-header">
			          		 <h3 class="box-title">配置选择</h3>
			      	   </div>
			      	   <div class="box-body">
			      	   </div>
				 </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12" >
				 <div class="box" id="body">
				 		<div class="box-header">
			          		 <h3 class="box-title">import分析</h3>
			      	   </div>
			      	   <div class="box-body">
			      	   </div>
				 </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12" >
				 <div class="box" id="body">
				 		<div class="box-header">
			          		 <h3 class="box-title">Append分析</h3>
			      	   </div>
			      	   <div class="box-body">
			      	   		<div class="col-xs-8">
			      	   		<!--表格  行 数据库，列:指标-->
			      	   		<table class="table table-hover" >
				   			  <thead>
							    <tr>
							      <th>数据库名称</th>
							      <th>pps</th>
							      <th>clients</th>
							      <th>sum</th>
							      <th>max_timeout</th>
							      <th>min_timeout</th>
							      <th>avg_timeout</th>
							      <th>th50_timeout</th>
							      <th>th95_timeout</th>
							    </tr> 
							  </thead>
							   <tbody id="tbody">
							   			<tr>
							   			<td>iotdb</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>5</td><td>5</td><td>5</td>
							   			 </tr>
							   			 <tr>
							   			 	<td>influxdb</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td>
							   			 </tr>
							  </tbody>
				   		</table>
							</div>
							<div class="col-xs-4">
							<!--chart-->
							<div class="chart">
				                <canvas id="appendChart" style="height: 245px; width: 626px;" width="782" height="306"></canvas>
				              </div>
							</div>
			      	   </div>
				 </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12" >
				 <div class="box" id="body">
				 		<div class="box-header">
			          		 <h3 class="box-title">Read分析</h3>
			      	   </div>
			      	   <div class="box-body">
			      	   </div>
				 </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12" >
				 <div class="box" id="body">
				 		<div class="box-header">
			          		 <h3 class="box-title">Mul-Append分析</h3>
			      	   </div>
			      	   <div class="box-body">
			      	   </div>
				 </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12" >
				 <div class="box" id="body">
				 		<div class="box-header">
			          		 <h3 class="box-title">Mul-Read分析</h3>
			      	   </div>
			      	   <div class="box-body">
			      	   		<div class="col-xs-8">a</div><div class="col-xs-4">b </div>
			      	   </div>
				 </div>
			</div>
		</div>
	</section>
  </div>
<script src="/layui/layui.js"></script>
<script src="/js/jquery.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<script src="/bower_components/chart.js/Chart.js"></script>
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
    var areaChartData = {
      labels  : ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
        {
          label               : 'Electronics',
          fillColor           : 'rgba(210, 214, 222, 1)',
          strokeColor         : 'rgba(210, 214, 222, 1)',
          pointColor          : 'rgba(210, 214, 222, 1)',
          pointStrokeColor    : '#c1c7d1',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(220,220,220,1)',
          data                : [65, 59, 80, 81, 56, 55, 40]
        },
        {
          label               : 'Digital Goods',
          fillColor           : 'rgba(60,141,188,0.9)',
          strokeColor         : 'rgba(60,141,188,0.8)',
          pointColor          : '#3b8bba',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [28, 48, 40, 19, 86, 27, 90]
        }
      ]
    }
    var barChartCanvas                   = $('#appendChart').get(0).getContext('2d')
    var barChart                         = new Chart(barChartCanvas)
    var barChartData                     = areaChartData
    barChartData.datasets[1].fillColor   = '#00a65a'
    barChartData.datasets[1].strokeColor = '#00a65a'
    barChartData.datasets[1].pointColor  = '#00a65a'
    var barChartOptions                  = {
      //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
      scaleBeginAtZero        : true,
      //Boolean - Whether grid lines are shown across the chart
      scaleShowGridLines      : true,
      //String - Colour of the grid lines
      scaleGridLineColor      : 'rgba(0,0,0,.05)',
      //Number - Width of the grid lines
      scaleGridLineWidth      : 1,
      //Boolean - Whether to show horizontal lines (except X axis)
      scaleShowHorizontalLines: true,
      //Boolean - Whether to show vertical lines (except Y axis)
      scaleShowVerticalLines  : true,
      //Boolean - If there is a stroke on each bar
      barShowStroke           : true,
      //Number - Pixel width of the bar stroke
      barStrokeWidth          : 2,
      //Number - Spacing between each of the X value sets
      barValueSpacing         : 5,
      //Number - Spacing between data sets within X values
      barDatasetSpacing       : 1,
      //String - A legend template
      legendTemplate          : '<ul class="<%=name.toLowerCase()%>-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].fillColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>',
      //Boolean - whether to make the chart responsive
      responsive              : true,
      maintainAspectRatio     : true
    }

    barChartOptions.datasetFill = false
    barChart.Bar(barChartData, barChartOptions)
</script>
</body>
</html>