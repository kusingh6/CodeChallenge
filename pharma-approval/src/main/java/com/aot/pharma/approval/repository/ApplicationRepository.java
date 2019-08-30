package com.aot.pharma.approval.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aot.pharma.approval.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

	Application findByApplicationId(String applicationId);

	List<Application> findByApplicationStatus(String applicationStatus);
	
	List<Application> findByUserId(String userId);

}
