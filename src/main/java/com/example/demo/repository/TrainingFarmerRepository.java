package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.TrainingFarmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingFarmerRepository extends JpaRepository<TrainingFarmer, Integer>


{
	//Farmer Training Report by date
	
	List<TrainingFarmer> findByFdateBetween(java.util.Date startdate, java.util.Date enddate);
	
	List<TrainingFarmer> findByFemailLike(String email);

}
