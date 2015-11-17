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
	 * 职位
	 */
	private UserType position;
	
	/**
	 * 工号
	 */
	private String id;
	
	/**
	 * 构造方法
	 * @param userNum
	 * @param initialPassword
	 * @param authority
	 * @param position
	 */
	public UserVO(String admin,String password,UserType position,String id){
		this.admin = admin;
		this.password = password;
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

	public void setPassword(String password) {
		this.password = password;
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
