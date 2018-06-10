<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ include file="/include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>����</title>
	</head>
	<body class="body_bg">
		<div class="right_bg">
			<div class="right_w">
				<div class="from_bg">
					<div class="right_v">
						<div id="main" style="height:400px"></div>
						<div class="from_btn">
		         <!--            <dhcc:button typeclass="button_form" value="����" action="����" onclick="LnBatchAction_findByPage.action"></dhcc:button>  -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<!-- ECharts���ļ����� -->
    <script type="text/javascript" src="<%=contextpath%>/creditapp/sys/js/echarts-all.js"></script>
    <script type="text/javascript">
        // ʹ��
          // ����׼���õ�dom����ʼ��echartsͼ��
          var myChart = echarts.init(document.getElementById('main'));
          
          option = {
    title: {
        text: '��������ҵ�����',
        subtext: '		��λ��%',
    },
    tooltip: {
//        trigger: 'item'
  		trigger: 'axis',
        axisPointer : {            // ������ָʾ���������ᴥ����Ч
            type : 'shadow'        // Ĭ��Ϊֱ�ߣ���ѡΪ��'line' | 'shadow'
        },
        formatter: function (params){
        	if(params[0].name=='ɸ�����'){
        	return params[0].name + '<br/> ɸ����ɱ��� : ' + params[0].series.valChk+'��';
        	}
        	if(params[0].name=='�������'){
        	return params[0].name + '<br/> ������ɱ��� : ' + params[0].series.valApp+'��';
        	}
        	if(params[0].name=='�ſ����'){
        	return params[0].name + '<br/> �ſ���ɱ��� : ' + params[0].series.valLn+'��';
        	}
            return params[0].name + '<br/>'
                   + params[0].seriesName + ' : ' + params[0].value;
        }
    },
    toolbox: {
        
    },
    calculable: true,
    grid: {
        borderWidth: 0,
        y: 80,
        y2: 60
    },
    xAxis: [
        {
        
            type: 'category',
            show: false,
            data: ['ɸ�����', '�������', '�ſ����']
        }
    ],
    yAxis: [
        {
            type: 'value',
            show: true
        }
    ],
    series: [
        {
            name: 'ECharts���Ӹ���ͳ��',
            type: 'bar',
            valChk: <s:property value="valChk"/>,
            valApp: <s:property value="valApp"/>,
            valLn: <s:property value="valLn"/>,
            barWidth : 100,//��ͼ���
            itemStyle: {
                normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top',
                        formatter: '{b}\n{c}'
                    }
                }
            },
            data: [<s:property value="query"/>],
            markPoint: {
                tooltip: {
                    trigger: 'item',
                    backgroundColor: 'rgba(0,0,0,0)',
                    formatter: function(params){
                        return '<img src="' 
                                + params.data.symbol.replace('image://', '')
                                + '"/>';
                    }
                },
                data: [
                    {xAxis:0, y: 350, name:'Line', symbolSize:20, symbol: 'image://../asset/ico/����ͼ.png'},
                    {xAxis:1, y: 350, name:'Bar', symbolSize:20, symbol: 'image://../asset/ico/��״ͼ.png'},
                    {xAxis:2, y: 350, name:'Scatter', symbolSize:20, symbol: 'image://../asset/ico/ɢ��ͼ.png'},
                    {xAxis:3, y: 350, name:'K', symbolSize:20, symbol: 'image://../asset/ico/K��ͼ.png'},
                    {xAxis:4, y: 350, name:'Pie', symbolSize:20, symbol: 'image://../asset/ico/��״ͼ.png'},
                    {xAxis:5, y: 350, name:'Radar', symbolSize:20, symbol: 'image://../asset/ico/�״�ͼ.png'},
                    {xAxis:6, y: 350, name:'Chord', symbolSize:20, symbol: 'image://../asset/ico/����ͼ.png'},
                    {xAxis:7, y: 350, name:'Force', symbolSize:20, symbol: 'image://../asset/ico/������ͼ.png'},
                    {xAxis:8, y: 350, name:'Map', symbolSize:20, symbol: 'image://../asset/ico/��ͼ.png'},
                    {xAxis:9, y: 350, name:'Gauge', symbolSize:20, symbol: 'image://../asset/ico/�Ǳ���.png'},
                    {xAxis:10, y: 350, name:'Funnel', symbolSize:20, symbol: 'image://../asset/ico/©��ͼ.png'},
                ]
            }
        }
    ]
};
          
        
                // Ϊecharts����������� 
                myChart.setOption(option); 
    </script>
</html>