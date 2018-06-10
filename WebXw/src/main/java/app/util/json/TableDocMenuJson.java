package app.util.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import app.creditapp.sys.entity.TableDoc;



public class TableDocMenuJson {
	private TableDoc root = null;

	public TableDocMenuJson() {
		this.root = new TableDoc();
		this.root.setDoc_no("0");
		this.root.setDoc_name("doc���ɹ���");
	}

	public TableDocMenuJson(List<TableDoc> lst) {
		this();
		//ѭ��ȡ��ÿһ��TableDoc��¼
		for (Iterator<TableDoc> iterator = lst.iterator(); iterator.hasNext();) {
			TableDoc tableDoc = (TableDoc) iterator.next();
			appendChild(tableDoc);
		}
	}
	
	public void init(Map<String, List<TableDoc>> menus) {
		for (int index = 1; index <= menus.size(); index++) {
			String key = "menu_" + String.valueOf(index);
			ArrayList<TableDoc> list = (ArrayList<TableDoc>) menus.get(key);
			for (int i = 0; i < list.size(); i++) {
				appendChild(list.get(i));
			}
		}
	}

	public void appendChild(TableDoc node) {
		//��root���ڵ㿪ʼ������ȡ��ÿһ������
		TableDoc _node = this.indexNode(root, node.getUplev());
		//��ȡ���Ľڵ���ӵ�list������
		if(_node==null)return;
		_node.addChildren(node);
	}

	public TableDoc indexNode(TableDoc node, String id) {
		if (node == null || id == null) {
			return null;
		}
		TableDoc _node = null;
		if (id.equals(this.root.getDoc_no())) {
			return this.root;
		}
		ArrayList<TableDoc> list = node.getChildren();
		if (list == null || list.size() == 0) {
			return null;
		}
		for (int index = 0; index < list.size(); index++) {
			_node = list.get(index);
			if (!id.equals(_node.getDoc_no())) {
				_node = indexNode(_node, id);
				if (_node != null) {
					return _node;
				}
			} else {
				break;
			}
		}
		return _node;
	}

	public void setRootName(String name) {
		this.root.setDoc_name(name);
	}

	public String toJson() {
		return "(" + this.root.toJson() + ")";
	}
}
