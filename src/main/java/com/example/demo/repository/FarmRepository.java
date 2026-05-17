package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//Farmer Repository For Hibernate
public interface FarmRepository extends JpaRepository<Farmer, Long>
{
	
	//Login Farmer
	Farmer findByEmailAndPassword(String email, String password);
	
	//Avoid Dublicate Email
	Farmer findByEmail(String email);
	
	
	//Show Profile
	List<Farmer> findByEmailLike(String email);
	
	
	

	//save Farmer Trainin
	void save(TrainingFarmer t1);
	
	//save Student Training
	void save(TrainingStudent t1);

	//save Enqiry 
	void save(Enquiry t3);

	//save Contact 
	void save(Contact t4);
	
	
	
	
	

}
