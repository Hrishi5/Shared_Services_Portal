package project.timesheetWebapp.dto;

public class JsonKeyValueDTO {
	
	private String key ;
	private String value ;
	
	public JsonKeyValueDTO() {
		
	}
	
	public JsonKeyValueDTO(String k , String v) {
		this.key = k ;
		this.value = v ;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "JsonKeyValueDTO [key=" + key + ", value=" + value + "]";
	}
	
	

}
