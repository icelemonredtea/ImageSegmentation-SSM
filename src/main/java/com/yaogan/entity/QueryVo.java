package com.yaogan.entity;

import java.io.Serializable;


/**
 * 包装类
 * @author ASUS
 *
 */
public class QueryVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//picture进行包装
	private Picture picture;

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	
}
