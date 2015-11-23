package dataImpl.constantinfo;
import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.constantinfo.DistanceChartPO;
import po.constantinfo.PriceChartPO;
import dataservice.constantinfo.ConstantDataService;

public class ConstantDataImpl extends UnicastRemoteObject implements ConstantDataService,Serializable {

	File f1;
	File f2;
	public ConstantDataImpl() throws RemoteException {
		super();
		f1=new File("Data/DistanceChart");
		f2=new File("Data/PriceChart");
	}
	
//	public static void main(String args[]){
//		try {
//			ConstantDataImpl con=new ConstantDataImpl();
//			//con.addCity("宝鸡");
//			con.setDistance("999", "北京","上海");
//			//System.out.print("success");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	public void setDistance(String newDistance, String cityA, String cityB) {
		String[][] distanceChart=this.showDistanceChart().getDistanceChart();
		int c1=-1,c2=-1;
		for(int i=0;i<distanceChart[0].length;i++)
		{
			if(cityA.equals(distanceChart[0][i]))
				c1=i;
			if(cityB.equals(distanceChart[0][i]))
				c2=i;
		}
		//System.out.println(c1+" "+c2);
		if(c1!=-1&&c2!=-1)
		{
			System.out.print("success");
			distanceChart[c1][c2]=newDistance;
			distanceChart[c2][c1]=newDistance;
			try{
			FileWriter fw=new FileWriter(f1);
			fw.write("");
			fw.close();
			fw=new FileWriter(f1,true);
			int num=distanceChart[0].length;
			for(int i=0;i<num;i++)
			{
				if(i<num-1){
				for(int j=0;j<num;j++)
					if(j<num-1)
					    fw.write(distanceChart[i][j]+" ");
					else
					    fw.write(distanceChart[i][j]);
		
				fw.write("\n");
				}else
					for(int j=0;j<num;j++)
						if(j<num-1)
						    fw.write(distanceChart[i][j]+" ");
						else
						    fw.write(distanceChart[i][j]);
				
			}
			fw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}

	public void setPrice(String newPrice, String otherInformation) {
		// TODO Auto-generated method stub
	
	}

	public void addCity(String name) {
		String[][] distanceChart=this.showDistanceChart().getDistanceChart();
		try {
			FileWriter fw=new FileWriter(f1);
			fw.write("");
			fw.close();
			fw=new FileWriter(f1,true);
			int num=distanceChart[0].length;
			for(int i=0;i<num+1;i++)
			{
				if(i<num){
					for(int j=0;j<num+1;j++)
					{
						
						if(j<num)
						    fw.write(distanceChart[i][j]+" ");
						else if(i==0)
							fw.write(name);
						else
							fw.write("0");
					}
					fw.write("\n");
				}else
				{
					fw.write(name+" ");
					for(int j=0;j<num-1;j++)
					{
						fw.write("0 ");
					}
					fw.write("0");
				}
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DistanceChartPO showDistanceChart() {
		DistanceChartPO distance=null;
		try {
			BufferedReader br=new BufferedReader(new FileReader(f1));
			String temp=br.readLine();
			String[] first=temp.split(" ");
			int num=first.length;
			String[][] distanceChart=new String[num][num];
			//初始化后面
			int hang=0;
			while(temp!=null)
			{
				String[] spiltChart=temp.split(" ");
				for(int i=0;i<num;i++)
				{
					distanceChart[hang][i]=spiltChart[i];
				}
				temp=br.readLine();
				hang++;
			}
			distance=new DistanceChartPO(distanceChart);
		} catch (FileNotFoundException e) {
			System.out.println("未找到文件");
			return null;
		} catch (IOException e) {
			System.out.println("io输入异常");
			return null;
		}
		return distance;
	}

	public PriceChartPO showPriceChart() {
		PriceChartPO price=null;
		try {
            price=new PriceChartPO();
			BufferedReader br=new BufferedReader(new FileReader(f2));
			String temp;
			temp=br.readLine();
			String[] temps=temp.split(" ");
			price.setTrain_kilo_t(Double.parseDouble(temps[1]));
			temp=br.readLine();
			temps=temp.split(" ");
			price.setTruck_kilo_t(Double.parseDouble(temps[1]));
			temp=br.readLine();
			temps=temp.split(" ");
			price.setAirplane_kilo_t(Double.parseDouble(temps[1]));
			temp=br.readLine();
			temps=temp.split(" ");
			price.setStandard(Double.parseDouble(temps[1]));
			temp=br.readLine();
			temps=temp.split(" ");
			price.setEconomic(Double.parseDouble(temps[1]));
			temp=br.readLine();
			temps=temp.split(" ");
			price.setExpress(Double.parseDouble(temps[1]));
			
		} catch (FileNotFoundException e) {
			System.out.print("未找到文件");
			return null;
		} catch (IOException e) {
			System.out.print("IO error");
			return null;
		}
		return price;
	}

}
