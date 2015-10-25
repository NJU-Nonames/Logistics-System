/**
 *2015年10月22日
 *author:tdy
 *description:人员机构功能调整的逻辑层接口 
 * 王家玮 2015-10-24
 */
package businesslogicservice.informationchangeblservice;

import java.util.ArrayList;

import businesslogic.utilitybl.ResultMessage;
import vo.AgencyVO;

public interface PeopleAgencyBLService {
	
	/**总经理进行的人员工资调整
	 * @param 要调整的用户编号
	 * @param 新的工资方案
	 * @return	调整是否成功
	 */             
	public ResultMessage salaryManage(String userID,String salary);
	
	/**
	 * 总经理选择新建机构
	 * @param agency
	 * @return 机构信息是否合理合法
	 */
	public ResultMessage addAgency(AgencyVO agency);
	
	/**
	 * 总经理选择删除机构
	 * @param agency
	 * @return 返回信息
	 */
	public ResultMessage deleteAgency(String agencyId);
	
	/**
	 * 总经理选择修改机构信息(包括对机构人员的增删改查)
	 * @param agency
	 * @return 返回信息是否合理
	 */
	public ResultMessage updataAgency(AgencyVO agency);
	
	/**
	 * 机构信息全部显示
	 * @param agency
	 * @return
	 */
	public ArrayList<AgencyVO> showAgency();
	
	/**
	 * 机构信息查询
	 * @param id
	 * @return
	 */
	public AgencyVO findAgency(String id);
	
}
