package businesslogic.utilitybl;

public enum PkgState {

	RECEIVED,//收件
	SENDER_HALL_ARRIVAL,//到达寄件人营业厅
	SENDER_CENTER_ARRIVAL,//到达寄件人中转中心
	RECEIVER_HALL_ARRIVAL,//到达收件人营业厅
	RECEIVER_CENTER_ARRIVAL,//到达收件人中转中心
	SENDING,//派件人
	ARRIVED//已被签收
}
