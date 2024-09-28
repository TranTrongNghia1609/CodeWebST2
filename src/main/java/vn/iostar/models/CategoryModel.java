package vn.iostar.models;

import java.io.Serializable;

public class CategoryModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int catagoryid;
	private String catagoryname;
	private String images;
	private int status;
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCatagoryid() {
		return catagoryid;
	}
	public void setCatagoryid(int catagoryid) {
		this.catagoryid = catagoryid;
	}
	public String getCatagoryname() {
		return catagoryname;
	}
	public void setCatagoryname(String catagoryname) {
		this.catagoryname = catagoryname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CategoryModel [catagoryid=" + catagoryid + ", catagoryname=" + catagoryname + ", images=" + images
				+ ", status=" + status + "]";
	}
	
	
}
