package com.yaogan.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;


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
	
	private Date date;

	private String method;
	
	//存放上传文件的路径
	private String content;
	
	
	private File uploadpicture; //上传的文件名称,固定写法:name+FileName;
	
	private String uploadpictureFileName; //上传的文件名称,固定写法:name+FileName; 
	
	private String uploadpictureContentType;  //上传的文件类型,固定写法:name+ContentType;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	
	
	public File getUploadpicture() {
		return uploadpicture;
	}
	public void setUploadpicture(File uploadpicture) {
		this.uploadpicture = uploadpicture;
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
