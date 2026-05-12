package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.SoilAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoilAnalysisRepository extends JpaRepository<SoilAnalysis, Integer>
{
	//Soil Report gate by date
	List<SoilAnalysis> findBySdateBetween(java.util.Date startdate, java.util.Date enddate);
	
	List<SoilAnalysis> findBySemailLike(String email);
	
	SoilAnalysis findBySemail(String email);
	
	
}
