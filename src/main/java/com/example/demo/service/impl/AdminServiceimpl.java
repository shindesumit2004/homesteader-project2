package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.repository.BlogRepository;
import com.example.demo.repository.SubAdminRepository;
import com.example.demo.entity.Blog;
import com.example.demo.entity.SubAdmin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceimpl implements AdminService {
	
	
	
	
	
	//Blog
	@Autowired
	BlogRepository rb;
	
	//Subadmin
	@Autowired
	SubAdminRepository rs;
	
	

	                                        //Blog Start
    //Blog Save
	@Override
	public void blogupload(Blog b1) {
		
		rb.save(b1);
		
	}

	//Blog Show Farmer Page
	@Override
	public List<Blog> showallblog() {
		
		return rb.findAll();	
		
	}

	//Show Full Blog on Farmer
	@Override
	public List<Blog> findblogbytittle(String title) {
		
		return rb.findByTitleLike(title);
	}

	//Remove Blog
	@Override
	public void deleteblog(int id) {
		
		rb.deleteById(id);
		
	}
                                          //Blog END
	
	
	                                   //Subadmin Start
	//Add Subadmin
	@Override
	public void savasubadmin(SubAdmin s1) {
		
		rs.save(s1);
	}

	//Login Check subadmin
	@Override
	public SubAdmin checksubadmin(String name, String password) {
		
		return rs.findByNameAndPassword(name, password);
	}

	//Show subadmin to Admin Page
	@Override
	public List<SubAdmin> showallsubadmin() {
		
		return rs.findAll();
	}

	//Remove Subadmin Access
	@Override
	public void removesubadminaccress(int id) {
		
		rs.deleteById(id);
		
	}

	

	
	

	

	
	

}
