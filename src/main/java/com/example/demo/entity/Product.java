package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String pname;
	
    private String ptype;
	
	private String pfilen;
	
	private int pcprice;
	
	private int pwprice;
	
	public String getPfilen() {
		return pfilen;
	}

	public void setPfilen(String pfilen) {
		this.pfilen = pfilen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	

	public int getPcprice() {
		return pcprice;
	}

	public void setPcprice(int pcprice) {
		this.pcprice = pcprice;
	}

	public int getPwprice() {
		return pwprice;
	}

	public void setPwprice(int pwprice) {
		this.pwprice = pwprice;
	}

	

}
