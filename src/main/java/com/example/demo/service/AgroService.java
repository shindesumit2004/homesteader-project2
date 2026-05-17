package com.example.demo.service;

import com.example.demo.entity.Agro;
import com.example.demo.entity.Product;

import java.util.List;

public interface AgroService
{
    //Service for Registration
	void registeragro(Agro a1);
	
	//Service for Login
	Agro CheckLoginagro(String email, String password);
	
	//Service for Add New Product
	void addnewproduct(Product p1);
	
	//Service for Showing all Product at agro Dashboard
	List<Product> showallproduct();
	
	List<Agro> showagrofarmer();
	
	//Service for Showing all Product at Farmer Page
	List<Product> showallproductfarmer();
	
	//Service for Showing all Product at Farmer Page with Search
	List<Product> showallpage();
	
	//Service for Search
	List<Product> serch(String name, String type);
	
	//Service for Pending  Agroagency
	 List<Agro> getPendingAgro();
	 
	//Service for Listed  Agroagency
	 List<Agro> getApproveAgro();
	 
	 Agro checkemailagro (String email);
	//Service for Approve Agroagency
	List<Agro> findbyname(String name);
	
	//Service for Reject Agro Agency
	public void delete(int id);
	
	//Service for Delete Product
	public void deleteproduct(int id);
	
	//Service for Search Prodocu name
	List<Product> findbynameproduct(String name);
	
	//Service for Show all Product 
	List<Product> showallproductadmin();
	
	//Update product
	List<Product> updateproduct(String name);
	
	public long countproduct();
	
	public long countagroagency();
	

	
	
	
  
	
	
	
	
	
	
	
	
	
	
	
}
