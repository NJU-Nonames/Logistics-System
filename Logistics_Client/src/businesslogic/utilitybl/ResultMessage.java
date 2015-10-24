package businesslogic.utilitybl;

/**
 * @author 这菜咸了
 * 系统逻辑层返回信息（包括输入输出是否合法化等）
 */
public class ResultMessage {
	private Object value;
	String key;
	public Object getValue(){
		return this.value;
	}
	public String getKey(){
		return key;
	}
}
