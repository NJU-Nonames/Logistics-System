/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.informationchangeblservice._stub;

import java.util.ArrayList;

import vo.AgencyVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;


/**
 * @author Administrator
 *
 */
public class PeopleAgencyBLService_Stub implements PeopleAgencyBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.PeopleAgencyBLService#salaryManage(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage salaryManage(String userID, String salary) {
		// TODO 自动生成的方法存根
		System.out.println("管理成功");
		return new ResultMessage(true, "管理成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.PeopleAgencyBLService#addAgency(vo.AgencyVO)
	 */
	@Override
	public ResultMessage addAgency(AgencyVO agency) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.PeopleAgencyBLService#deleteAgency(java.lang.String)
	 */
	@Override
	public ResultMessage deleteAgency(String agencyId) {
		// TODO 自动生成的方法存根
		System.out.println("删除成功");
		return new ResultMessage(true, "删除成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.PeopleAgencyBLService#updataAgency(vo.AgencyVO)
	 */
	@Override
	public ResultMessage updataAgency(AgencyVO agency) {
		// TODO 自动生成的方法存根
		System.out.println("更新成功");
		return new ResultMessage(true, "更新成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.PeopleAgencyBLService#showAgency()
	 */
	@Override
	public ArrayList<AgencyVO> showAgency() {
		// TODO 自动生成的方法存根
		System.out.println("显示成功");
		ArrayList<AgencyVO> list = new ArrayList<AgencyVO>();
		list.add(new AgencyVO(null, null, null));
		return list;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.PeopleAgencyBLService#findAgency(java.lang.String)
	 */
	@Override
	public AgencyVO findAgency(String id) {
		// TODO 自动生成的方法存根
		System.out.println("寻找成功");
		return new AgencyVO(null, null, null);
	}

}
