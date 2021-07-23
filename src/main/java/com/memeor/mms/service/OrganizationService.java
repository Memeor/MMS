package com.memeor.mms.service;

import com.memeor.mms.beans.Organization;
import com.memeor.mms.beans.OrganizationRegistrationResponse;
import java.util.List;


public interface OrganizationService {
	public List<Organization> getAllOrganizations();
	
	public OrganizationRegistrationResponse saveOrganization(Organization organization);
	
	public boolean checkIfEmailAlreadyUsed(String emailAddress);
	
	public boolean checkIfNameAlreadyUsed(String orgName);
	

}
