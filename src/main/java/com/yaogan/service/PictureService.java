package com.yaogan.service;

import java.util.List;

import com.yaogan.entity.Picture;

/**
 * 业务层
 * @author ASUS
 *
 */
public interface PictureService {

	//查询所有信息
	public List<Picture> findAllPictureByQueryVo();
	
}
