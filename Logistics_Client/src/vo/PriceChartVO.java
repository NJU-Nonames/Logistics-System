package vo;

/**
 * @author 这菜咸了
   价格常量表
 */
public class PriceChartVO {

	/**
	 * 货车每公里运费
	 */
	private double train_kilo;
	/**
	 * 货车每公里运费
	 */
	private double truck_kilo;
	/**
	 * 飞机每公里运费
	 */
	private double airplane_kilo;
	
	/**
	 * 标准快递标准价
	 */
	private double standard;
	
	/**
	 * 经济快递标准价
	 */
	private double economic;
	
	/**
	 * 次晨特快标准价
	 */
	
	private double express;

	public double getTrain_kilo() {
		return train_kilo;
	}

	public double getTruck_kilo() {
		return truck_kilo;
	}

	public double getAirplane_kilo() {
		return airplane_kilo;
	}

	public double getStandard() {
		return standard;
	}

	public double getEconomic() {
		return economic;
	}

	public double getExpress() {
		return express;
	}

	public PriceChartVO(double train_kilo, double truck_kilo,
			double airplane_kilo, double standard, double economic,
			double express) {
		super();
		this.train_kilo = train_kilo;
		this.truck_kilo = truck_kilo;
		this.airplane_kilo = airplane_kilo;
		this.standard = standard;
		this.economic = economic;
		this.express = express;
	}
	
}
