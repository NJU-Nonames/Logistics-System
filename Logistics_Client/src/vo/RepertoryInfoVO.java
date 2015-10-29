/**
 * 2015年10月23日
 *author:
 *description:仓库信息类 用于库存查看使用
 */
package vo;

/**
 * @author 谭期友
 *
 */
public class RepertoryInfoVO {
	/**
	 * 货物总数
	 */
	private int total_num;
	/**
	 * 出货量
	 */
	private int out_Num;
	/**
	 * 入货量
	 */
	private int in_Num;
	/**
	 * 货物情况表
	 */
	private String repertoryList [][][][][];
	public int getTotal_num() {
		return total_num;
	}
	public int getOut_Num() {
		return out_Num;
	}
	public int getIn_Num() {
		return in_Num;
	}
	public String[][][][][] getRepertoryList() {
		return repertoryList;
	}
	public RepertoryInfoVO(int total_num, int out_Num, int in_Num,
			String[][][][][] repertoryList) {
		super();
		this.total_num = total_num;
		this.out_Num = out_Num;
		this.in_Num = in_Num;
		this.repertoryList = repertoryList;
	}

}
