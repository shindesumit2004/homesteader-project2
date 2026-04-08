package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//Farmer Repository For Hibernate
public interface farmRepository  extends JpaRepository<farmerEntity, Long>
{
	
	//Login Farmer
	farmerEntity findByEmailAndPassword(String email,String password);
	
	//Avoid Dublicate Email
	farmerEntity findByEmail(String email);
	
	
	//Show Profile
	List<farmerEntity> findByEmailLike(String email);
	
	
	

	//save Farmer Trainin
	void save(Training_Farmer t1);
	
	//save Student Training
	void save(Training_Student t1);

	//save Enqiry 
	void save(enquiry_Entity t3);

	//save Contact 
	void save(contact_Entity t4);
	
	
	
	
	

}
