package com.project.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	@Column(length = 3000)
	private String pdesc;
	private String pphoto;
	private int pprice;
	private int pdiscount;
	private int pquantity;
	@ManyToOne
	private category cate;
	public Product(String pname, String pdesc, String pphoto, int pprice, int pdiscount, int pquantity, category cate) {
		super();
		this.pname = pname;
		this.pdesc = pdesc;
		this.pphoto = pphoto;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pquantity = pquantity;
		this.cate = cate;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public category getCate() {
		return cate;
	}
	public void setCate(category cate) {
		this.cate = cate;
	}
	public String getPphoto() {
		return pphoto;
	}
	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPdiscount() {
		return pdiscount;
	}
	public void setPdiscount(int pdiscount) {
		this.pdiscount = pdiscount;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getPriceafterApplingDiscount() {
		int d = (int) ((this.pdiscount/100.0)*this.pprice);
		return this.pprice-d;
	}
	
}
