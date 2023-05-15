package com.example.demo.model;

import java.util.Date;

public class PmTool {
    private String toolName;
    private String url;
    private String username;
    private String apiToken;
    private boolean isActive;
    private String connectionName;
    private Date createdDate;
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getConnectionName() {
		return connectionName;
	}
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
    
}
