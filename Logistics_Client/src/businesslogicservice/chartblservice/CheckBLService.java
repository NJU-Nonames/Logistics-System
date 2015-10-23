/**
 * 2015年10月23日
 *author:
 *description:审判单据
 */
package businesslogicservice.chartblservice;

import java.util.ArrayList;

import businesslogic.utilitybl.DocType;
import vo.ListVO;


/**
 * @author 谭期友
 * 2015-10-24 王家玮修改
 */
public interface CheckBLService {
	/**
	 * 前置条件：总经理选择需要审批的单据类别
	 * 后置条件: 返回相应的所有单据
	 * @param arr
	 * @return 操作是否成功
	 */
	public ArrayList<ListVO> getAll(DocType docType,String time);
	
	/**总经理审批一个状态下全部单据
	 * @param docType
	 * @return 是否审批成功
	 */
	public boolean passAllDoc(DocType docType,String time);
	
	/**
	 * 总经理审批部分单据
	 * @param docType
	 * @param listVO
	 * @return
	 */
	public boolean passSelectedDoc(DocType docType,ArrayList<ListVO> listVO);
	
	/**
	 * 总经理审批部分单据未通过
	 * @param docType
	 * @param listVO
	 * @return
	 */
	public boolean failSelectedDoc(DocType docType,ArrayList<ListVO> listVO);
	
	/**
	 * 总经理修改订单数据
	 * @param docType
	 * @param listVO
	 * @return
	 */
	public boolean ChangeDoc(DocType docType,ListVO listVO);
}
