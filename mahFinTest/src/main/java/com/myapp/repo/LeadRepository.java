package com.myapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Integer> {
	  List<Lead> findByMobileNumber(String mobileNumber);
}
