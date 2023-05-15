package com.ojas.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ojas.spring.model.GitIntegration;
import com.ojas.spring.repository.Gitrepository;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
@RestController
@CrossOrigin("http://localhost:3000")
public class GitApiRepository {
	@Autowired
	private Gitrepository gitrepository;
 	private static final String GitHub_Api_BASEURL="https://api.github.com/";
 	
	@GetMapping("/getrepo/{id}")
	private  List<String> getRepository(@PathVariable int id) throws IOException{
		
		GitIntegration integration=gitrepository.findById(id).orElse(new GitIntegration() );
		String username=integration.getUser();
		String accesstoken=integration.getAccessToken();
		OkHttpClient client=new OkHttpClient();
		String url=GitHub_Api_BASEURL+"users/"+username+"/repos";
		Request request=new Request.Builder()
		.url(url)
		.header("Authorization", "Bearer"+accesstoken)
		.build();
		Response response=client.newCall(request).execute();
		String responsebody=response.body().string();
		JsonArray jsonArray=JsonParser.parseString(responsebody).getAsJsonArray();
		List<String> repositories=new ArrayList<String>();
		for(JsonElement element:jsonArray) {
			
			String repos=element.getAsJsonObject().get("name").getAsString();
			repositories.add(repos);
		}
		
		
		return repositories;
		
	}
	
	
	

}
