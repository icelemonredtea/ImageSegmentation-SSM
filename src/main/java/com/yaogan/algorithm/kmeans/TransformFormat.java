package com.yaogan.algorithm.kmeans;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;

public class TransformFormat {
	
//	public static void main(String[] args) {
//		String srcpath = "D:/java/image/service/tiftest.tif";
//		String despath = "D:/java/image/service/result.jpeg";
//		format(srcpath, despath, "TIFF");
//	}
//	
	/**
	 * JPEG与TIFF相互转换,传入src,des和图片格式，需要jai的core与codec架包
	 * @param src
	 * @param des
	 * @param format
	 */
	
	public static void format(String src, String des, String format) {
		//读取图片文件
		 RenderedOp srcfile = JAI.create("fileload", src);
		//文件存储输出流
		 OutputStream ops = null;
		 ImageEncoder image = null;
		 try {
			ops = new FileOutputStream(des);
			//判断格式是否为JPEG
			if(format.equals("JPEG")) {
				//进行TIFF格式转换
				TIFFEncodeParam param = new TIFFEncodeParam();
				image = ImageCodec.createImageEncoder("TIFF", ops, param);
			}else {
				//进行JPEG格式转换
				 JPEGEncodeParam param = new JPEGEncodeParam();
				 image = ImageCodec.createImageEncoder("JPEG", ops, param); 
			}
			//解析输出流进行输出
			image.encode(srcfile);
			//关闭流
			ops.close();
		} catch (FileNotFoundException e) {
			System.out.println("转换格式失败");
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("格式转换输出有误");
		}
	}

}




