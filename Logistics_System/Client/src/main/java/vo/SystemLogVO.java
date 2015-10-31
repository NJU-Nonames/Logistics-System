package vo;

/**
 * 系统日志
 * @author 这菜咸了
 *
 */
public class SystemLogVO {
	/**
	 * 创建时间
	 */
	String time;
	
	/**
	 * 操作者
	 */
	String user;
	
	/**
	 * 操作内容
	 */
	String content;

	public SystemLogVO(String time, String content,String user) {
		super();
		this.time = time;
		this.user=user;
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public String getContent() {
		return content;
	}
}
