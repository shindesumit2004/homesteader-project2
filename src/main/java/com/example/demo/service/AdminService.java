package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Product;
import com.example.demo.entity.SubAdmin;

import java.util.List;

public interface AdminService {

	
	 //Method Save Blog 
	 public void blogupload(Blog b1);
	 
	 //Method Show Blog 
	 List<Blog> showallblog();
	 
	 //Method Show With Content Blog 
	 List<Blog> findblogbytittle(String title);
	
	 //Method to Delete Blog
	 public void deleteblog(int id);
	 
	 //Method Save Subadmin
	 public void savasubadmin(SubAdmin s1);
	 
	 //Login Subadmin
	 SubAdmin checksubadmin (String name, String password);
	
	 //Show All Subadmin
	 List<SubAdmin> showallsubadmin();
	
	 //Remove Acces of Subadmin
	 public void removesubadminaccress(int id);


    List<Product> findbynameproduct(String name);

	void agroServicevasubadmin(SubAdmin c5);
}

