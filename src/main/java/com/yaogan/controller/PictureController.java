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
	@RequestMapping(value = "/solution.action")
	public String itemList(Model model) {

		List<Picture> pictures = pictureService.findAllPictureByQueryVo();
		model.addAttribute("pictures", pictures);

		return "solution";
	}

	// 保存记录
	@RequestMapping(value = "/savePicture.action")
	public String savePicture(QueryVo queryVo, MultipartFile uploadpicture, HttpServletRequest request)
			throws Exception {

		// 传入分割算法的路径（保存路径和分割后的路劲)
		String src = null;
		String des = null;

		// 判断文件非空
		if (uploadpicture.isEmpty()) {
			return "error";
		}
		// 使用UUID给图片重命名，并去掉四个“-”
		String name = UUID.randomUUID().toString().replaceAll("-", "");
		// 添加后缀
		String extension = FilenameUtils.getExtension(uploadpicture.getOriginalFilename());
		// 获取根目录吗，再获取图片的保存和分割地址。
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

		System.out.println(queryVo.getPicture().getMethod());
		System.out.println(src);
		System.out.println(des);
		System.out.println(queryVo.getPicture().getUploadpictureFileName());
		// 执行算法,传入所选择的的分割方法，src,des，图片格式
		algorithm(queryVo.getPicture().getMethod(),src,des,extension);
		
		return "redirect:/solution.action";
	}

	// 删除记录
	@RequestMapping(value = "/deletePiture.action")
	public String deletePictureById(Integer id) {

		pictureService.deletePictureById(id);

		return "redirect:/solution.action";
	}

	// 分割算法选择
	public void algorithm(String method, String src, String des,String format) {

		// 根据传入method选择方法
		if (method.equals("K-means")) {
			// 执行k均值算法,传入src和dest的绝对路径，格式。
			new K_meansAlgorithm().runAlgorithm(src,des,format);

		} else {
			System.out.println("执行其他");
			// 执行xxxx
		}

	}
}
