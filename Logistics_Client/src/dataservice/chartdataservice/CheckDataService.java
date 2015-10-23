/**
 * 2015年10月23日
 *author:
 *description:审判单据
 */
package dataservice.chartdataservice;

import java.util.ArrayList;

import businesslogic.utilitybl.DocType;
import po.ListPO;


/**
 * @author 谭期友
 * 王家玮 2015-10-24
 */
public interface CheckDataService {
	/**
	 * 返回选定的需要审批单据信息
	 * @param docType
	 * @param time
	 * @return
	 */
	public ArrayList<ListPO> getDoc(DocType docType,String time);
	
	/**
	 * 修改选定的doc审批状态
	 * @param listPO
	 * @return
	 */
	public boolean changeDoc(ArrayList<ListPO> listPO);
}
