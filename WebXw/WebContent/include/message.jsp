
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<script language="JavaScript">
var cssPath = "<%=session.getAttribute("color")%>"; //��ȡĬ��Ƥ��·��
var msgDialogColor = "#faa932";
var msgBgColor = "#dfe4ea";
 if(cssPath=="blue") {
	 msgDialogColor = "#fcc97f";
	 msgBgColor = "#fcc97f";
 }else if(cssPath=="purple") {
	 msgDialogColor = "#970086";
	 msgBgColor = "#ebdee9";
 }else if(cssPath=="green") {
	 msgDialogColor = "#0f8d00";
	 msgBgColor = "#dfebde";
 }else if(cssPath=="red") {
	 msgDialogColor = "#b60045";
	 msgBgColor = "#ebdee3";
 }else if(cssPath=="cyan") {
	 msgDialogColor = "#008282";
	 msgBgColor = "#dfe9e9";
 }else if(cssPath=="orange") {
	 msgDialogColor = "#aa3a00";
	 msgBgColor = "#ebe2de";
 }else if(cssPath=="darkred") {
	 msgDialogColor = "#a1261f";
	 msgBgColor = "#ebe2de";
 }else if(cssPath=="yellow") {
	 msgDialogColor = "#FFCC22";
	 msgBgColor = "#ebe2de";
 }else if(cssPath=="pink") {
	 msgDialogColor = "#f27ca0";
	 msgBgColor = "#ebe2de";
 }else if(cssPath=="silver") {
	 msgDialogColor = "#D1D1D1";
	 msgBgColor = "#ebe2de";
 }
   
 function startCompareAlert(str){
	document.onreadystatechange=function changeselect(){
		if(document.readyState=="complete"){
			 if( str != "" ) {
			 	sAlert(str);
			 }
		}
	}
 }
 
 function sAlert(str,titleStr,call_func) {
	 if(document.getElementById("bgDiv")){
		 return;
	 }
        var msgw, msgh, bordercolor;
        
        var brarray = str.match(/(<br)/g);
        var brnum = 1;
        if(brarray!=null){
	        brnum = brarray.length + 1;
        }
        
        //�������ö�
        document.documentElement.scrollTop=0;//��IE Quick
        document.body.scrollTop=0;//IE ����ģʽ
  
        msgw = 450;//��ʾ���ڵĿ��   
        msgh = 75 + (brnum * 25);//��ʾ���ڵĸ߶�   
        titleheight = 25 //��ʾ���ڱ���߶�   
        bordercolor = msgDialogColor;//��ʾ���ڵı߿���ɫ   
        titlecolor = msgDialogColor;//��ʾ���ڵı�����ɫ   
        var sWidth, sHeight;
        sWidth = document.body.scrollWidth;//��ҳ����ȫ�Ŀ�
        sHeight = document.body.scrollHeight;//��ҳ����ȫ�ĸ�
        //�����㣨��С�봰����Ч������ͬ�����������Ի���ʱ��������ʾΪ����״͸����ɫ��   
        var bgObj = document.createElement("div");//����һ��div���󣨱����㣩   
        //����div���ԣ����൱��
  
        // <div   id= "msgDiv "   align= "center "   style= "background-color:white;   border:1px   solid   #336699;   position:absolute;   left:50%;   top:50%;   font:12px/1.6em   Verdana,Geneva,Arial,Helvetica,sans-serif;   margin-left:-225px;   margin-top:npx;   width:400px;   height:100px;   text-align:center;   line-height:25px;   z-index:100001; "> __tag_35$351_  
        bgObj.setAttribute("id", "bgDiv");
        bgObj.style.position = "absolute";
        bgObj.style.top = "0";
        bgObj.style.background = msgBgColor;
        bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
        bgObj.style.opacity = "0.6";
        bgObj.style.left = "0";
        bgObj.style.width = sWidth + "px";
        bgObj.style.height = sHeight + "px";
        bgObj.style.zIndex = "10000";
        document.body.appendChild(bgObj);//��body����Ӹ�div����   
  
        var msgObj = document.createElement("div")//����һ��div������ʾ��㣩   
        //����div���ԣ����൱��
        // <div   id= "msgDiv "   align= "center "   style= "background-color:white;   border:1px   solid   #336699;   position:absolute;   left:50%;   top:50%;   font:12px/1.6em   Verdana,Geneva,Arial,Helvetica,sans-serif;   margin-left:-225px;   margin-top:npx;   width:400px;   height:100px;   text-align:center;   line-height:25px;   z-index:100001; "> __tag_72$353_   
        msgObj.setAttribute("id", "msgDiv");
        msgObj.setAttribute("align", "center");
        msgObj.style.background = "white";
        msgObj.style.border = "1px solid";
        msgObj.style.position = "absolute";
        msgObj.style.left = "50%";
        msgObj.style.top = "100px";
        msgObj.style.font = "12px/1.6em Verdana,Geneva,Arial,Helvetica,sans-serif";
        msgObj.style.marginLeft = "-225px";
        msgObj.style.marginTop = document.documentElement.scrollTop + "px";
        msgObj.style.width = msgw + "px";
        //msgObj.style.height = msgh + "px";
        msgObj.style.height = "auto";
        msgObj.style.textAlign = "center";
        msgObj.style.lineHeight = "25px";
        msgObj.style.zIndex = "10001";
  
        var title = document.createElement("h4");//����һ��h4������ʾ���������   
        //����h4�����ԣ����൱��   
        // <h4   id= "msgTitle "   align= "right "   style= "margin:0;   padding:3px;   background-color:#336699;   filter:progid:DXImageTransform.Microsoft.Alpha(startX=20,   startY=20,   finishX=100,   finishY=100,style=1,opacity=75,finishOpacity=100);   opacity:0.75;   border:1px   solid   #336699;   height:18px;   font:12px   Verdana,Geneva,Arial,Helvetica,sans-serif;   color:white;   cursor:pointer; "   onclick= " "> �ر� __tag_110$425_   
        title.setAttribute("id", "msgTitle");
        title.setAttribute("align", "left");
        title.style.margin = "0";
        title.style.padding = "3px";
        title.style.background = bordercolor;
        title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20,startY=20,finishX=100,finishY=100,style=1,opacity=75,finishOpacity=100);";  
        title.style.opacity = "0.75";
        title.style.border = "1px solid";
        title.style.height = "18px";
        title.style.font = "13px Verdana,Geneva,Arial,   Helvetica,sans-serif";
        title.style.color = "white";
        title.style.cursor = "pointer";
        title.style.fontSize="14";
        if(titleStr){
        	title.innerHTML = "<span style='padding-left:7px'> <b>"+titleStr+"</b> </span>";
        }else{
        	title.innerHTML = "";
        }
        title.onclick = removeObj;
        var button = document.createElement("input");//����һ��input������ʾ��ť��   
        //����input�����ԣ����൱��   
        // __tag_146$7_   
  
        button.setAttribute("type", "button");
        button.setAttribute("value", "�ر�");
        button.style.width = "60px";
        button.style.align = "center";
       	//button.style.marginLeft = "230px";
        button.style.marginBottom = "10px";
        button.style.background = bordercolor;
        button.style.border = "1px solid";
        if(cssPath == "yellow"){
        	button.style.color = "black";
        }else{
        	button.style.color = "white";
        }
        button.onclick = removeObj;
        
        var cen = document.createElement("center");
        cen.appendChild(button);
        function removeObj() {//����������������¼�   
            document.body.removeChild(bgObj);//ɾ��������Div   
            document.getElementById("msgDiv").removeChild(title);//ɾ����ʾ��ı�����   
            document.body.removeChild(msgObj);//ɾ����ʾ���  
            if(call_func)
            	eval(call_func);
        }  
        document.body.appendChild(msgObj);//��body�������ʾ��div����msgObj   
        document.getElementById("msgDiv").appendChild(title);//����ʾ��div����ӱ���������title   
        var txt = document.createElement("p");//����һ��p������ʾ����ʾ��Ϣ��   
  
        //����p�����ԣ����൱��   
        // __tag_192$7_ ����Ч�� __tag_192$60_   
        txt.style.margin = "1em 0";
        txt.setAttribute("id", "msgTxt");  
        txt.style.margin="0 15px 10px 15px";
        txt.style.align = 'left';
        txt.innerHTML = str;//��Դ�ں�������ʱ�Ĳ���ֵ   
  
        document.getElementById("msgDiv").appendChild(txt);//����ʾ��div�������ʾ��Ϣ����txt   
        document.getElementById("msgDiv").appendChild(cen);//����ʾ��div����Ӱ�ť����button
        
       
        button.focus();
        return;
     }
</script>

<s:if test="hasActionErrors()">
	<script language="JavaScript">
var actionmsg = "";
</script>
	<s:iterator value="actionErrors">
		<script language="JavaScript">
actionmsg = actionmsg+"<s:property escape="false"/>"+"</br>";
	    </script>
	</s:iterator>
	<script language="JavaScript">
if (actionmsg != "") {
	startCompareAlert(actionmsg);
}
</script>
</s:if>


<s:if test="hasActionMessages()">
	<script language="JavaScript">
var actionmsg = "";
</script>
	<s:iterator value="actionMessages">
		<script language="JavaScript">
actionmsg = actionmsg+"<s:property escape="false"/>"+"</br>";
	    </script>
	</s:iterator>
	<script language="JavaScript">
if (actionmsg != "") {
	startCompareAlert(actionmsg);
}
</script>
</s:if>


<s:if test="hasFieldErrors()">
	<script language="JavaScript">
var msg = "";
</script>
	<s:iterator value="fieldErrors">
		<script language="JavaScript">
msg = msg+"<s:property escape="false"/>"+"</br>";
	        </script>
	</s:iterator>
	<script language="JavaScript">
if (msg != "") {
	startCompareAlert(msg);
}
</script>
</s:if>

