package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.entity.Lead;
import com.myapp.exceptionhandler.LeadAlreadyExistsException;
import com.myapp.repo.LeadRepository;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public void createLead(Lead lead) {
        if (leadRepository.existsById(lead.getLeadId())) {
            throw new LeadAlreadyExistsException("Lead Already Exists in the database with the lead id");
        }
        leadRepository.save(lead);
    }
    public List<Lead> getLeadsByMobileNumber(String mobileNumber) {
        return leadRepository.findByMobileNumber(mobileNumber);
    }
}

