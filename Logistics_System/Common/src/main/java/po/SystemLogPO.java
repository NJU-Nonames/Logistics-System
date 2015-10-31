package po;

import java.io.Serializable;

/**
 * 系统日志实体类PO
 * @author 这菜咸了
 *
 */
public class SystemLogPO implements Serializable{
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

	public SystemLogPO(String time, String content,String user) {
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
