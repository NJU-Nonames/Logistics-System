package businesslogic.chartbl;

import java.util.ArrayList;

import utility.DocType;
import vo.ListVO;
import businesslogicservice.chartblservice.CheckBLService;

public class CheckBLImpl implements CheckBLService {

	public ArrayList<ListVO> getAll(DocType docType, String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean passAllDoc(DocType docType, String time) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean passSelectedDoc(DocType docType, ArrayList<ListVO> listVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean failSelectedDoc(DocType docType, ArrayList<ListVO> listVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ChangeDoc(DocType docType, ListVO listVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
