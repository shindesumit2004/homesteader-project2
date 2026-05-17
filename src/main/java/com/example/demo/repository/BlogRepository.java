package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BlogRepository extends JpaRepository<Blog, Integer>
{
	
	//Show all Blog To Farmer
	List<Blog> findByTitleLike(String title);
	  

}
