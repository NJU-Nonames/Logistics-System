package po.constantinfo;

import java.io.Serializable;

public class DistanceChartPO implements Serializable{
	 /**
     * 距离表
     */
    String [][] distanceChart;

	public DistanceChartPO(String[][] distanceChart) {
		super();
		this.distanceChart = distanceChart;
	}

	public String[][] getDistanceChart() {
		return distanceChart;
	}
}
