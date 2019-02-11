package com.yaogan.mapper;

import java.util.List;

import com.yaogan.entity.Picture;

/**
 * 持久层
 * @author ASUS
 *
 */
public interface PictureMapper {

	
	//查询所有
	List<Picture> findAllPictureByQueryVo();


}
