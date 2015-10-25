/**
 *2015年10月22日
 *author:tdy
 *discirption:所有用户的父类 
 */
package po;

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
	 * 构造方法
	 * @param userNum
	 * @param initialPassword
	 * @param authority
	 */
	public UserPO(String userNum,String initialPassword,String authority){
		this.userNum = userNum;
		this.initialPassword = initialPassword;
		this.authority = authority;
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

	public void setInitialPassword(String initialPassword) {
		this.initialPassword = initialPassword;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
    
}
