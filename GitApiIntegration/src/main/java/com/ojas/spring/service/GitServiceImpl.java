package com.ojas.spring.service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import com.ojas.spring.model.GitIntegration;
import com.ojas.spring.repository.Gitrepository;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class GitServiceImpl implements GitService{
	@Autowired
	private Gitrepository gitrepository;
	private static final String GitHub_Api_BASEURL = "https://api.github.com/";
	
	public String createRecord(GitIntegration integration) {
		GitIntegration integration2=gitrepository.save(integration);
		if(integration2!=null) {
			return "Successfully Record Inserted..!";
		}else {
			return "Record not Inserted...try Again..";
		}	
	}
	
	public GitIntegration getRecordbyId(int id) {
		System.out.println(gitrepository.findById(id));
		return gitrepository.findById(id).orElse(new GitIntegration() );	
		
		
	}
	
	
		public  String getGitContent(int id) throws IOException{
			
			
			
			GitIntegration gitIntegration = getRecordbyId(id);

			System.out.println(gitIntegration);
			
		    String user = gitIntegration.getUser();
		    System.out.println(user);
	        String repo = gitIntegration.getRepo();
	        String path = gitIntegration.getPath();
	        String branch=gitIntegration.getBranchName();

	       String accessToken =gitIntegration.getAccessToken();
	        OkHttpClient client = new OkHttpClient();
	        
	        
	      //https://api.github.com/repos/{owner}/{repo}/contents/{path}?ref=branch
	        String url=GitHub_Api_BASEURL+"repos/"+user+"/"+repo+"/contents/"+path + "?ref=" + branch;
	        
	        
			Request request=new Request.Builder()
			.url(url)
			.header("Authorization", "Bearer"+accessToken)
		
			.build();

	        Response response = client.newCall(request).execute();
	        System.out.println(response);
	        if (response.isSuccessful()) {
	            String responseData = response.body().string();
	            System.out.println(responseData);
				JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();
					String content = jsonObject.get("content").getAsString();
	            String fileContentEncoded = content.replaceAll("[^A-Za-z0-9+/=]", "");
	          System.out.println(fileContentEncoded+"   file content encoded  ");
	          // Decode the Base64 string
	          byte[] decodedBytes = Base64.getDecoder().decode(fileContentEncoded);
	          
	             String fileContentDecoded = new String(decodedBytes);
	           // System.out.println("File Content:\n" + fileContentDecoded);
	            
	         
	            // process the file content as needed
	            return fileContentDecoded;
	        } else {
	            System.out.println("Error: " + response.code() + " - " + response.message());
	            return "Error: " + response.code() + " - " + response.message();
	        }
			
		}
		 
		 
	
		 public  int getNoOfLines(int id) throws IOException {
			 GitIntegration gitIntegration = getRecordbyId(id);
			    String user = gitIntegration.getUser();
		        String repo = gitIntegration.getRepo();
		        String path = gitIntegration.getPath();
		        String branch=gitIntegration.getBranchName();

		        String accessToken =gitIntegration.getAccessToken();
		        OkHttpClient client = new OkHttpClient();
		        
		        //https://api.github.com/repos/{owner}/{repo}/contents/{path}?ref=branch
		        String url=GitHub_Api_BASEURL+"repos/"+user+"/"+repo+"/contents/"+path+ "?ref=" + branch;;
				Request request=new Request.Builder()
				.url(url)
				.header("Authorization", "Bearer"+accessToken)
				.build();

		        Response response = client.newCall(request).execute();
		       
		         if (response.isSuccessful()) {
		            String responseData = response.body().string();
		            System.out.println(responseData);

		           JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();
					String content = jsonObject.get("content").getAsString();
		            String  fileContentEncoded = content.replaceAll("[^A-Za-z0-9+/=]", "");
		          System.out.println(fileContentEncoded+"  filecontent encoded");
		          // Decode the Base64 string
		          byte[] decodedBytes = Base64.getDecoder().decode(fileContentEncoded);
		         
		            
		            String fileContentDecoded = new String(decodedBytes);
		            
		            String[] lines = fileContentDecoded.split("\r?\n");

		         // Print number of lines
		         System.out.println("Number of lines: " + lines.length);
		         
		            // process the file content as needed
		            return lines.length;
		        } else {
		            System.out.println("Error: " + response.code() + " - " + response.message());
		            return response.code();
		        }
			
			}
		
		 public List<String> getBranchCount(int id) throws IOException { 
			 GitIntegration gitIntegration = getRecordbyId(id);
			 String user = gitIntegration.getUser();
		      String repo = gitIntegration.getRepo();
		       
			 String accessToken = gitIntegration.getAccessToken(); 
			 OkHttpClient client = new OkHttpClient(); 
			 List<String> brancheNames=new ArrayList<>();
			//https://api.github.com/repos/{owner}/{repo}/branches
			 String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/branches"; 
			 Request request = new Request.Builder() 
					 .url(url) 
					 .header("Authorization", "token " + accessToken) 
					 .build(); 
			 Response response = client.newCall(request).execute(); 
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				 String responseData = response.body().string(); 
			JsonArray jsonArray = JsonParser.parseString(responseData).getAsJsonArray(); 
			for(JsonElement element:jsonArray) { 
		 		JsonObject jsonObject = element.getAsJsonObject();
		 		String branch = jsonObject.get("name").getAsString();
			 brancheNames.add(branch);
		 
		 }
			 	
			return brancheNames;
		 } 
		 

		
		public int getTotalChanges(int id) throws IOException { 
			GitIntegration integration = getRecordbyId(id);
			
			 String user = integration.getUser();
		        String repo =integration.getRepo();
		        String branch=integration.getBranchName();
			String accessToken = integration.getAccessToken();
			// Create an OkHttpClient instance to make HTTP requests 
			OkHttpClient client = new OkHttpClient(); 
			// Construct the URL for the Git API endpoint that returns the repository's // commits 
			
			
			      //https://api.github.com/repos/{owner}/{repo}/commits?sha=branch;
			String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/commits?sha=" + branch;
			// Construct an HTTP request to get the repository's commits 
			Request request = new Request.Builder()
							.url(url)
							.header("Authorization", "token " + accessToken)
							.build(); 
			// Execute the HTTP request and get the response 
			Response response = client.newCall(request).execute(); 
			// If the response was successful, deserialize the JSON response into a list of // GitCommit objects 
			if (response.isSuccessful()) { 
				
				String responseData = response.body().string(); 
			JsonArray jsonArray = JsonParser.parseString(responseData).getAsJsonArray(); 
			for(JsonElement element:jsonArray) { 
			JsonObject jsonObject = element.getAsJsonObject();
			String message = jsonObject.get("commit").getAsJsonObject().get("message").getAsString();
				//System.out.println(message);
				
				} 
			//System.out.println(jsonArray); 
			
			return jsonArray.size(); 
			} else { 
				return 0; 
				} 
			}
		
		
		   public List<String> getCodeReviewComments(int id) throws IOException{
			   GitIntegration integration = getRecordbyId(id);

				 String user = integration.getUser();
			        String repo =integration.getRepo();
				String accessToken = integration.getAccessToken();
				String branch=integration.getBranchName();
				OkHttpClient client = new OkHttpClient();
				
				//https://api.github.com/repos/{owner}/{repo}/issues/comments?ref={branch};
				 String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/issues/comments?ref=" + branch;

				 Request request = new Request.Builder() 
						 .url(url) 
						 .header("Authorization", "token " + accessToken) 
						 .build(); 
				 
				 Response response = client.newCall(request).execute(); 
				 //System.out.println(response);
				List<String> msg=new ArrayList<>();
				 if (response.isSuccessful()) { 
			    String responseData = response.body().string(); 
			    JsonArray jsonArray = JsonParser.parseString(responseData).getAsJsonArray(); 
	 		for(JsonElement j:jsonArray) { 
	 		JsonObject jsonObject = j.getAsJsonObject();
	 		String message = jsonObject.getAsJsonObject().get("body").getAsString();
	 		msg.add(message);
	 			System.out.println(message);
	 			
						} 
			    return msg;
		 }else {
	      System.out.println("Error: " + response.code() + " - " + response.message());
	      return null;
	  }

		   }
		
		
		public List<String> fetchCommitChanges(int id) throws IOException {
			GitIntegration integration = getRecordbyId(id);
		    String user = integration.getUser();
		    String repo = integration.getRepo();
		    String accessToken = integration.getAccessToken();
		    String sha = integration.getSha();
		    String branch = integration.getBranchName();
		    OkHttpClient client = new OkHttpClient();

		    //https://api.github.com/repos/{owner}/{repo}/commits/{sha}
		    String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/commits/" + sha;
		    if (branch != null && !branch.isEmpty()) {
		        url += "?sha=" + branch;
		    }

		    Request request = new Request.Builder()
		            .url(url)
		            .addHeader("Authorization", "Bearer " + accessToken)
		            .build();
		    Response response = client.newCall(request).execute();
		    String responseData = response.body().string();
		  JsonObject json=JsonParser.parseString(responseData).getAsJsonObject();
		  JsonArray files=json.get("files").getAsJsonArray();
		   
		    List<String> msg = new ArrayList<>();
		   
		    for(JsonElement element:files) {
		    	
		    	JsonObject jobj=element.getAsJsonObject();
		        String filename = jobj.get("filename").getAsString();
		        String patch = jobj.get("patch").getAsString();
		        if (patch.startsWith("@@")) {
		            String[] parts = patch.split("\\s+");
		            String[] startLineParts = parts[1].substring(1).split(",");
		            int startLine = Integer.parseInt(startLineParts[0]);
		            int numLines = 1;
		            if (startLineParts.length > 1) {
		                numLines = Integer.parseInt(startLineParts[1]);
		            }else {
		            	numLines=1;
		            }
		            //System.out.println(patch);
		            msg.add(patch);
		            String comment = filename + " lines " + startLine + "-" + (startLine + numLines - 1);
		            //System.out.println(filename + " lines " + startLine + "-" + (startLine + numLines - 1));
		            msg.add(comment);
		            
		        }
		    }
		    return msg;
		}

		
	
}
