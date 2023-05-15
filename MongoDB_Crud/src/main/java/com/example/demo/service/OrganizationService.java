package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Organization;

public interface OrganizationService {
	
	public List<Organization> getAllOrganizations();
	 public Optional<Organization> getOrganizationById(String id);
	public Organization createOrganization(Organization organization);
	public boolean deleteOrganizationById(String id);
	public Organization updateOrganization(Organization organization);

}
