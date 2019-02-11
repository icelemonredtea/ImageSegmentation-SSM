package com.yaogan.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaogan.entity.Picture;
import com.yaogan.service.PictureService;

/**
 * 测试mybatis和spring的整合service层
 * @author ASUS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml"})
public class Test02Spring_Mybatis {
	
	@Autowired
	private PictureService pictureService;

	@Test
	public void test1() {
		List<Picture> pictures = pictureService.findAllPictureByQueryVo();
		for(Picture picture : pictures) {
			System.out.println(picture);
		}
	}
	
}
