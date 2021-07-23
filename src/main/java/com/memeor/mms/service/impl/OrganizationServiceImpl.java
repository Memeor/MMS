package com.memeor.mms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memeor.mms.beans.OrganizationRegistrationResponse;
import com.memeor.mms.beans.RegistrationStatus;
import com.memeor.mms.repository.OrganizationRepository;
import com.memeor.mms.service.OrganizationService;
import com.memeor.mms.beans.Organization;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@Autowired
	OrganizationRegistrationResponse organizationRegistrationResponse;
	
	@Override
	public List<Organization> getAllOrganizations(){
		List<Organization> result = new ArrayList<Organization>();
		organizationRepository.findAll().forEach(result::add);
		
		return result;
	}

	@Override
	public OrganizationRegistrationResponse saveOrganization(Organization organization) {
		// TODO Auto-generated method stub
		boolean emailExists = checkIfEmailAlreadyUsed(organization.getEmail());
		boolean nameExists = checkIfNameAlreadyUsed(organization.getOrgName());
		
		try {
			if(!emailExists) {
				if(!nameExists) {
					organizationRepository.save(organization);
					organizationRegistrationResponse.setStatus(RegistrationStatus.ACCEPTED);
				}
				else {
					organizationRegistrationResponse.setStatus(RegistrationStatus.FAILED);
				}
			}
			else {
				if(!nameExists) {
					organizationRegistrationResponse.setStatus(RegistrationStatus.ACCEPTED);
				}
				else {
					organizationRegistrationResponse.setStatus(RegistrationStatus.FAILED);
					
				}
			}
			
			
			
		}catch(Exception e) {
			log.info("Error in database when trying to insert "+ organization.toString());
		}
		
		return organizationRegistrationResponse;
		//TODO: send email
	} 

	@Override
	public boolean checkIfEmailAlreadyUsed(String orgName) {
		// TODO Auto-generated method stub
		return organizationRepository.checkIfNameAlreadyUsed(orgName);
	}

	@Override
	public boolean checkIfNameAlreadyUsed(String emailAddress) {
		// TODO Auto-generated method stub
		return organizationRepository.checkIfEmailAlreadyUsed(emailAddress);
	}
}
