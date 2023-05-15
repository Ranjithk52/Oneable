package com.ojas.spring.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;

@Document
@Builder
public class GitIntegration {
	
	private int id;
	private   String user;
	private  String repo;
	private  String path ;
	private  String accessToken ;
	private String branchName;
	private String sha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getRepo() {
		return repo;
	}
	public void setRepo(String repo) {
		this.repo = repo;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	public GitIntegration() {
		
	}
	
	
	public GitIntegration(int id, String user, String repo, String path, String accessToken, String branchName,
			String sha) {
		super();
		this.id = id;
		this.user = user;
		this.repo = repo;
		this.path = path;
		this.accessToken = accessToken;
		this.branchName = branchName;
		this.sha = sha;
	}
	@Override
	public String toString() {
		return "GitIntegration [id=" + id + ", user=" + user + ", repo=" + repo + ", path=" + path + ", accessToken="
				+ accessToken + ", branchName=" + branchName + ", sha=" + sha + "]";
	}
	
	
	

}
