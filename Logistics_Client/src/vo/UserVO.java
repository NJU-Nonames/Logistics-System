/**
 *2015年10月22日
 *author:tqy
 *description:所有用户类 
 */
package vo;

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
	 * 构造方法
	 * @param userNum
	 * @param initialPassword
	 */
	public UserVO(String userNum,String initialPassword){
		this.userNum = userNum;
		this.initialPassword = initialPassword;
	}

    public String getUserNum() {
        return userNum;
    }

    public String getInitialPassword() {
        return initialPassword;
    }


	public void setInitialPassword(String initialPassword) {
		this.initialPassword = initialPassword;
	}
    
    
}
