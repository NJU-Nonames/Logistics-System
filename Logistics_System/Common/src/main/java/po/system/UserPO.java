/**
 *2015年10月22日
 *author:tdy
 *discirption:所有用户的父类 
 */
package po.system;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class UserPO implements Serializable{
	/**
	 * 账号
	 */
	private String userNum;
	
	/**
	 * 密码
	 */
	private String initialPassword;
	
	/**
	 * 权限
	 */
	private String authority;
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 构造方法
	 * @param userNum
	 * @param initialPassword
	 * @param authority
	 * @param position
	 */
	public UserPO(String userNum,String initialPassword,String position,String authority){
		this.userNum = userNum;
		this.initialPassword = initialPassword;
		this.authority = authority;
		this.position=position;
	}

    public String getUserNum() {
        return userNum;
    }

    public String getInitialPassword() {
        return initialPassword;
    }

    public String getAuthority() {
        return authority;
    }
    public String getPosition(){
    	return position;
    }

	public void setInitialPassword(String initialPassword) {
		this.initialPassword = initialPassword;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setPosition(String position){
		this.position=position;
	}
    
}
