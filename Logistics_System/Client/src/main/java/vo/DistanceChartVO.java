package vo;

public class DistanceChartVO {
     /**
     * 距离表
     */
    String [][] distanceChart;

	public DistanceChartVO(String[][] distanceChart) {
		super();
		this.distanceChart = distanceChart;
	}

	public String[][] getDistanceChart() {
		return distanceChart;
	}
     
}
