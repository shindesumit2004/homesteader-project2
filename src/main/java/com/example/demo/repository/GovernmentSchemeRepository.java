package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GovernmentScheme;

public interface GovernmentSchemeRepository extends JpaRepository<GovernmentScheme, Integer> {

}