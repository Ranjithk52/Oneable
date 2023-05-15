package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Organization;
import com.example.demo.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/get/{id}")
   public Optional<Organization> getbyid(@PathVariable String id){
    	
    	return organizationService.getOrganizationById(id);
    	
    }

    @PostMapping("/create")
    public String create(@RequestBody Organization organizationDto) {
        Organization createdOrganization = organizationService.createOrganization(organizationDto);
        if(createdOrganization!=null) {
        	return "Created Successfullyy...";
        }else {
        	return "Not Created..try Again..";
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Organization> update(@PathVariable("id") String id, @RequestBody Organization organizationDto) {
        Organization updatedOrganization = organizationService.updateOrganization(organizationDto);
        if (updatedOrganization != null) {
            return ResponseEntity.ok(updatedOrganization);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        boolean deleted = organizationService.deleteOrganizationById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

