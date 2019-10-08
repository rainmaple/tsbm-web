var barChart_option={
	tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        },
        formatter: '10<sup>{c0}</sup> ms'
    },
    legend: {
        data: []
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
    series: []
	};
var lineChart_option={
	tooltip: {
        trigger: 'axis',
        //在这里设置
        formatter: '{c0} points or requests/s'
    },
    legend: {
        data:[]
    },
    xAxis: {
        type: 'category',
        data: []// 
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        name:'邮件营销',
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line',
        smooth: true
    },{
        name:'联盟广告',
        data: [820, 932, 901, 934, 1290, 1330, 131],
        type: 'line',
        smooth: true
    }]
}
// 对象的复制  不好用！！！！！
function copy(obj1){
  var obj2={}; //最初的时候给它一个初始值=它自己或者是一个json
  for(var name in obj1){
    if(typeof obj1[name] === "object"){ //先判断一下obj[name]是不是一个对象
      obj2[name]= (obj1[name].constructor===Array)?[]:{}; //我们让要复制的对象的name项=数组或者是json
      copy(obj1[name],obj2[name]); //然后来无限调用函数自己 递归思想
    }else{
      obj2[name]=obj1[name];  //如果不是对象，直接等于即可，不会发生引用。
    }
  }
  return obj2; //然后在把复制好的对象给return出去
}
