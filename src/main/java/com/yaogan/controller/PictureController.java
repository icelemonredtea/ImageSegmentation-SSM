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

import com.yaogan.algorithm.kmeans.K_meansAlgorithm;
import com.yaogan.entity.Picture;
import com.yaogan.entity.QueryVo;
import com.yaogan.service.PictureService;

/**
 * 控制层
 * 
 * @author ASUS
 *
 */

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;

	// 查询所有记录
	@RequestMapping(value = "/findAllPicture.action")
	public String itemList(Model model) {

		List<Picture> pictures = pictureService.findAllPictureByQueryVo();
		model.addAttribute("pictures", pictures);

		return "/WEB-INF/jsp/list.jsp";
	}

	// 保存记录
	@RequestMapping(value = "/savePicture.action")
	public String savePicture(QueryVo queryVo, MultipartFile uploadpicture, 
			HttpServletRequest request, Model model)throws Exception {

		// 传入分割算法的路径（保存路径和分割后的路劲)
		String src = null;
		String des = null;

		//返回前端页面的图片路径
		String fileName = null;
		
		// 判断文件非空
		if (uploadpicture.isEmpty()) {
			return "/WEB-INF/jsp/error.jsp";
		}
		// 使用UUID给图片重命名，并去掉四个“-”
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		// 添加后缀
		String extension = FilenameUtils.getExtension(uploadpicture.getOriginalFilename());
		// 获取根目录吗，再获取图片的保存src和分割des地址。
		String srcpath = request.getSession().getServletContext().getRealPath("/upload/src");
		String despath = request.getSession().getServletContext().getRealPath("/upload/des");
		src = srcpath + "/" + name + "." + extension;
		des = despath + "/" + name + "." + extension;
		// 保存图片
		uploadpicture.transferTo(new File(src));
		// 设置文件名和
		queryVo.getPicture().setUploadpictureFileName(name +"."+ extension);
		queryVo.getPicture().setUploadpictureContentType(extension);
		queryVo.getPicture().setContent(src);
		// 保存数据库
		pictureService.savePictureByQueryVo(queryVo);
		// 执行算法,传入所选择的的分割方法，src,des，图片格式，
		String exten = algorithm(queryVo.getPicture().getMethod(),src,des,extension);
		//根据算法返回的图片格式，赋值filename。
		if (exten.equals("jpeg")) {
			fileName = name+"."+"jpeg";
		}else {
			fileName = queryVo.getPicture().getUploadpictureFileName();
		}
		
		model.addAttribute("fileName", fileName);
		
		return "index.jsp";
	}

	// 删除记录
	@RequestMapping(value = "/deletePiture.action")
	public String deletePictureById(Integer id) {

		pictureService.deletePictureById(id);

		return "redirect:/findAllPicture.action";
	}

	// 分割算法选择
	public String algorithm(String method, String src, String des,String format) {

		// 根据传入method选择方法
		if (method.equals("K-means")) {
			// 执行k均值算法,传入src和dest的绝对路径，格式。
			return	new K_meansAlgorithm().runAlgorithm(src,des,format);

		} else {
			System.out.println("执行其他");
			// 执行xxxx
			return "null";
		}

	}
}
