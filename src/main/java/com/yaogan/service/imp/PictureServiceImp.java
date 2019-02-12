package com.yaogan.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaogan.entity.Picture;
import com.yaogan.entity.QueryVo;
import com.yaogan.mapper.PictureMapper;
import com.yaogan.service.PictureService;


/**
 * 业务层实现类
 * @author ASUS
 *
 */
@Service
public class PictureServiceImp implements PictureService {

	//spring注入
	@Autowired
	private PictureMapper pictureMapper;

	//查询所有信息
	@Override
	public List<Picture> findAllPictureByQueryVo() {
		return pictureMapper.findAllPictureByQueryVo();
	}

	//保存图片
	@Override
	public void savePictureByQueryVo(QueryVo queryVo) {
		pictureMapper.savePictureByQueryVo(queryVo);
	}

	//删除
	@Override
	public void deletePictureById(Integer id) {
		pictureMapper.deletePictureById(id);
	}

}
