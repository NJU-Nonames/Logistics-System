package presentation.mainui;


/**
 * @author 这菜咸了
 * 检查格式类 
 */
public class CheckFormat {
	//检查两个时间是否匹配
	public static String checkTwotime(String time1,String time2){
		String[] temp1=time1.split("-");
		String[] temp2=time2.split("-");
		int year1=Integer.parseInt(temp1[0]);
		int month1=Integer.parseInt(temp1[1]);
		int day1=Integer.parseInt(temp1[2]);
		int year2=Integer.parseInt(temp2[0]);
		int month2=Integer.parseInt(temp2[1]);
		int day2=Integer.parseInt(temp2[2]);
		if(year1>year2){
			return "时间顺序错误";
		}
		else if(month1>month2&&year1==year2){
			return "时间顺序错误";
		}
		else if(day1>day2&&year1==year2&&month1==month2){
			return "时间顺序错误";
		}
		return "格式正确";
	}
	//检查时间是否合法
	public static String checkTime(String time){
		String s="格式正确";
		if(time.compareTo("")==0){
			return "时间未输入！";
		}
		else{
			String[] temp=s.split("-");
			if(temp.length!=3){
				return "时间格式输入有误";
			}
			else{
				int year,month,day;
				year=Integer.parseInt(temp[0]);
				month=Integer.parseInt(temp[1]);
				day=Integer.parseInt(temp[2]);
				boolean isR =(year%400==0)||((year%4==0)&&(year%100!=0));
				if(month>12||month<=0){
					return "月份输入有误";
				}
				if(isR){
					if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
						if(day>31||day<0){
							return "日期输入有误";
						}
					}
					else if(month==2){
						if(day>29||day<0){
							return "日期输入有误";
						}
					}
					else{
						if(day>30||day<0){
							return "日期输入有误";
						}
					}
				}
				else{
					if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
						if(day>31||day<0){
							return "日期输入有误";
						}
					}
					else if(month==2){
						if(day>28||day<0){
							return "日期输入有误";
						}
					}
					else{
						if(day>30||day<0){
							return "日期输入有误";
						}
					}
				}
				
			}
		}
		return s;
	}
	//检车营业厅编号
	public static String checkHallNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=6){
				return "营业厅编号输入错误";
			}
			else{
				if(num.substring(3,6)!="000"){
					return "格式正确";
				}
				else{
					return "营业厅编号输入错误";
				}
			}
		}
		else{
			return "未输入营业厅编号";
		}
	}
	//中转中心编号
	public static String checkCentreNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=6){
				return "中转中心编号输入错误";
			}
			else{
				if(num.substring(3,6)=="000"){
					return "格式正确";
				}
				else{
					return "中转中心编号输入错误";
				}
			}
		}
		else{
			return "未输入中转中心编号";
		}
	}
	//汽运编号
	public static String checkTruckTransNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=19){
				return "汽运编号输入有误";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入汽运编号编号";
		}
	}
	//列车编号
//	public static String checkTrainTransNum(String num){
//		String s=new String();
//		return s;
//	}
	//航班编号
//	public static String checkPlaneTransNum(String num){
//		String s=new String();
//		return s;
//	}
	//订单编号
	public static String checkOrderNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=18){
				return "请输入18位订单号！";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入订单号！";
		}
	}
//	//入库单编号
//	public static String checkInRepertoryNum(String num){
//		String s=new String();
//		return s;
//	}
//	//出库单编号
//	public static String checkOutRepertoryNum(String num){
//		String s=new String();
//		return s;
//	}
//	//中转中心到达单编号
//	public static String checkTransReceiveNum(String num){
//		String s=new String();
//		return s;
//	}
	//中转中心中转单编号
	public static String checkTransShipNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=21){
				return "中转中心中转单输入有误";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入中转中心中转单编号";
		}
	}
//	//营业厅到达单编号
//	public static String checkHallReceiveNum(String num){
//		String s=new String();
//		return s;
//	}
//	//营业厅装车单编号
//	public static String checkHallLoadNum(String num){
//		String s=new String();
//		return s;
//	}
	//营业厅派件单编号
//	public static String checkDeliverNum(String num){
//		String s=new String();
//		return s;
//	}
	//手机号
	public static String checkPhoneNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=11){
				return "手机号输入有误";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入手机号";
		}
	}
	//司机信息管理
	public static String checkDriverNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=9){
				return "司机编号输入有误";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入司机编号";
		}
	}
	//货车信息管理
	public static String checkTruckNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=7){
				return "货车编号输入有误";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入货车编号";
		}
	}
	//用户编号
	public static String checkUserNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()==5||num.length()==9){
				return "格式正确";
			}
			else{
				return "请输入5位或9位账号！";
			}
		}
		else{
			return "未输入账号！";
		}
	}
	//身份证号
	public static String checkIDCardNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=18){
				return "身份证号输入有误";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入身份证号";
		}
	}
	//银行账号
	public static String checkBankAccountNum(String num){
		if(num.compareTo("")!=0){
			if(num.length()!=19){
				return "请输入19位银行账号！";
			}
			else{
				return "格式正确";
			}
		}
		else{
			return "未输入银行账号！";
		}
	}
}
