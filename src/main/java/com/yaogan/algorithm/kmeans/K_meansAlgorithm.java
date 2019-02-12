package com.yaogan.algorithm.kmeans;

/**
 * 调用算法，传入src与des以及格式后，进行算法分割。
 * 其中考虑到TIFF图像无法直接进处理，通过jai扩展image功能，实现tiff读取转换成jpeg格式，分割完成在转回tiff格式
 * @author ASUS
 *
 */
public class K_meansAlgorithm {

	public void runAlgorithm(String srcpath, String despath, String format) {
		String src = srcpath;
		String des = despath;
		//判断是否为tiff图像标志。
		Boolean isTiff = false;
		//判断为TIFF图像的四种格式，则进行转换jpeg
		if (format.toLowerCase().equals("tif")||format.toLowerCase().equals("tiff")) {
			//将后缀改为jpeg,此路径与传入的路径相同
			String temsrcpath = srcpath.replace(format, "jpeg");
			//此路径做为jpeg分割后所在路径的jpeg文件保存位置
			String temdespath = despath.replace(format, "jpeg");
			//进行进行格式转换,保存在传入路径相同文件夹内部
			TransformFormat.format(srcpath, temsrcpath, format);
			//重新赋值给src，作为调用算法的入参数
			src = temsrcpath;
			des = temdespath;
			//标志置true，确认为tiff图像
			isTiff = true;
		}
		//进行图像分割运算
		ImageCluster ic=new ImageCluster();
		ic.kmeans(src, des, 4, 10);
		
		//判断tiff标志为true,则将jpeg格式转换回tiff图像原
		if (isTiff) {
			//将分割后jpeg文件转后相应的tiff文件。
			TransformFormat.format(des, despath, "JPEG");
		}
	}
	
}
