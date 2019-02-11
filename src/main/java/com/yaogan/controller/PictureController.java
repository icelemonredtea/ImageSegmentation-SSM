package com.yaogan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制层
 * @author ASUS
 *
 */

@Controller
public class PictureController {
	
	@RequestMapping(value="/error.action")
	public ModelAndView itemList() {
		ModelAndView mva = new ModelAndView();
		mva.setViewName("/WEB-INF/jsp/error.jsp");
		return mva;
	}
	
}
