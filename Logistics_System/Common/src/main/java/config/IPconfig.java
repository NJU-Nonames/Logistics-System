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
	
	String IP;
    String PORT;
	
	public String getIP(){
		return IP;
	}
	
	public int getPORT(){
		return Integer.parseInt(PORT);
	}

}
