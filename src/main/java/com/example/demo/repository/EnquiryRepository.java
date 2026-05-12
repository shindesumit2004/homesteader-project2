package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>
{


 
	//Enqiry Report
	List<Enquiry> findByDateoutBetween(java.util.Date startdate, java.util.Date enddate);
	
	List<Enquiry> findByFemailLike(String email);
}
