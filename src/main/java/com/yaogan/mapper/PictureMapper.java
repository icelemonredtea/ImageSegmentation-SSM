package com.yaogan.mapper;

import java.util.List;

import com.yaogan.entity.Picture;
import com.yaogan.entity.QueryVo;

/**
 * 持久层
 * @author ASUS
 *
 */
public interface PictureMapper {

	
	//查询所有
	List<Picture> findAllPictureByQueryVo();
	
	//保存图片
	void savePictureByQueryVo(QueryVo queryVo);

	//删除
	void deletePictureById(Integer id);

}
