package app.util.message.conversion.type;

public enum DataType {
	VARCHAR("varchar"),NUMBER("number"),SEQUENCE("sequence"),DEFAULT("default"),IGNORE("ignore");
	
	private String typeName;
	private DataType(String typeName){
		this.typeName = typeName;
	}
	
	private String getTypeName(){
		return this.typeName;
	}
	
	public static DataType getDataType(String inputName){
		for(DataType type:values()){
			if(type.getTypeName().equals(inputName.toLowerCase()))
				return type;
		}
		throw new NumberFormatException("ӳ����������ƥ�䲻��ȷ");
	}
}
