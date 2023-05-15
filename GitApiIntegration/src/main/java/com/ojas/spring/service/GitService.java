package com.ojas.spring.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;


import com.ojas.spring.model.GitIntegration;

public interface GitService {
	
	public String createRecord(GitIntegration integration);
	public GitIntegration getRecordbyId(int id);
	public  String getGitContent(int id) throws IOException;
	public  int getNoOfLines(int id) throws IOException;
	public List<String> getBranchCount(int id) throws IOException;
	public int getTotalChanges(int id) throws IOException;
	public List<String> getCodeReviewComments(int id) throws IOException;
	public List<String> fetchCommitChanges(int id) throws IOException;
}
