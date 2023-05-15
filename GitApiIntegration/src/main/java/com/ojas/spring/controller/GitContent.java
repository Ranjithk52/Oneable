package com.ojas.spring.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ojas.spring.model.GitIntegration;
import com.ojas.spring.repository.Gitrepository;
import com.ojas.spring.service.GitServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/gitcontent")
public class GitContent {
	
	@Autowired
	private GitServiceImpl gitServiceImpl;
	@PostMapping("/create")
	public String createRecord(@RequestBody GitIntegration integration) {
		return gitServiceImpl.createRecord(integration);
	}
	@GetMapping("/getrecord/{id}")
	public GitIntegration getRecordbyId(@PathVariable int id) {
	
		return gitServiceImpl.getRecordbyId(id);
		
	}
		
	@GetMapping("/getcode/{id}")
	public  String getGitContent(@PathVariable int id) throws IOException {
	    
		return gitServiceImpl.getGitContent(id);
	}
	 
	 
	 @GetMapping("/nooflines/{id}")
	 public  int getNoOfLines(@PathVariable int id)  throws IOException {
		 
		 return gitServiceImpl.getNoOfLines(id);
		 
	 }
	
	 
	 @GetMapping("/branches/{id}") 
	 public List<String> getBranchCount(@PathVariable int id) throws IOException {
		 
		 
		 return gitServiceImpl.getBranchCount(id);
	 }
	 
	 

	 @GetMapping("/commits/{id}") 
	public int getTotalChanges(@PathVariable int id) throws IOException {
		
		return gitServiceImpl.getTotalChanges(id);
	}
	
	 @GetMapping("/reviewcomments/{id}") 
	   public List<String> getCodeReviewComments(@PathVariable int id) throws IOException{
		
		return gitServiceImpl.getCodeReviewComments(id);
	}
	
	 @GetMapping("/changes/{id}")
	public List<String> fetchCommitChanges(@PathVariable int id) throws IOException {
		
		return gitServiceImpl.fetchCommitChanges(id);
		
	}

	
}   
	
	
	
		
	

	
		
		
		
		


	

