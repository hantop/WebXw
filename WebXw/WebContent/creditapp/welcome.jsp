<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="../include/tld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>��ӭʹ��</title>
<script language="javascript" type="text/javascript">
//scrollBodyId:	String �ڲ�����div��id
//scrollBoxId:	String ��������div��id
//showHeight:	Int ������ʾ�߶�
//showWidth:	Int ������ʾ���
//lineHeight:	Int ÿ�еĸ߶�
//stopTime:		Int ���ֹͣ��ʱ�䣨���룩
//speed:		Int �����ٶȣ����룬ԽСԽ�죩
var ScrollObj = function(scrollBodyId,scrollBoxId,showHeight,showWidth,lineHeight,stopTime,speed) {
	this.obj = document.getElementById(scrollBodyId);
	this.box = document.getElementById(scrollBoxId);
	
	this.style = this.obj.style;
	this.defaultHeight = this.obj.offsetHeight;
	
	this.obj.innerHTML += this.obj.innerHTML;
	this.obj.style.position = "relative";
	
	this.box.style.height = showHeight;
	this.box.style.width = showWidth;
	this.box.style.overflow = "hidden";
	
	this.scrollUp = doScrollUp;

	this.stopScroll = false;
	
	this.curLineHeight = 0;
	this.lineHeight = lineHeight;
	this.curStopTime = 0;
	this.stopTime = stopTime;
	this.speed = speed;

	this.style.top = lineHeight;

	this.object = scrollBodyId + "Object";
	eval(this.object + "=this");
	setInterval(this.object+".scrollUp()",speed);
	this.obj.onmouseover=new Function(this.object+".stopScroll=true");
	this.obj.onmouseout=new Function(this.object+".stopScroll=false");
}
function doScrollUp(){
	if( this.stopScroll == true )
		return;
  	this.curLineHeight += 1;
  	if( this.curLineHeight >= this.lineHeight ){
  		this.curStopTime += 1;
  		if( this.curStopTime >= this.stopTime ){
  			this.curLineHeight = 0;
  			this.curStopTime = 0;
  		}
  	}
	else{  	
	  	this.style.top = parseInt(this.style.top) - 1;
	  	if( -parseInt(this.style.top) >= this.defaultHeight ){
	    	this.style.top = 0;
	  	}
  	}
}
</script>
<STYLE type=text/css>
#scroollBody a {
width:100%;
overflow:hidden;
font:12px/16px tahoma;
display:block;
text-decoration:none;
margin:2px;
color:#4a551c;
padding-left:2px;
text-align:left;
}
#scroollBody a:hover {
color:#ff6600;
}
</STYLE>

</head>
<body class="body_bg">
<div class="right_bg" style="height:100%;">
	<div class="right_w" style="height:100%;">
		<div class="from_bg" style="height:100%;">
			<div class="right_v" style="height:100%;padding: 0px;">

<%--<div id="scroollBox" style="border:1px solid blue; float: right; margin-top: 2px; height: 40px;">
<div id="scroollBody">
<p><a href="#">1����[����������޹�˾]��δ����</a></p><br/>
<p><a href="#">2����[Oracle��˾]�����ʽ����</a></p><br/>>
<p><a href="#">5���������µ���Ϣ,��ע�����!</a></p><br/>
<p><a href="#">6����������2012��08��17�գ�����һ</a></p><br/>
</div>
</div>--%>
<script language="javascript" type="text/javascript">

//scrollBodyId:	String �ڲ�����div��id
//scrollBoxId:	String ��������div��id
//showHeight:	Int ������ʾ�߶�
//showWidth:	Int ������ʾ���
//lineHeight:	Int ÿ�еĸ߶�
//stopTime:		Int ���ֹͣ��ʱ�䣨���룩
//speed:		Int �����ٶȣ����룬ԽСԽ�죩


	//var sample = new ScrollObj("scroollBody","scroollBox",100,300,50,0,100);
</script>

	<div align="center" width="100%" height="100%" style="vertical-align: middle;padding-top:10%; border: 2px red;">
	<img src="<%=request.getContextPath() %>/creditapp/images/myworkspace.png " />
	</div>

</div>
</div>
</div>
</div>
</body>
</html>
