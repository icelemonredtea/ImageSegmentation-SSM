package com.yaogan.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yaogan.entity.Picture;
import com.yaogan.mapper.PictureMapper;

/**
 * 测试mybatis和spring的整合dao层
 * @author ASUS
 *
 */

public class Test01Spring_Mybatis {

	@Test
	public void test1() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		PictureMapper pictureMapper = applicationContext.getBean(PictureMapper.class);
		List<Picture> pictures = pictureMapper.findAllPictureByQueryVo();
		for(Picture picture : pictures) {
			System.out.println(picture);
		}
	}
	
}
