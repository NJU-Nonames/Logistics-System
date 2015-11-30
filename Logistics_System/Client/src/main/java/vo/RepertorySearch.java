package vo;

import java.util.ArrayList;

/**
 * @author 这菜咸了
 * 库存查看的VO
 */
public class RepertorySearch {
    
	/**
	 * 入库数量
	 */
	public String numberIn;
       
    /**
     * 出库数量
     */
    public String numberOut;
    
    /**
     * 入库金额
     */
    public String moneyIn;
    
    /**
     * 出库金额
     */
    public String moneyOut;
    
    /**
     * 某时间段内所有入库单
     */
    public ArrayList<RepertoryInVO> repertoryin;
    
    /**
     * 某时间段内所有出库单
     */
    public ArrayList<RepertoryOutVO> repertoryout;
}
