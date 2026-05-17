package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Product {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String pname;
	private String ptype;
	private String pfilen;
	private int pcprice;
	private int pwprice;

}
