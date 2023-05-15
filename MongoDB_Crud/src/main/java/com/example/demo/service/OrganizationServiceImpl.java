package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Organization;
import com.example.demo.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Optional<Organization> getOrganizationById(String id) {
        return organizationRepository.findById(id);
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public boolean deleteOrganizationById(String id) {
        organizationRepository.deleteById(id);
        Optional<Organization> org=organizationRepository.findById(id);
        if(org==null) {
        	return true;
        }else {
		return false;
        }
        }

    @Override
    public Organization updateOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }
}

