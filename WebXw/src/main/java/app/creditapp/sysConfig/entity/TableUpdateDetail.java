package app.creditapp.sysConfig.entity;

public class TableUpdateDetail {
	
	private String tableName; //����
	
	private String commentName; //ע����
	
	private String columnName; //����
	
	private String preModifyValue; //�޸�ǰ��ֵ
	
	private String afterModifyValue;//�޸ĺ��ֵ
	
	private String col_name;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getPreModifyValue() {
		return preModifyValue;
	}

	public void setPreModifyValue(String preModifyValue) {
		this.preModifyValue = preModifyValue;
	}

	public String getAfterModifyValue() {
		return afterModifyValue;
	}

	public void setAfterModifyValue(String afterModifyValue) {
		this.afterModifyValue = afterModifyValue;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

}
