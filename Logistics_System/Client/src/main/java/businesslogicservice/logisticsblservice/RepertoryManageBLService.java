/**
 *2015年10月21日
 *author:tdy
 *discirption: 仓库管理的相关接口，可能需要后期的进一步修订，尤其是返回值类型方面
 */
package businesslogicservice.logisticsblservice;


import java.util.ArrayList;

import utility.ResultMessage;
import vo.RepertoryInVO;
import vo.RepertoryInfoVO;
import vo.RepertoryInformationVO;
import vo.RepertoryOutVO;
import vo.RepertorySearch;


public interface RepertoryManageBLService {
	
	/**仓库管理人员根据中转中心到达单进行入库管理
	 * @param 	入库单
	 * @return	入库是否成功
	 */
	public ResultMessage createInputRepertory(RepertoryInVO repertoryIn);
	/**
	 * 生成入库单编号
	 * @return
	 */
	public String createRepertoryInId();
	
	/**仓库管理人员执行出库管理
	 * @param 	出库单
	 * @return	出库是否成功
	 */
	public ResultMessage createOutputRepertory(RepertoryOutVO repertoryOut);
	/**
	 * 生成出库单编号
	 * @return
	 */
	public String createRepertoryOutId();
	
	/**仓库管理人员进行库存盘点
	 * @return	返回一个库存信息的VO里面包含库存的信息类
	 */
	public RepertoryInfoVO  showRepertory();
	
	/**
	 * 库存查看
	 * @param start_time
	 * @param end_time
	 * @return 返回一个库存查看的VO
	 */
	public RepertorySearch searchRepertory(String start_time,String end_time);
	

	/**仓库管理人员进行库存管理操作
	 * 库存更新，库存调整
	 * 前置条件：库存中某一个区已经报警
	 * 后置条件：库存中的某区不再报警
	 */
	public ResultMessage repertoryAdjust(RepertoryInformationVO repertoryinformation);
	
	
	/**
	 * 
	 * @param repertoryname 仓库名称
	 * @param time 盘点的截止时间点
	 * @param list 仓库信息list
	 * @param path 存储路径
	 */
	public void exportRepertoryInformation(String repertoryname,String time,String path);
	
	
}
