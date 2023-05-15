package com.ojas.mongo.model;


public class Data {
	private String trustStore;
	private String serverProtocol;
	private String serverAddress;
	private String serverPort;
	private String securityPrincipal;
	private String baseName;
	private String authenticationAttribute;
	private String securityCredentials;
	private String managerCNAttribute;
	private String userObjectClass;
	private String firstNameAttribute;
	private String lastNameAttribute;
	private String photoAttribute;
	private String emailAttribute;
	private String employeeIdAttribute;
	private String titleAttribute;
	private String departmentIdAttribute;
//	private String _class;
	public Data() {
		
	}
	
	public Data(String trustStore, String serverProtocol, String serverAddress, String serverPort,
			String securityPrincipal, String baseName, String authenticationAttribute, String securityCredentials,
			String managerCNAttribute, String userObjectClass, String firstNameAttribute, String lastNameAttribute,
			String photoAttribute, String emailAttribute, String employeeIdAttribute, String titleAttribute,
			String departmentIdAttribute) {
		super();
		this.trustStore = trustStore;
		this.serverProtocol = serverProtocol;
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		this.securityPrincipal = securityPrincipal;
		this.baseName = baseName;
		this.authenticationAttribute = authenticationAttribute;
		this.securityCredentials = securityCredentials;
		this.managerCNAttribute = managerCNAttribute;
		this.userObjectClass = userObjectClass;
		this.firstNameAttribute = firstNameAttribute;
		this.lastNameAttribute = lastNameAttribute;
		this.photoAttribute = photoAttribute;
		this.emailAttribute = emailAttribute;
		this.employeeIdAttribute = employeeIdAttribute;
		this.titleAttribute = titleAttribute;
		this.departmentIdAttribute = departmentIdAttribute;
//		this._class = _class;
	}
	public String getTrustStore() {
		return trustStore;
	}
	public void setTrustStore(String trustStore) {
		this.trustStore = trustStore;
	}
	public String getServerProtocol() {
		return serverProtocol;
	}
	public void setServerProtocol(String serverProtocol) {
		this.serverProtocol = serverProtocol;
	}
	public String getServerAddress() {
		return serverAddress;
	}
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public String getSecurityPrincipal() {
		return securityPrincipal;
	}
	public void setSecurityPrincipal(String securityPrincipal) {
		this.securityPrincipal = securityPrincipal;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getAuthenticationAttribute() {
		return authenticationAttribute;
	}
	public void setAuthenticationAttribute(String authenticationAttribute) {
		this.authenticationAttribute = authenticationAttribute;
	}
	public String getSecurityCredentials() {
		return securityCredentials;
	}
	public void setSecurityCredentials(String securityCredentials) {
		this.securityCredentials = securityCredentials;
	}
	public String getManagerCNAttribute() {
		return managerCNAttribute;
	}
	public void setManagerCNAttribute(String managerCNAttribute) {
		this.managerCNAttribute = managerCNAttribute;
	}
	public String getUserObjectClass() {
		return userObjectClass;
	}
	public void setUserObjectClass(String userObjectClass) {
		this.userObjectClass = userObjectClass;
	}
	public String getFirstNameAttribute() {
		return firstNameAttribute;
	}
	public void setFirstNameAttribute(String firstNameAttribute) {
		this.firstNameAttribute = firstNameAttribute;
	}
	public String getLastNameAttribute() {
		return lastNameAttribute;
	}
	public void setLastNameAttribute(String lastNameAttribute) {
		this.lastNameAttribute = lastNameAttribute;
	}
	public String getPhotoAttribute() {
		return photoAttribute;
	}
	public void setPhotoAttribute(String photoAttribute) {
		this.photoAttribute = photoAttribute;
	}
	public String getEmailAttribute() {
		return emailAttribute;
	}
	public void setEmailAttribute(String emailAttribute) {
		this.emailAttribute = emailAttribute;
	}
	public String getEmployeeIdAttribute() {
		return employeeIdAttribute;
	}
	public void setEmployeeIdAttribute(String employeeIdAttribute) {
		this.employeeIdAttribute = employeeIdAttribute;
	}
	public String getTitleAttribute() {
		return titleAttribute;
	}
	public void setTitleAttribute(String titleAttribute) {
		this.titleAttribute = titleAttribute;
	}
	public String getDepartmentIdAttribute() {
		return departmentIdAttribute;
	}
	public void setDepartmentIdAttribute(String departmentIdAttribute) {
		this.departmentIdAttribute = departmentIdAttribute;
	}
//	public String get_class() {
//		return _class;
//	}
//	public void set_class(String _class) {
//		this._class = _class;
//	}
	
	
	
}
