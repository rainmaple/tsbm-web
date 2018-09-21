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
			      	  <div class="box-body  no-padding col-xs-6">
					  	 <div class="input-group input-group-sm">
			                  <select name="cfgIds" id="cfg_ids" class="form-control select2 select2-hidden-accessible" multiple="" data-placeholder="Select Templates" style="width: 100%;" tabindex="-1" aria-hidden="true">
			                		<#if dblist?exists>
								   		<#list dblist as data>
								   			<option value="${data.id}">${data.name}</option>
								   		</#list>
								   	</#if>
				                </select>
			                    <span class="input-group-btn">
			                      <button type="button" id="test_button" class="btn btn-info btn-flat">Go To Compare!</button>
			                    </span>
			              </div>
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
			      	   		<div class="col-xs-12">
			      	   			<table class="table table-hover" >
								   			  <thead>
											    <tr>
											      <th>数据库名称</th>
											      <th>pps</th>
											      <th>sum</th>
											      <th>costTime</th>
											      <th>success_ratio</th>
											    </tr> 
											  </thead>
											   <tbody id="import_tbody">
											   			<tr>
											   			<td>iotdb</td><td>10000</td><td>1000010000</td><td>3</td><td>4</td>
											   			 </tr>
											   			 <tr>
											   			 	<td>influxdb</td><td>132132</td><td>132132132132</td><td>4</td><td>5</td>
											   			 </tr>
											  </tbody>
								   		</table>
			      	   			
			      	   		</div>
			      	   		<div class="col-xs-12" id="import_line_chart" style="min-height: 306px;min-width: 1200px;">
			      	   			<!-- 折线图 -->
			      	   				
			      	   		</div>
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
							   <tbody id="append_tbody">
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
									<div class="chart col-xs-12" id="append_charts" style="min-height: 306px;min-width: 450px;">
						                <!--<canvas id="appendChart" style="height: 245px; width: 626px;" width="782" height="306"></canvas>-->
						       </div>
							</div>
							<div class="col-xs-12" id="append_line_chart" style="min-height: 306px;min-width: 950px;">
			      	   			<!-- 折线图 -->
			      	   				
			      	   		</div>
			      	   </div>
			      	<div>
			      		
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
			      	   <div class="box-body" >
			      	   		<div class="col-xs-4" >
			      	   				<div id="read_charts" class="col-xs-12" style="min-height: 306px;min-width: 450px;">
			      	   					
			      	   				</div>
			      	   			
			      	   		</div>
			      	   		<div class="col-xs-8">
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
											   <tbody id="read_tbody">
											   			<tr>
											   			<td>iotdb</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>5</td><td>5</td><td>5</td>
											   			 </tr>
											   			 <tr>
											   			 	<td>influxdb</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td>
											   			 </tr>
											  </tbody>
								   		</table>
			      	   			
			      	   		</div>
							<div class="col-xs-12" id="read_line_chart" style="min-height: 306px;min-width: 950px;">
			      	   			<!-- 折线图 -->
			      	   				
			      	   		</div>
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
			      	   		<div class="col-xs-8">
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
											   <tbody id="mappend_tbody">
											   			<tr>
											   			<td>iotdb</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>5</td><td>5</td><td>5</td>
											   			 </tr>
											   			 <tr>
											   			 	<td>influxdb</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td>
											   			 </tr>
											  </tbody>
								   		</table>
			      	   			
			      	   		</div>
			      	   		<div class="col-xs-4" >
			      	   				<div id="mul_append_charts" class="col-xs-12" style="min-height: 306px;min-width: 450px;">
			      	   					
			      	   				</div>
			      	   			
			      	   		</div>
			      	   		<div class="col-xs-12" id="mul_append_line_chart" style="min-height: 306px;min-width: 950px;">
			      	   			<!-- 折线图 -->
			      	   				
			      	   		</div>
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
			      	   		<div class="col-xs-4" >
			      	   				<div id="mul_read_charts" class="col-xs-12" style="min-height: 306px;min-width: 450px;">
			      	   					
			      	   				</div>
			      	   			
			      	   		</div>
			      	   		<div class="col-xs-8">
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
											   <tbody id="mread_tbody">
											   			<tr>
											   			<td>iotdb</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>5</td><td>5</td><td>5</td>
											   			 </tr>
											   			 <tr>
											   			 	<td>influxdb</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td><td>8</td><td>9</td>
											   			 </tr>
											  </tbody>
								   		</table>
			      	   			
			      	   		</div>
			      	   		<div class="col-xs-12" id="mul_read_line_chart" style="min-height: 306px;min-width: 950px;">
			      	   			<!-- 折线图 -->
			      	   				
			      	   		</div>
			      	   </div>
				 </div>
			</div>
		</div>
	</section>
  </div>
<script src="/layui/layui.js"></script>
<script src="/js/jquery.js"></script>
<script src="/js/echarts.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>
<script src="/bower_components/chart.js/Chart.js"></script>
<script src="/bower_components/select2/dist/js/select2.full.min.js"></script>
<script src="/js/chart_option.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
$(function(){
	$('.select2').select2()
	$(".layui-body").on('click','#test_button',function(){
			var cfgIds=$('#cfg_ids').val();
			$.ajax({
				type:"post",
				url:"/stat/get",
				data:{cfgIds:cfgIds},
				async:true,
				success:function(data){
					console.log(data)
					// init import
					if(data.importData){
						initImportTable(data.importData.bar,'#import_tbody');
						initBLine(data.importData.line,'import_line_chart');
					}
					if(data.appendData){
							initRWTable(data.importData.bar,'#append_tbody');
							initBar(data.importData.bar,'#append_charts');
							initBLine(data.importData.line,'#append_line_chart');
					}
					if(data.readData){
							initRWTable(data.importData.bar,'#read_tbody');
							initBar(data.importData.bar,'#read_charts');
							initBLine(data.importData.line,'#read_line_chart');
					}
					if(data.mulAppendData){
							initRWTable(data.importData.bar,'#mappend_tbody');
							initBar(data.importData.bar,'#mul_append_charts');
							initBLine(data.importData.line,'#mul_append_line_chart');						
					}
					if(data.mulReadData){
							initRWTable(data.importData.bar,'#mread_tbody');
							initBar(data.importData.bar,'#mul_read_charts');
							initBLine(data.importData.line,'#mul_read_line_chart');						
					}
				}
			});
	})
	function initImportTable(data,id){
		$(id).html('');
		$(data).each(function(){
				var tr='<tr><td>'+this.cfgName+'</td>'+
							'<td>'+this.pps+'</td>'+
							'<td>'+this.sum+'</td>'+
							'<td>'+this.costTime+'</td>'+
							'<td>'+this.successRatio+'</td></tr>';
				$(id).append(tr);
		})
	}
	function initRWTable(data,id){
		$(id).html('');
		$(data).each(function(){
				var tr='<tr><td>'+this.cfgName+'</td>'+
							'<td>'+this.pps+'</td>'+
							'<td>'+this.clients+'</td>'+
							'<td>'+this.sum+'</td>'+
							'<td>'+this.maxTimeout+'</td>'+
							'<td>'+this.minTimeout+'</td>'+
							'<td>'+this.meanTimeout+'</td>'+
							'<td>'+this.th50Timeout+'</td>'+
							'<td>'+this.th95Timeout+'</td></tr>';
				$(id).append(tr);
		})
	}
	function initBar(data,id){
		var legend_datas=new Array()
		var opt_series=new Array()
		$(data).each(function(){
			  legend_datas.push(this.cfgName);
			  var obj={};
			  obj.name=this.cfgName;
			  obj.type='bar',
			  obj.data=[Math.log(this.meanTimeout)/Math.log(10),
			  Math.log(this.minTimeout)/Math.log(10),
			  Math.log(this.maxTimeout)/Math.log(10),
			  Math.log(this.th50Timeout)/Math.log(10),
			  Math.log(this.th95Timeout)/Math.log(10)]
			  opt_series.push(obj);
		})
		barChart_option.legend.data=legend_datas;
		barChart_option.series=opt_series;
		var dom = document.getElementById(id);
		var dom_chart = echarts.init(dom);
		var option=barChart_option
		dom_chart.setOption(option, true);
	}
	function initBLine(data,id){
		var legend_datas=new Array()
		var opt_series=new Array()
		var x_Axis_data=new Array()
		$(data).each(function(){
			 	legend_datas.push(this.cfgName);
			 	var obj={};
			  obj.name=this.cfgName;
			  obj.type='line',
			  obj.data=this.values;
			  opt_series.push(obj);
			  x_Axis_data=this.keys
		});
		lineChart_option.legend.data=legend_datas;
		lineChart_option.series=opt_series;
		lineChart_option.xAxis.data=x_Axis_data;
		var option=lineChart_option
		var dom = document.getElementById(id);
		var dom_chart = echarts.init(dom);
		dom_chart.setOption(option, true);
	}
	var data=[{'cfgName':'influxdb','meanTimeout':1,'minTimeout':2,'maxTimeout':4,'th50Timeout':5,'th95Timeout':3},
	{'cfgName':'iotdb','meanTimeout':2,'minTimeout':1,'maxTimeout':3,'th50Timeout':25,'th95Timeout':23}];
	initBar(data,'read_charts');
	var data_line=[{'cfgName':'influxdb','values':[1,2,3,4,5,6],'keys':[1,3,5,10,30,50]},
	{'cfgName':'iotdb','values':[3,2,1,6,3,2],'keys':[1,3,5,10,30,50]}];
	var import_data_line=[{'cfgName':'influxdb','values':[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15],'keys':[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]},
		{'cfgName':'iotdb','values':[1,3,5,10,30,50,1,3,5,10,30,50,1,3,5,10,30,50],'keys':[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]}];
	initBLine(import_data_line,'import_line_chart')
	initBLine(data_line,'append_line_chart')
	initBLine(data_line,'read_line_chart')
	initBLine(data_line,'mul_append_line_chart')
	initBLine(data_line,'mul_read_line_chart')
})
var dom_read = document.getElementById("read_charts");
var dom_append = document.getElementById("append_charts");
var dom_mul_read = document.getElementById("mul_read_charts");
var dom_mul_append = document.getElementById("mul_append_charts");
var mul_read_chart = echarts.init(dom_mul_read);
var mul_append_chart = echarts.init(dom_mul_append);
var read_chart = echarts.init(dom_read);
var append_chart = echarts.init(dom_append);
var app = {};
option = null;

option = {
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        data: ['Iotdb', 'Influxdb']
    },

    calculable: true,
    xAxis: [
        {
            type: 'category',
            axisTick: {show: false},
            data: ['avg', 'min', 'max', '50th', '95th']
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name: 'Iotdb',
            type: 'bar',
            data: [150, 232, 201, 154, 190]
        },
        {
            name: 'Influxdb',
            type: 'bar',
            data: [98, 77, 101, 99, 40]
        }
    ]
};


if (option && typeof option === "object") {
	  append_chart.setOption(option, true);
    read_chart.setOption(option, true);
    mul_read_chart.setOption(option, true);
    mul_append_chart.setOption(option, true);
}
//  var areaChartData = {
//    labels  : ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
//    datasets: [
//      {
//        label               : 'Electronics',
//        fillColor           : 'rgba(210, 214, 222, 1)',
//        strokeColor         : 'rgba(210, 214, 222, 1)',
//        pointColor          : 'rgba(210, 214, 222, 1)',
//        pointStrokeColor    : '#c1c7d1',
//        pointHighlightFill  : '#fff',
//        pointHighlightStroke: 'rgba(220,220,220,1)',
//        data                : [65, 59, 80, 81, 56, 55, 40]
//      },
//      {
//        label               : 'Digital Goods',
//        fillColor           : 'rgba(60,141,188,0.9)',
//        strokeColor         : 'rgba(60,141,188,0.8)',
//        pointColor          : '#3b8bba',
//        pointStrokeColor    : 'rgba(60,141,188,1)',
//        pointHighlightFill  : '#fff',
//        pointHighlightStroke: 'rgba(60,141,188,1)',
//        data                : [28, 48, 40, 19, 86, 27, 90]
//      }
//    ]
//  }
//  var barChartCanvas                   = $('#appendChart').get(0).getContext('2d')
//  var barChart                         = new Chart(barChartCanvas)
//  var barChartData                     = areaChartData
//  barChartData.datasets[1].fillColor   = '#00a65a'
//  barChartData.datasets[1].strokeColor = '#00a65a'
//  barChartData.datasets[1].pointColor  = '#00a65a'
//  var barChartOptions                  = {
//    //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
//    scaleBeginAtZero        : true,
//    //Boolean - Whether grid lines are shown across the chart
//    scaleShowGridLines      : true,
//    //String - Colour of the grid lines
//    scaleGridLineColor      : 'rgba(0,0,0,.05)',
//    //Number - Width of the grid lines
//    scaleGridLineWidth      : 1,
//    //Boolean - Whether to show horizontal lines (except X axis)
//    scaleShowHorizontalLines: true,
//    //Boolean - Whether to show vertical lines (except Y axis)
//    scaleShowVerticalLines  : true,
//    //Boolean - If there is a stroke on each bar
//    barShowStroke           : true,
//    //Number - Pixel width of the bar stroke
//    barStrokeWidth          : 2,
//    //Number - Spacing between each of the X value sets
//    barValueSpacing         : 5,
//    //Number - Spacing between data sets within X values
//    barDatasetSpacing       : 1,
//    //String - A legend template
//    legendTemplate          : '<ul class="<%=name.toLowerCase()%>-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].fillColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>',
//    //Boolean - whether to make the chart responsive
//    responsive              : true,
//    maintainAspectRatio     : true
//  }
//
//  barChartOptions.datasetFill = false
//  barChart.Bar(barChartData, barChartOptions)
</script>
</body>
</html>