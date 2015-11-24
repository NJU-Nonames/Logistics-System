/**
 *2015年10月22日
 *author:tdy
 *discirption:所有的单的父类 
 */
package po.list;

import java.io.Serializable;

import utility.CheckType;

public abstract class ListPO implements Serializable{
	CheckType checkType;

	public CheckType getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckType checkType) {
		this.checkType = checkType;
	}
	
}