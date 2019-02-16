package com.yaogan.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理发生未知异常
 * @author ASUS
 *
 */

public class PictureException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error", "发生未知异常!请检查文件格式等是否正确!");
		modelAndView.setViewName("/WEB-INF/jsp/error.jsp");
		
		
		return modelAndView;
	}

	
	
}
