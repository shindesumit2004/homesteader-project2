package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Agro;
import com.example.demo.entity.Product;
import com.example.demo.repository.AgroRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.AgroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AgroServiceImpl implements AgroService {
	
	@Autowired
	AgroRepository agroRepository;
	
	@Autowired
	ProductRepository ProductRepository;

	//Service for Register
	@Override
	public void registeagroRepositorygro(Agro a1) {
		
		agroRepository.save(a1);
		
	}

	
	//service for Login Details
	@Override
	public Agro CheckLoginagro(String email, String password) {
		
		
		
		return agroRepository.findByEmailAndPassword(email, password);
	}

	//service for add product
	@Override
	public void addnewproduct(Product p1) {
		
		agroRepository.save(p1);
		
	}


	//service for Shwo product list
	@Override
	public List<Product> showallproduct() {
		
		return ProductRepository.findAll();
	}

	//service for Show product list
	@Override
	public List<Product> showallproductfarmer() {
		
		return ProductRepository.findAll();
	}


	//Service for Show All product
	@Override
	public List<Product> showallpage() {
		
		return ProductRepository.findAll();
	}


	//Service for SeagroRepositorych
	@Override
	public List<Product> serch(String name, String type) {
		
		return ProductRepository.findByPnameOProductRepositorytypeLike(name, type);
	}

     //Service for Cheking pending Request
	 @Override
	 public List<Agro> getPendingAgro()
	 {
	        return agroRepository.findByStatus("pending");
	 }
	  
	  //Service for Cheking Approve Request
	 @Override
	 public List<Agro> getApproveAgro() {
			
			return agroRepository.findByStatus("Approve");
		}
      
	 
    //Search Agro
	@Override
	public List<Agro> findbyname(String name) {
		
		return agroRepository.findByNameLike(name);
	}

    //Remove
	@Override
	public void delete(int id) {
		
	      agroRepository.deleteById(id);
	}

    //Search Product
	@Override
	public List<Product> findbynameproduct(String name) {
		
		return ProductRepository.findByPnameLike(name);
	}

   //Show All Product
	@Override
	public List<Product> showallproductadmin() {
		
		return ProductRepository.findAll();
	}

   //Edit Product
	@Override
	public List<Product> updateproduct(String name) {
		
		return ProductRepository.findByPnameLike(name);
	}


	//Remove Product
	@Override
	public void deleteproduct(int id) {
		
		ProductRepository.deleteById(id);
		
	}


	//Show Agro To Farmers
	@Override
	public List<Agro> showagrofarmer() {
		// TODO Auto-geneagroRepositoryted method stub
		return agroRepository.findAll();
	}

    //Avoid Dublicate Entry
	@Override
	public Agro checkemailagro(String email) {
		
		return agroRepository.findByEmail(email);
	}


	@Override
	public long countproduct() {
		
		return ProductRepository.count();
	}


	@Override
	public long countagroagency() {
		
		return agroRepository.countByStatus("Approve");
	}


	


	


	






	


	

	


	

	
}
