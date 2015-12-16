package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 这菜咸了
 * ip设置
 */
public class IPconfig {
	
	public static String ipgetter(){
		String result=null;
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File("config/IP.txt")));
			result=br.readLine();
			
		} catch (FileNotFoundException e) {
			System.out.println("Ipconfig.txt is not found!");
			return null;
		} catch (IOException e) {
			System.out.println("IP配置有误");
			return null;
		}
		
		return result;
	}
}
