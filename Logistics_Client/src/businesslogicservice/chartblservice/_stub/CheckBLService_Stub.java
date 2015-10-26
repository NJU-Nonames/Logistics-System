/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.chartblservice._stub;

import java.util.ArrayList;

import vo.ListVO;
import vo.OrderListVO;
import businesslogic.utilitybl.DocType;
import businesslogicservice.chartblservice.CheckBLService;

/**
 * @author Administrator
 *
 */
public class CheckBLService_Stub implements CheckBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.CheckBLService#getAll(businesslogic.utilitybl.DocType, java.lang.String)
	 */
	@Override
	public ArrayList<ListVO> getAll(DocType docType, String time) {
		// TODO 自动生成的方法存根
		System.out.println("收取成功");
		ArrayList<ListVO> list=new ArrayList<ListVO>();
		list.add(new OrderListVO(null, null, null, null, null, 0, 0, time, null, null, 0, time));
		return list;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.CheckBLService#passAllDoc(businesslogic.utilitybl.DocType, java.lang.String)
	 */
	@Override
	public boolean passAllDoc(DocType docType, String time) {
		// TODO 自动生成的方法存根
		System.out.println("通过成功");
		return true;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.CheckBLService#passSelectedDoc(businesslogic.utilitybl.DocType, java.util.ArrayList)
	 */
	@Override
	public boolean passSelectedDoc(DocType docType, ArrayList<ListVO> listVO) {
		// TODO 自动生成的方法存根
		System.out.println("通过成功");
		return true;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.CheckBLService#failSelectedDoc(businesslogic.utilitybl.DocType, java.util.ArrayList)
	 */
	@Override
	public boolean failSelectedDoc(DocType docType, ArrayList<ListVO> listVO) {
		// TODO 自动生成的方法存根
		System.out.println("选择失败");
		return true;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.CheckBLService#ChangeDoc(businesslogic.utilitybl.DocType, vo.ListVO)
	 */
	@Override
	public boolean ChangeDoc(DocType docType, ListVO listVO) {
		// TODO 自动生成的方法存根
		System.out.println("改变成功");
		return true;
	}

}
