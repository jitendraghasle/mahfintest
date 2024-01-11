package com.myapp.entity;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Lead {
    @Id
    private Integer leadId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]+$")
    private String middleName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String mobileNumber;

    @NotBlank
    private String gender;

    @NotNull
    private Date dob;

    @Email
    private String email;

	public Lead() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lead(Integer leadId, @NotBlank @Pattern(regexp = "^[a-zA-Z]+$") String firstName,
			@Pattern(regexp = "^[a-zA-Z]+$") String middleName,
			@NotBlank @Pattern(regexp = "^[a-zA-Z]+$") String lastName,
			@NotBlank @Pattern(regexp = "^[6-9]\\d{9}$") String mobileNumber, @NotBlank String gender,
			@NotBlank Date dob, @Email String email) {
		super();
		this.leadId = leadId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}

	public Integer getLeadId() {
		return leadId;
	}

	public void setLeadId(Integer leadId) {
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
