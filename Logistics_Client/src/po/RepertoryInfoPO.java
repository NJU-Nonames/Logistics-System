/**
 * 2015年10月23日
 *author:
 *description:仓库信息类
 */
package po;

import java.io.Serializable;

/**
 * @author 谭期友
 *
 */
public class RepertoryInfoPO implements Serializable{

	/**
	 * 入库数量
	 */
	private int repertory_in_num;
	/**
	 * 出库数量
	 */
	private int repertory_out_num;
	
	/**
	 * 仓库货物总量
	 */
	private int total_Num;
	
	/**
	 * 库存情况 
	 */
	private String Repertory[][][][][][];

	public RepertoryInfoPO(int repertory_in_num, int repertory_out_num,
			int total_Num, String[][][][][][] repertory) {
		super();
		this.repertory_in_num = repertory_in_num;
		this.repertory_out_num = repertory_out_num;
		this.total_Num = total_Num;
		Repertory = repertory;
	}

	public int getRepertory_in_num() {
		return repertory_in_num;
	}

	public int getRepertory_out_num() {
		return repertory_out_num;
	}

	public int getTotal_Num() {
		return total_Num;
	}

	public String[][][][][][] getRepertory() {
		return Repertory;
	}
	
	
}
