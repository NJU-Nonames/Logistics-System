/**
 *2015年10月22日
 *author:tdy
 *discirption:收件人的po实体类
 */
package po;

import java.io.Serializable;

public class ReceiverPO implements Serializable{
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

	public ReceiverPO(String name, String time) {
		super();
		this.name = name;
		this.time = time;
	}
}