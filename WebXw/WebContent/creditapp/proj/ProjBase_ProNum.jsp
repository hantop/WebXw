<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String contextpath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
	</head>
	
	<body class="body_bg">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div id="main" style="height:400px"></div>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript" src="<%=contextpath%>/themes/js/jquery-1.8.0.min.js"></script>
	<!-- ECharts单文件引入 -->
    <script type="text/javascript" src="<%=contextpath%>/creditapp/sys/js/echarts-all.js" charset="utf-8"></script>
    <script type="text/javascript">
   $(document).ready(function(){
    var flags = [<s:property value="rptParams.data1" />];
    var myChart = echarts.init(document.getElementById('main'));
    if (flags.length <= 0) {
        myChart.showLoading({
            text: '无数据', //loading话术
            effect : 'bubble'
        });
        return;
    }
        option = {
    title : {
        text: '资产笔数',
        subtext: '单位：笔'
    },
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data:['资产笔数']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {show: true, type: ['line', 'bar']},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : [<s:property value="rptParams.data1" />]
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    series : [
        {
            name:'资产笔数',
            type:'bar',
            barWidth : 40,//柱图宽度
            data:[<s:property value="rptParams.data2" />],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }
    ]
};
                                
        myChart.setOption(option); });
    </script>
	</body>
</html>