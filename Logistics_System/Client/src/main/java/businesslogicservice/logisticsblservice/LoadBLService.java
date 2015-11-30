/**
 *2015年10月21日
 *author:tdy
 *装车管理
 *discirption:在快递员揽件，营业厅业务员完成分拣和装车之后，一个经过验证的营业厅业务员开始处理快递件装车，记录本次装车的所有信息。 
 */
package businesslogicservice.logisticsblservice;

import utility.ResultMessage;
import vo.LoadListVO;
import vo.OrderListVO;

public interface LoadBLService {
	
	/**营业厅业务员确认生成装车单
	 * 前置条件：	输入无误，点击确认按钮
	 * 后置条件：	系统补足缺省选项之后保存装车单并显示装车单详情
	 */
	public ResultMessage createLoadlist(LoadListVO loadListVO);
	
}
