package com.memeor.mms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memeor.mms.beans.Organization;
import com.memeor.mms.service.OrganizationService;
import com.memeor.mms.beans.OrganizationRegistrationResponse;
import com.memeor.mms.beans.RegistrationStatus;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;
	
	
	
	//get all organizations
	//Note: should be able to access by super admin only in future
	@GetMapping("")
	public List<Organization> getAllOrganization(){
		
		return organizationService.getAllOrganizations();
		
		
	}
	
	//Register a new organization
	@PostMapping("")
	public ResponseEntity<OrganizationRegistrationResponse> addOrganization(@RequestBody Organization organization){
		OrganizationRegistrationResponse organizationRegistrationResponse = organizationService.saveOrganization(organization);
		if(organizationRegistrationResponse.getStatus().equals(RegistrationStatus.ACCEPTED))
			return new ResponseEntity<>(organizationRegistrationResponse, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(organizationRegistrationResponse, HttpStatus.CONFLICT);
		
	
		
	}
	

}
