package com.yaogan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaogan.entity.Picture;
import com.yaogan.service.PictureService;

/**
 * 控制层
 * @author ASUS
 *
 */

@Controller
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	
	@RequestMapping(value="/solution.action")
	public String itemList(Model model ) {
		
		List<Picture> pictures = pictureService.findAllPictureByQueryVo();
		model.addAttribute("pictures", pictures);
		
		return "solution";
	}
	
}
