package vo;

import utility.CheckType;

/**
 * 所有单的父类 抽象类
 * @author 这菜咸了
 *
 */
public abstract class ListVO {
	CheckType checkType;

	public CheckType getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckType checkType) {
		this.checkType = checkType;
	}
}
