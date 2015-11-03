/**
 *2015年10月22日
 *author:tqy
 *description:所有用户类 
 */
package vo;

import utility.UserType;

public class UserVO {
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
	private UserType position;
	
	/**
	 * 构造方法
	 * @param userNum
	 * @param initialPassword
	 * @param authority
	 * @param position
	 */
	public UserVO(String userNum,String initialPassword,UserType position,String authority){
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
    public UserType getPosition(){
    	return position;
    }

	public void setInitialPassword(String initialPassword) {
		this.initialPassword = initialPassword;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setPosition(UserType position){
		this.position=position;
	}
    
}
