package com.yaogan.algorithm.kmeans;

public class Test {
	
	public static void main(String[] args){
		
		String src = "D:\\java\\tomcat\\apache-tomcat-8.5.14\\wtpwebapps\\ImageSegmentation-SSM\\upload\\src\\1111.tif";
		String des = "D:\\java\\tomcat\\apache-tomcat-8.5.14\\wtpwebapps\\ImageSegmentation-SSM\\upload\\des\\1111.tif";
		K_meansAlgorithm k_meansAlgorithm  = new K_meansAlgorithm();
		k_meansAlgorithm.runAlgorithm(src, des, "tif");
		
	}
}
