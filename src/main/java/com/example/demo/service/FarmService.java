package com.example.demo.service;

import java.util.*;

import com.example.demo.entity.*;

public interface FarmService {

	//Service for Farmer Registration
	void Register(Farmer f1);
	
	//Service for Record Farmer Training Responce
	void submittraining(TrainingFarmer t1);
		
	//Service for Record Student Response
	void submitstudentrs(TrainingStudent t2);
	
	//Service for Rocord Farmer Enquiry
	void submitenquiry(Enquiry t3);
	
	//Service for Record Contact us
	void contactus(Contact t4);
	
	//Service for Save Soil Analysis Report
	void soilsave(SoilAnalysis s1);
	
	//Servie for Cheking login Details
	Farmer logindetails(String email, String password);
	
	//Service for Cheking Email alredy Present or not
	Farmer checkemail(String email);
	
	
	//Service For Showing Farmer Training Request
  	List<TrainingFarmer> Displayfarmerreq();
  	
  //Service For Showing Student Training Request
  	List<TrainingStudent> Displaystudentreq();
  	
  	//Show all Request
  	List<SoilAnalysis> showallreport();
  	
    //Service For Showing Enqiry Request
    List<Enquiry> DisplayEnqiry();
    
    //Show all Contact To Admin
    List<Contact> DisplayContactAdmin();
    
    //Show report datewise
    List<Enquiry> reportget(Date startdate, Date enddate);
    
    //Show report datewise
    List<TrainingStudent> reportgetstudent(Date startdate, Date enddate);
    
    //Show report datewise
    List<TrainingFarmer> reportgetfarmer(Date startdate, Date enddate);
    
    //Show report datewise
    List<SoilAnalysis> soilreportget(Date startdate, Date enddate);
    
    //Show Profile
    List<Farmer> findfarmerbyemail(String email);
    
    //Show Enqiry to Farmer
    List<Enquiry> findenqiryfarmer(String email);
    
    //Show Soil Analysis Report to Farmer
    List<SoilAnalysis> findsoilfarmer(String email);
    
    //Show Farmer Training to Farmer
    List<TrainingFarmer> findfarmertraining(String email);
    
    //Soil analysis check
    SoilAnalysis checksoildublicate(String email);
    
    //for Withdraw Soil analysis Request
    public void withdrawrequest(int id);
    
    //Show Farmers
    List<Farmer> showallfarmer();
    
    
    public long countApprovedFarmer();
}
