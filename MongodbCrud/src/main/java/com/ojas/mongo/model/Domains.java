package com.ojas.mongo.model;

public class Domains {
	private String domain;
	private Data data;
	private String type;
	//private String _class;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
//	public String get_class() {
//		return _class;
//	}
//	public void set_class(String _class) {
//		this._class = _class;
//	}
	public Domains(String domain, Data data, String type) {
		super();
		this.domain = domain;
		this.data = data;
		this.type = type;
		//this._class = _class;
	}
	public Domains() {
		
	}

}
