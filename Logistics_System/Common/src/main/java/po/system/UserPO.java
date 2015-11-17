/**
 *2015年10月22日
 *author:tdy
 *discirption:所有用户的父类 
 */
package po.system;

import java.io.Serializable;

import utility.UserType;

/**
 * @author Administrator
 *
 */
public class UserPO implements Serializable{
	/**
	 * 账号
	 */
	private String admin;
	
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 职位
	 */
	private UserType position;
	private String id;
	/**
	 * 构造方法
	 * @param userNum
	 * @param initialPassword
	 * @param authority
	 * @param position
	 */
	public UserPO(String userNum,String initialPassword,UserType position,String id){
		this.admin = userNum;
		this.password = initialPassword;
		this.position=position;
		this.id=id;
	}

    public String getAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }
    public UserType getPosition(){
    	return position;
    }

	public void setPassword(String initialPassword) {
		this.password = initialPassword;
	}

	public void setPosition(UserType position){
		this.position=position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
}
