package com.ojas.mongo.model;

import java.sql.Date;

public class Tools {

	private String toolName;
	private String url;
	private String userName;
	private String apiToken;
	private boolean isActive;
	private String connectionName;
	private Date createdDate;
//	private String _class;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
//	public String get_class() {
//		return _class;
//	}
//	public void set_class(String _class) {
//		this._class = _class;
//	}
	public Tools(String toolName, String url, String userName, String apiToken, boolean isActive, String connectionName,
			Date createdDate) {
		super();
		this.toolName = toolName;
		this.url = url;
		this.userName = userName;
		this.apiToken = apiToken;
		this.isActive = isActive;
		this.connectionName = connectionName;
		this.createdDate = createdDate;
//		this._class = _class;
	}
	public Tools() {
		
	}
	
}
