package vn.iostar.models;

import java.sql.Date;

public class UserModel {
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String email;
	private String fullname;
	private String password;
	private String images;
	private int roleid;
	private String phone;
	private Date createDate;
	//tao cotructor
	public UserModel() {
		super();
	}
	//getter setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", fullname=" + fullname
				+ ", password=" + password + ", images=" + images + ", roleid=" + roleid + ", phone=" + phone
				+ ", createDate=" + createDate + "]";
	}
	public UserModel(String username, String email, String fullname, String password, String images, int roleid,
			String phone, Date createDate) {
		super();
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.images = images;
		this.roleid = roleid;
		this.phone = phone;
		this.createDate = createDate;
	}
	
	
	
	
	
	//overide mot so ham
	
	
	
	
}
