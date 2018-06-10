/*******************************************************************************
 * ���ÿؼ��滻�İ취�����select�ؼ������ۺ���Զ������������⡣
 * ֻҪ�����˱�js�ļ������Զ��滻����Select�ؼ�����selectδ����ID�������滻�� ÿ��select�ؼ���id�����������κοؼ���ͬ��
 * ��html�п���������ͼƬ��λ��(Ҫ��б��/)��������ʹ��Ĭ��·����
 * Ĭ��select��������select�ؼ�ͬ������ʵ�����������������select��DropDownWidth���Լ��ɣ���λΪ�㣩��
 * Ĭ��select�����������Ϊ6�У�����select��DropDownRows���Լ��ɣ�ȡֵ��ΧΪ1��10���� ����Ϊ�� <select
 * DropDownWidth="200" DropDownRows="10" ID="Select2" style="width:100px">
 ******************************************************************************/
/*
 * if (!SelDropdownPicturePath) { var SelDropdownPicturePath = "images/"; }
 */
var Sel_popup;

// ����������
function Sel_DropDown(edit, select) {
	// ����������
	var ColorOver = "#97D6DB";
	var ColorOut = "#DFF0F4";
	var len = select.options.length;

	var yl = 20; // ������߶�
	var overflowy = "hidden";

	var Sel_popup_rows = Number(select.getAttribute('DropDownRows'));
	if (isNaN(Sel_popup_rows) || (Sel_popup_rows < 1) || (Sel_popup_rows > 10))
		Sel_popup_rows = 6;

	if (len != 0) {
		if (len <= Sel_popup_rows)
			yl = len * 20 + 2;
		else {
			yl = Sel_popup_rows * 20 + 2;
			overflowy = "";
		}
	}

	// ��������
	var xl = select.getAttribute('DropDownWidth');
	if (xl == null)
		xl = edit.parentElement.style.pixelWidth;
	else
		xl = Math.max(parseInt(xl), edit.parentElement.style.pixelWidth);

	var html;
	if (!Sel_popup) {
		html = '<DIV '
				+ 'style="z-index:20000;position:absolute;font-family:����; font-size:9pt;'
				+ 'overflow:scroll; overflow-x:hidden; scrollbar-base-color:#5598B9; '
				+ 'color:#000080; border:1px solid #1B5977; cursor:hand; '
				+ 'SCROLLBAR-HIGHLIGHT-COLOR: #B4D9EC; SCROLLBAR-ARROW-COLOR: white"'
				+ 'onclick="Sel_capture_click()" onmouseover="Sel_capture_mover()" '
				+ 'onmouseout="Sel_capture_mout()" onmousemove="Sel_capture_mmove()">';
		Sel_popup = document.createElement(html);
		document.body.insertAdjacentElement('beforeEnd', Sel_popup);
	}

	Sel_popup.style.width = xl;
	Sel_popup.style.height = yl;
	Sel_popup.style.overflowY = overflowy;

	// ���������������
	html = "";
	for ( var i = 0; i < len; i++) {
		html += '<DIV onmouseover="this.style.background='
				+ "'"
				+ ColorOver
				+ "'"
				+ '" '
				+ 'onmouseout="this.style.background='
				+ "'"
				+ ColorOut
				+ "'"
				+ '" '
				+ 'NOWRAP STYLE="height:20px; background:'
				+ ColorOut
				+ '; border-bottom:1px solid #1B5977; padding-top:4px; padding-left:2px" '
				+ 'onclick="Sel_DoSelect(' + "'" + edit.id + "','" + select.id
				+ "'," + i + ');">' + select.options(i).text + '</DIV>';
	}

	var DropIMG = event.srcElement;
	Sel_popup.innerHTML = html;

	// ��λ
	var pos = event.clientX - event.offsetX - DropIMG.offsetLeft
			+ edit.offsetLeft - document.body.clientLeft
			+ document.body.scrollLeft;
	var max = document.body.scrollLeft
			+ document.body.getBoundingClientRect().right
			- Sel_popup.style.pixelWidth;
	// ����������ȳ�����������
	// ע�⣬��ҳ���Ҳ����scrollbarʱ���ö�λ��û�й���scrollbar�Ŀ��
	if (pos > max)
		Sel_popup.style.left = max;
	else
		Sel_popup.style.left = pos;

	pos = event.clientY - event.offsetY - DropIMG.offsetTop + edit.offsetTop
			+ edit.offsetHeight - document.body.clientTop
			+ document.body.scrollTop;
	// ���������߶ȳ��������ϵ���
	if (pos > document.body.scrollTop
			+ document.body.getBoundingClientRect().bottom - yl)
		pos -= edit.offsetHeight + yl;
	Sel_popup.style.top = pos;
	Sel_popup.style.display = "";

	Sel_popup.setCapture();
}

function Sel_hide() {
	Sel_popup.releaseCapture();
	Sel_popup.style.display = "none";
}

function Sel_capture_click() {
	var obj = event.srcElement;
	if (Sel_popup.contains(obj)) {
		if ((obj != Sel_popup) && obj.onclick)
			obj.onclick();
	} else {
		Sel_hide();
	}
}

function Sel_inPopup(x, y) {
	x += document.body.scrollLeft
			- (Sel_popup.offsetLeft + document.body.clientLeft);
	y += document.body.scrollTop
			- (Sel_popup.offsetTop + document.body.clientTop);
	if ((x >= 0) && (x < Sel_popup.offsetWidth) && (y >= 0)
			&& (y < Sel_popup.offsetHeight))
		return true;
	else
		return false;
}

function Sel_capture_mmove() {
	// ��ֹ����ƶ������һЩ����
	var obj = event.srcElement;
	if ((Sel_popup.style.display == "none")
			|| Sel_inPopup(event.clientX, event.clientY)) {
		Sel_popup.releaseCapture();
	} else
		Sel_popup.setCapture();
}

function Sel_capture_mover() {
	var obj = event.srcElement;
	if ((Sel_popup.style.display == "none") ||
	// (obj==Sel_popup) || // ���������ܼӣ��������ƶ���Ļ������������
	Sel_inPopup(event.clientX, event.clientY)) {
		Sel_popup.releaseCapture();
	}
	if (Sel_popup.contains(obj)) {
		if ((obj != Sel_popup) && obj.onmouseover)
			obj.onmouseover();
	}
}

function Sel_capture_mout() {
	var obj = event.srcElement;
	if (Sel_popup.style.display == "none")
		return;
	if ((obj == Sel_popup) || (!Sel_inPopup(event.clientX, event.clientY))) {
		Sel_popup.setCapture();
	}
	if (Sel_popup.contains(obj)) {
		if ((obj != Sel_popup) && obj.onmouseout)
			obj.onmouseout();
	}
}

// ѡ���������е�ѡ��
function Sel_DoSelect(edit, select, i) {
	edit = document.all(edit);
	select = document.all(select);
	edit.value = select.options(i).text;
	edit.select();
	edit.focus();
	if (select.selectedIndex != i) {
		select.selectedIndex = i;
		if (select.onchange)
			select.onchange();
	}
	Sel_hide();
}

// �滻ԭSelect�ؼ�
function Sel_ReplaceSelect(select) {
	select.style.display = "none";

	var parent = select.parentElement;
	var container = document.createElement("DIV");
	with (container.style) {
		pixelWidth = select.style.pixelWidth;
		if (pixelWidth == 0)
			pixelWidth = select.clientWidth;
		pixelLeft = select.style.pixelLeft;
		pixelTop = select.style.pixelTop;
		position = select.style.position;
	}
	parent.insertBefore(container, select);

	// ����edit�ؼ�
	var edit = document
			.createElement("<input type='text' class='selecteditctrl'>");
	edit.style.pixelWidth = select.clientWidth - 16;
	edit.tabIndex = select.tabIndex;
	if (select.selectedIndex >= 0) {
		edit.value = select.options(select.selectedIndex).text;
	}
	edit.readOnly = true;
	edit.disabled = select.disabled;
	edit.id = "E_" + select.id;
	container.appendChild(edit);

	// ����������ť
	var down = document
			.createElement('<IMG SRC="'
					+ SelDropdownPicturePath
					+ 'SelDropdown.gif" border=0 '
					+ 'style="margin-bottom:1px;vertical-align:bottom;cursor:hand" onclick="Sel_DropDown('
					+ edit.id + ',' + select.id + ')">');

	down.disabled = select.disabled;
	down.id = "D_" + select.id;
	container.appendChild(down);
}

function Sel_onloadinit() {
	var obj;
	var selects = document.all.tags("SELECT");
	for ( var i = 0; i < selects.length; i++) {
		obj = selects[i];
		// if ((obj.size==0)&&(obj.id!="")) Sel_ReplaceSelect(obj);
	}
}

window.addEventListener("onload", Sel_onloadinit);