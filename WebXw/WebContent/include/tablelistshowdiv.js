/*
 * �б��ȡ����ʱ����ʾ��
 */


$(document).ready(function(){
	var setText = function(event, api) {
		var target = $(event.originalEvent && event.originalEvent.target);
		if(target.length) {
			api.set('content', ("<div><table style='table-layout:fixed' width='200px'><tr><td style='word-wrap : break-word; overflow:hidden;'>"+target.text()+"</td></tr></table></div>")); // ��������
		}
	}
	// ��ָ�����򴴽����ڹ����tip
	if($("#tablist td[mytitle]")){
	if($("#tablist td[mytitle]").get(0)){
		$("#tablist td[mytitle]").each(function(){
			if($(this).attr("mytitle")){
				$(this).qtip({
					content: ("<div ><table style='table-layout:fixed' width='200px'><tr><td style='word-wrap : break-word; overflow:hidden;'>"+$(this).attr("mytitle")+"</td></tr></table></div>"),
					style: { 
						width:{min:200},
						padding: 5,
						background: '#CCCCCC',
						color: 'black',
						textAlign: 'left',
						border: {
							width: 5,
							radius: 7,
							color: '#CCCCCC'
						},
						tip: 'leftMiddle',//��ͷ����ͼ��λ��
						name: 'dark' // Inherit the rest of the attributes from the preset dark style
					},
					position: {
						target: 'mouse', // �������ָ��
						effect: false, // �ر�Ч��
						corner: {
		                    tooltip: "leftMiddle", // ��ͷ����λ��
		                    target: "leftMiddle" // ��ʾ������λ��
	                  	},
						viewport: $(window),
						adjust: { x: 0, y: 0 } // tipλ��ƫ�ƣ���ֹ��ס���ָ��
					},
					events: {
						show: setText,
						move: setText // �ƶ�ʱҲ��������
					}
				});
			}
		});
	}
	}
});