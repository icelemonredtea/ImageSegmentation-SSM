package com.yaogan.service.imp;

import java.util.List;

import com.yaogan.entity.Picture;
import com.yaogan.mapper.PictureMapper;
import com.yaogan.service.PictureService;


/**
 * 业务层实现类
 * @author ASUS
 *
 */
public class PictureServiceImp implements PictureService {

	
	//spring注入
	private PictureMapper pictureMapper;
		
	public void setPictureMapper(PictureMapper pictureMapper) {
		this.pictureMapper = pictureMapper;
	}


	//查询所有信息
	@Override
	public List<Picture> findAllPictureByQueryVo() {
		return pictureMapper.findAllPictureByQueryVo();
	}

}
