package com.yaogan.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yaogan.entity.Picture;
import com.yaogan.entity.QueryVo;
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
	
	
	//查询所有记录
	@RequestMapping(value="/solution.action")
	public String itemList(Model model ) {
		
		List<Picture> pictures = pictureService.findAllPictureByQueryVo();
		model.addAttribute("pictures", pictures);
		
		return "solution";
	}
	
	
	
	//保存记录
	@RequestMapping(value="/savePicture.action")
	public String savePicture(QueryVo queryVo, MultipartFile uploadpicture, 
			HttpServletRequest request) throws Exception {
		
		System.out.println("开始执行保存操作");
		//判断文件非空
		if(uploadpicture.isEmpty()) {
			return "error";
		}
		// 使用UUID给图片重命名，并去掉四个“-”
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		//添加后缀
		String extension = FilenameUtils.getExtension(uploadpicture.getOriginalFilename());
		//获取根目录
		String path = request.getSession().getServletContext().getRealPath("/upload");
		//保存图片
		uploadpicture.transferTo(new File(path+"/"+name+"."+extension));
		//设置文件名和
		queryVo.getPicture().setUploadpictureFileName(name+extension);
		queryVo.getPicture().setUploadpictureContentType(extension);
		queryVo.getPicture().setContent(path);
		//保存数据库
		pictureService.savePictureByQueryVo(queryVo);
		System.out.println("完成保存操作");
		return "redirect:/solution.action";
	}
	
	
	
	//删除记录
	@RequestMapping(value="/deletePiture.action")
	public String deletePictureById() {
		
		System.out.println("进行删除");
		return "redirect:/solution.action";
	}
	
	
}
