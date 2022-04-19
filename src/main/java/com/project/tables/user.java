package com.project.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	@Column(length = 1500)
	private String uemail;
	private String upassword;
	private String uphone;
	private String upic;
	@Column(length = 1500)
	private String uaddress;
	private String utype;
	public user(int uid, String uname, String uemail, String upassword, String uphone, String upic, String uaddress, String utype) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.uphone = uphone;
		this.upic = upic;
		this.uaddress = uaddress;
		this.utype = utype;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(String uname, String uemail, String upassword, String uphone, String upic, String uaddress, String utype) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.uphone = uphone;
		this.upic = upic;
		this.uaddress = uaddress;
		this.utype = utype;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUpic() {
		return upic;
	}
	public void setUpic(String upic) {
		this.upic = upic;
	}
	public String getUaddress() {
		return uaddress;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	@Override
	public String toString() {
		return "user [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", upassword=" + upassword + ", uphone="
				+ uphone + ", upic=" + upic + ", uaddress=" + uaddress + "]";
	}
	
	
}
