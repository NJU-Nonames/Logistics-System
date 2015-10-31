package vo;

/**
 * @author 这菜咸了
 * 收件人
 */
/**
 * @author 这菜咸了
 *
 */
public class ReceiverVO {

	/**
	 * 收件人姓名
	 */
	private String name;
	
	/**
	 * 收件时间
	 */
	private String time;

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public ReceiverVO(String name, String time) {
		super();
		this.name = name;
		this.time = time;
	}
	
	
}
