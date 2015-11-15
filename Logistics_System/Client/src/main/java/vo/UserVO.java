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
	private String admin;
	
	/**
	 * 密码
	 */
	private String password;
	
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
	public UserVO(String admin,String password,UserType position,String authority){
		this.admin = admin;
		this.password = password;
		this.authority = authority;
		this.position=position;
	}

    public String getAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthority() {
        return authority;
    }
    public UserType getPosition(){
    	return position;
    }

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setPosition(UserType position){
		this.position=position;
	}
    
}
