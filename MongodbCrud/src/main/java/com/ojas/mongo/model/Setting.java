package com.ojas.mongo.model;

import java.util.List;

public class Setting {
	private List<Domains> domains;
	private Session sessionrecording;
	private List<Tools> pmTools;
	public List<Domains> getDomains() {
		return domains;
	}
	public void setDomains(List<Domains> domains) {
		this.domains = domains;
	}
	public Session getSessionrecording() {
		return sessionrecording;
	}
	public void setSessionrecording(Session sessionrecording) {
		this.sessionrecording = sessionrecording;
	}
	public List<Tools> getPmTools() {
		return pmTools;
	}
	public void setPmTools(List<Tools> pmTools) {
		this.pmTools = pmTools;
	}
	public Setting(List<Domains> domains, Session sessionrecording, List<Tools> pmTools) {
		super();
		this.domains = domains;
		this.sessionrecording = sessionrecording;
		this.pmTools = pmTools;
	}
	public Setting() {
		
	}

}
