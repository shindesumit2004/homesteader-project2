package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
 
	//Search by Name and Type
	List<Product> findByPnameOrPtypeLike(String name, String type);
	
	//Search
	List<Product> findByPnameLike(String name);
	
	
	
}
