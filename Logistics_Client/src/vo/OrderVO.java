package vo;

public class OrderVO{
	String id;
	public OrderVO(String id){
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
