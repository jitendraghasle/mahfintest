package com.myapp.helper;
import java.util.List;

import com.myapp.entity.Lead;

public class SuccessResponse {

    private String status;
    private List<Lead> data;

    // Constructors, getters, and setters

    // Constructors
    public SuccessResponse() {
        // Default constructor (required by Jackson for JSON serialization)
    }

    public SuccessResponse(String status, List<Lead> data) {
        this.status = status;
        this.data = data;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Lead> getData() {
        return data;
    }

    public void setData(List<Lead> data) {
        this.data = data;
    }
}
