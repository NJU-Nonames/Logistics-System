package utility;

/**
 * @author 这菜咸了
 * 系统逻辑层返回信息（包括输入输出是否合法化等）
 */
public class ResultMessage {
	
	private boolean isPass;
	private String message;
	
	public ResultMessage(boolean isPass, String message) {
		super();
		this.isPass = isPass;
		this.message = message;
	}
	public boolean isPass() {
		return isPass;
	}
	public String getMessage() {
		return message;
	}
	
	
}
