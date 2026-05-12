package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Agro;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgroRepository extends JpaRepository<Agro, Integer>
{
	
	//Custom method For Cheking Login
	 Agro findByEmailAndPassword(String email, String password);
	 
	 //Avoid Dublicate Email
	 Agro findByEmail(String email);
 
	 //Save prodcut Details 
	 void save(Product p1);
	
	 //Check by Status Pending or Approved 
	 List<Agro> findByStatus(String status);
	
	 //Serach
	 List<Agro> findByNameLike(String name);
	 
	 int countByStatus(String status);
	
	
	
	

}
