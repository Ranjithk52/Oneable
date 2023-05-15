package com.example.demo.model;


import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "CrudOrganization")
public class Organization {
    
    private String _id;
    private String name;
    private String address;
    private String phoneNumber;
    private List<String> modules;
    private Date createdDate;
    private Date modifiedTime;
    private boolean isActive;
    private Settings settings;
    
    public String get_id() {
        return _id;				
    }
    
    public void set_id(String _id) {
        this._id = _id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public List<String> getModules() {
        return modules;
    }
    
    public void setModules(List<String> modules) {
        this.modules = modules;
    }
    
    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public Date getModifiedTime() {
        return modifiedTime;
    }
    
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public Settings getSettings() {
        return settings;
    }
    
    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}