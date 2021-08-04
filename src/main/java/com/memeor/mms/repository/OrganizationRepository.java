package com.memeor.mms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.memeor.mms.beans.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer>{
	
	@Query("select count(*) = 1 from organizations where name = :orgName")
	public Boolean checkIfNameAlreadyUsed(String orgName);
	
	@Query("select count(*) =1 from organizations where email = :emailAddress")
	public Boolean checkIfEmailAlreadyUsed( String emailAddress);

}
