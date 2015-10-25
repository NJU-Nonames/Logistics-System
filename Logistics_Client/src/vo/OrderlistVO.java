/**
 *2015年10月21日
 *author:tdy
 *discirption:订单的vo实体类
 */
package vo;

public class OrderListVO extends ListVO{
	String id;
	public OrderListVO(String id){
		this.id=id;
	}
	public boolean print(){
		System.out.println(this.id);
		return false;
	}
	public String getId(){
		return this.id;
	}
}	
