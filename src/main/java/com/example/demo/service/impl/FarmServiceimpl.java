package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import com.example.demo.repository.*;
import com.example.demo.repository.SoilAnalysisRepository;
import com.example.demo.entity.*;
import com.example.demo.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmServiceimpl implements FarmService {
	
	//Farmer Entity
	@Autowired
	FarmRepository fd;
	
	//Farmer Training Entity
	@Autowired
	TrainingFarmerRepository rp;
	
	//Student Training Entity
	@Autowired
	StudentTrainingRepository rs;
	
	
	//Enqiry Entity
	@Autowired
	EnquiryRepository re;
	
	
	//Contact Entity
	@Autowired
	ContactRepository rc;
	
	//Soil Analysis Repo
	@Autowired
	SoilAnalysisRepository rsa;

	
	
	
	//Service For Farmer Data Registration
	@Override
	public void Register(Farmer f1) {
		
		fd.save(f1);
		
	}
	
	
	//Service for Cheking Email Alredy present or not
	@Override
	public Farmer checkemail(String email) {
		
		return fd.findByEmail(email);
	}
	

	//Service for Cheking login Credentials
	@Override
	public Farmer logindetails(String email, String password) {
		
		return fd.findByEmailAndPassword(email, password);
	}

	//Service for Submit Farmer Training
	@Override
	public void submittraining(TrainingFarmer t1) {
		
		fd.save(t1);
		
	}

	//Service for Submit Student Training
	@Override
	public void submitstudentrs(TrainingStudent t2) {
		
		fd.save(t2);
		
	}

	//Service for Showing Farmer Details
	@Override
	public List<TrainingFarmer> Displayfarmerreq() {
		
		return rp.findAll();
	}

	//Service for Showing Student Details
	@Override
	public List<TrainingStudent> Displaystudentreq() {
		
		return rs.findAll();
	}

	//Service for Submit Farmer Enqiry
	@Override
	public void submitenquiry(Enquiry t3) {
		
		fd.save(t3);
		
	}
	
	
	
	
	
	
	


	//Service for Showing Farmer Enqiry
	@Override
	public List<Enquiry> DisplayEnqiry() {
	
		return re.findAll();
	}
	
	
	
	
	


	
	
	//Service for Save Contact Us
	@Override
	public void contactus(Contact t4) {
		
		fd.save(t4);
		
	}


	//Show all Contact Enqiry
	@Override
	public List<Contact> DisplayContactAdmin() {
		
		return rc.findAll();
	}


	//Generate Report By Date
	@Override
	public List<Enquiry> reportget(Date startdate, Date enddate) {
		
		return re.findByDateoutBetween(startdate, enddate);
	}

    //Profile Page Display
	@Override
	public List<Farmer> findfarmerbyemail(String email) {
		
		return fd.findByEmailLike(email);
	}

    //Show All Farmers
	@Override
	public List<Farmer> showallfarmer() {
		
		return fd.findAll();
	}

    //Show all Student Request by Date
	@Override
	public List<TrainingStudent> reportgetstudent(Date startdate, Date enddate) {
		
		return rs.findBySdateBetween(startdate, enddate);
	}

	  //Show all Farmers Request by Date
	@Override
	public List<TrainingFarmer> reportgetfarmer(Date startdate, Date enddate) {
	
		return rp.findByFdateBetween(startdate, enddate);
	}

 
	//Save Soil Analysis Report 
	@Override
	public void soilsave(SoilAnalysis s1) {
		
		rsa.save(s1);
	}

  
	//Show all Report 
	@Override
	public List<SoilAnalysis> showallreport() {
		
		return rsa.findAll();
	}


	//Find By Date
	@Override
	public List<SoilAnalysis> soilreportget(Date startdate, Date enddate) {
		
		return rsa.findBySdateBetween(startdate, enddate);
	}


	@Override
	public List<Enquiry> findenqiryfarmer(String email) {
		
		return re.findByFemailLike(email);
	}


	@Override
	public List<SoilAnalysis> findsoilfarmer(String email) {
		
		return rsa.findBySemailLike(email);
	}


	@Override
	public List<TrainingFarmer> findfarmertraining(String email) {
		
		return rp.findByFemailLike(email);
	}


	@Override
	public void withdrawrequest(int id) {
		
		rsa.deleteById(id);
		
	}


	@Override
	public SoilAnalysis checksoildublicate(String email) {
		
		return rsa.findBySemail(email);
	}


	@Override
    public long countApprovedFarmer() {
        return fd.count();
    }


	


	


	


	


	

	


	

	


	

	

	

}
