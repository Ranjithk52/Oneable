package com.ojas.spring.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.mail.internet.MimeUtility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;



import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GitApiClientExample {
	static String GitHub_Api_BASEURL = "https://api.github.com/";

	static String user = "Ranjithk52";
	static String repo = "Practice";
	
	static String path = "src/main/java/com/ojas1/Calculate.java";
	//static String path = "Patterns/Pattern.java";
	
	static String branch = "ranjith2";
	
	static String sha="caf68c88a850a503826d6982a15ab758ac9d7a8e";
	
	static String accessToken = "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";
	

	public static void main(String[] args) throws IOException {
		 //System.out.println(getGitContent());
		
		 //System.out.println(getNoOfLines());
		
		 ///System.out.println(getBranches());
		
		 //System.out.println(getTotalChanges());
		
		//System.out.println(getReviewComments());
		
		 //System.out.println(fetchCommitChanges());
		fetchCommitChanges();
	}

	static OkHttpClient client = new OkHttpClient();

	private static String getGitContent() throws IOException {

		String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/contents/" + path + "?ref=" + branch;
		Request request = new Request.Builder().url(url).header("Authorization", "Bearer" + accessToken).build();

		Response response = client.newCall(request).execute();
		System.out.println(response);
		String fileContentDecoded="";
		if (response.isSuccessful()) {
			String responseData = response.body().string();
			System.out.println(responseData);

			
			JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();
			
				String content = jsonObject.get("content").getAsString();

			//System.out.println(fileContent );
			String fileContentEncoded = content.replaceAll("[^A-Za-z0-9+/=]", "");
			//System.out.println(fileContentEncoded);
			// Decode the Base64 string
			byte[] decodedBytes = Base64.getDecoder().decode(fileContentEncoded);
			fileContentDecoded = new String(decodedBytes);
			// System.out.println("File Content:\n" + fileContentDecoded);

			
		
	}
		else {
			// System.out.println("Error: " + response.code() + " - " + response.message());
			fileContentDecoded= "Error: " + response.code() + " - " + response.message();
		}
		return fileContentDecoded;
	}
	
	private static int getNoOfLines() throws IOException {
		String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/contents/" + path + "?ref=" + branch;
		Request request = new Request.Builder().url(url).header("Authorization", "Bearer" + accessToken).build();

		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			String responseData = response.body().string();
			// System.out.println(responseData);
			JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();
			
			String content = jsonObject.get("content").getAsString();
			
			
			String fileContentEncoded = content.replaceAll("[^A-Za-z0-9+/=]", "");
			// System.out.println(fileContentEncoded+" filecontent encoded");
			// Decode the Base64 string
			byte[] decodedBytes = Base64.getDecoder().decode(fileContentEncoded);

			String fileContentDecoded = new String(decodedBytes);
			// System.out.println("File Content:\n" + fileContentDecoded);
			String[] lines = fileContentDecoded.split("\r?\n");

			// Print number of lines
			// System.out.println("Number of lines: " + lines.length);

			// process the file content as needed
			return lines.length;
		} else {
			// System.out.println("Error: " + response.code() + " - " + response.message());
			return response.code();
		}

	}

	public static List<String> getBranches() throws IOException {

	
		 List<String> brancheNames=new ArrayList<>();
		String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/branches";
		Request request = new Request.Builder().url(url).header("Authorization", "token " + accessToken).build();
		Response response = client.newCall(request).execute();
		//System.out.println(response);

		if (response.isSuccessful()) {
			String responseData = response.body().string();

			 
				JsonArray jsonArray = JsonParser.parseString(responseData).getAsJsonArray(); 
				for(JsonElement element:jsonArray) { 
			 		JsonObject jsonObject = element.getAsJsonObject();
			 		String branch = jsonObject.get("name").getAsString();
				 brancheNames.add(branch);
			 
			 }
				 }	
				return brancheNames;

		
	}

	public static int getTotalChanges() throws IOException {

		// Construct the URL for the Git API endpoint that returns the repository's //
		// commits
		String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/commits?sha=" + branch;
		// Construct an HTTP request to get the repository's commits
		Request request = new Request.Builder().url(url).header("Authorization", "token " + accessToken).build();
		// Execute the HTTP request and get the response
		Response response = client.newCall(request).execute();
		//System.out.println(response);
		// If the response was successful, deserialize the JSON response into a list of
		// // GitCommit objects
		if (response.isSuccessful()) {
			String responseData = response.body().string();
			JsonArray jsonArray = JsonParser.parseString(responseData).getAsJsonArray();
			for (JsonElement element : jsonArray) {
				JsonObject jsonObject = element.getAsJsonObject();
				String message = jsonObject.get("commit").getAsJsonObject().get("message").getAsString();
				System.out.println(message);
			}
			//System.out.println(jsonArray);
			return jsonArray.size();
		} else {
			return 0;
		}
	}

	public static List<String> getReviewComments() throws IOException {
		
		
		String url = GitHub_Api_BASEURL + "repos/" + user + "/" + repo + "/issues/comments?ref=" + branch;
		Request request = new Request.Builder().url(url).header("Authorization", "token " + accessToken).build();
		Response response = client.newCall(request).execute();
		System.out.println(response);
		List<String> comments = new ArrayList<>();
		if (response.isSuccessful()) {
			String responseData = response.body().string();
			//System.out.println(responseData);
			
			JsonArray jsonArray = JsonParser.parseString(responseData).getAsJsonArray();
			for (JsonElement j : jsonArray) {
				JsonObject jsonObject = j.getAsJsonObject();
				String message = jsonObject.getAsJsonObject().get("body").getAsString();
				System.out.println(message);
				comments.add(message);
			}
			
		} else {
			System.out.println("Error: " + response.code() + " - " + response.message());
			comments.add("Error: " + response.code() + " - " + response.message());
			
		}
		return comments;
	}
	
	public static void fetchCommitChanges() throws IOException {
		
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
		//System.out.println(responseData);
		JsonObject json=JsonParser.parseString(responseData).getAsJsonObject();
		
		JsonArray file = json.getAsJsonArray("files");
		
		 List<String> msg = new ArrayList<>();
		for (JsonElement element:file) {
	       JsonObject jsob=element.getAsJsonObject();
	        String filename = jsob.get("filename").getAsString();
	        String patch = jsob.get("patch").getAsString();
	        //System.out.println(patch);
	        if (patch.startsWith("@@")) {
	            String[] parts = patch.split("\\s+");
	            for(String p:parts) {
	            	System.out.println(p);
	            }
	            System.out.println(parts[1].substring(1));
	            String[] startLineParts = parts[1].substring(1).split(",");
	            for(int j=0;j<startLineParts.length;j++) {
	            	System.out.println(startLineParts[j]);
	            }
	            int startLine = Integer.parseInt(startLineParts[0]);
	            int numLines = 1;
	            if (startLineParts.length > 1) {
	                numLines = Integer.parseInt(startLineParts[1]);
	            }
	           // System.out.println(patch);
	            //msg.add(patch);
	            String comment = filename + " lines " + startLine + "-" + (startLine + numLines - 1);
	            System.out.println(filename + " lines " + startLine + "-" + (startLine + numLines - 1));
	            //msg.add(comment);
	        }
	    }
		
	}
}

