package dataservice.logisticsdataservice;

import po.LoadListPO;
import po.OrderListPO;


public interface LoadDataService {
	/**
	 * 营业厅业务员输入编码号 按添加按钮 调用此方法将信息添加进LoadList单据中
	 * @param num
	 * @return
	 */
	public OrderListPO addLoad(String num);
	
	/**营业厅业务员确认生成装车单
	 * 前置条件：	输入无误，点击确认按钮
	 * 后置条件：	系统补足缺省选项之后保存装车单并显示装车单详情
	 */
	public boolean createLoadlist(LoadListPO loadListPO);
}
