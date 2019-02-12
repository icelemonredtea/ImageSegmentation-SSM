package com.yaogan.entity;

import java.io.Serializable;


/**
 * 实体类
 * @author ASUS
 *
 */
public class Picture implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//成员变量。
	private int id;
	private String date;//时间格式改为string类型
	private String method;
	private String content;	
	private String uploadpictureFileName;	//文件名字
	private String uploadpictureContentType;//文件类型
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUploadpictureFileName() {
		return uploadpictureFileName;
	}
	public void setUploadpictureFileName(String uploadpictureFileName) {
		this.uploadpictureFileName = uploadpictureFileName;
	}
	public String getUploadpictureContentType() {
		return uploadpictureContentType;
	}
	public void setUploadpictureContentType(String uploadpictureContentType) {
		this.uploadpictureContentType = uploadpictureContentType;
	}
	
	@Override
	public String toString() {
		return "Picture [id=" + id + ", date=" + date + ", method=" + method + ", content=" + content
				+ ", uploadpictureFileName=" + uploadpictureFileName + ", uploadpictureContentType="
				+ uploadpictureContentType + "]";
	}
	
	
	
	
}
