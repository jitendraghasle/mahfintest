package com.myapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.entity.Lead;
import com.myapp.error.ErrorResponse;
import com.myapp.exceptionhandler.LeadAlreadyExistsException;
import com.myapp.helper.ApiResponse;
import com.myapp.helper.SuccessResponse;
import com.myapp.service.LeadService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping("/create")
    public ResponseEntity<?> createLead(@Valid @RequestBody Lead lead) {
        try {
            leadService.createLead(lead);
            return ResponseEntity.ok(new ApiResponse("success", "Created Leads Successfully"));
        } catch (LeadAlreadyExistsException e) {
            ErrorResponse errorResponse = new ErrorResponse("E10010", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("error", errorResponse));
        }
    }
    @GetMapping("/mobile/{mobileNumber}")
    public ResponseEntity<?> getLeadsByMobileNumber(@PathVariable String mobileNumber) {
        List<Lead> leads = leadService.getLeadsByMobileNumber(mobileNumber);

        if (leads.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse("E10011", "No Lead found with the Mobile Number " + mobileNumber);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } else {
            return ResponseEntity.ok(new SuccessResponse("success", leads));
        }
    }
}
