package com.project.tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catid;
	private String cattitle;
	private String catdiscription;
	@OneToMany(mappedBy = "cate")
	private List<Product> product= new ArrayList<>();
	public category(int catid, String cattitle, String catdiscription) {
		super();
		this.catid = catid;
		this.cattitle = cattitle;
		this.catdiscription = catdiscription;
	}
	
	public category(String cattitle, String catdiscription, List<Product> product) {
		super();
		this.cattitle = cattitle;
		this.catdiscription = catdiscription;
		this.product = product;
	}

	public category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCattitle() {
		return cattitle;
	}
	public void setCattitle(String cattitle) {
		this.cattitle = cattitle;
	}
	public String getCatdiscription() {
		return catdiscription;
	}
	public void setCatdiscription(String catdiscription) {
		this.catdiscription = catdiscription;
	}
	
	
}
