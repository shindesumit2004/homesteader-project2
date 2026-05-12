package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Blog;
import com.example.demo.entity.Product;
import com.example.demo.repository.BlogRepository;
import com.example.demo.entity.SubAdmin;
import com.example.demo.repository.SubAdminRepository;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
	
	///Blog
	@Autowired
	BlogRepository blogRepository;
	
	///Subadmin
	@Autowired
	SubAdminRepository subAdminRepository;
	
	///Blog Start
    ///Blog Save
	@Override
	public void blogupload(Blog b1) {
		
		blogRepository.save(b1);
		
	}

	///Blog Show Farmer Page
	@Override
	public List<Blog> showallblog() {
		
		return blogRepository.findAll();	
		
	}

	///Show Full Blog on Farmer
	@Override
	public List<Blog> findblogbytittle(String title) {
		
		return blogRepository.findByTitleLike(title);
	}

	///Remove Blog
	@Override
	public void deleteblog(int id) {
		
		blogRepository.deleteById(id);
		
	}
	///Blog END
	///Subadmin Start
	///Add Subadmin
	@Override
	public void savasubadmin(SubAdmin s1) {
		
		subAdminRepository.save(s1);
	}

	///Login Check subadmin
	@Override
	public SubAdmin checksubadmin(String name, String password) {
		
		return subAdminRepository.findByNameAndPassword(name, password);
	}

	///Show subadmin to Admin Page
	@Override
	public List<SubAdmin> showallsubadmin() {
		
		return subAdminRepository.findAll();
	}

	///Remove Subadmin Access
	@Override
	public void removesubadminaccress(int id) {
		
		subAdminRepository.deleteById(id);
		
	}

	@Override
	public List<Product> findbynameproduct(String name) {
		return List.of();
	}

	@Override
	public void agroServicevasubadmin(SubAdmin c5) {

	}

}
