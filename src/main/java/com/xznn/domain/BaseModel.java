package com.xznn.domain;

import java.io.Serializable;

/**
 * @author hys
 */
public abstract class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 插入时所有属性列
	 * 
	 * @return
	 */
	abstract public String[] props();

	/**
	 * 插入时所有属性列的值
	 * 
	 * @return
	 */
	abstract public Object[] insertPropValues();

	/**
	 * 更新时所有属性列的值
	 * 
	 * @return
	 */
	abstract public Object[] updatePropValues();

	/**
	 * 主键值
	 * 
	 * @return
	 */
	abstract public long id();

	/**
	 * 设置主键值
	 * 
	 * @param id
	 */
	abstract public void setIdValue(long id);

	/**
	 * 分表ID
	 * 
	 * @return
	 */
	public int getSubmeterId() {
		return 0;
	}

	/**
	 * 置分表ID
	 * 
	 * @return
	 */
	public void setSubmeterId(int submeterId) {
	}

	/**
	 * @return
	 */
	public Object[] keysToId() {
		return null;
	}

	public Object[] keyValuesToId() {
		return null;
	}

	/**
	 * 分表时间(用于计算分区ID)
	 * 
	 * @return
	 */
	public int submeterTime() {
		return 0;
	}

}
