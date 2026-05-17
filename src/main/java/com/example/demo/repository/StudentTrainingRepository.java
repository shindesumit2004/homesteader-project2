package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.TrainingStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTrainingRepository extends JpaRepository<TrainingStudent, Integer>
{
	//Student Training Report by date
	List<TrainingStudent> findBySdateBetween(java.util.Date startdate, java.util.Date enddate);
}
