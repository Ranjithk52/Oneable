package com.ojas.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.mongo.model.Setting;
import com.ojas.mongo.service.SettingServiceImplementation;

@RestController
public class SettingController {
	private  SettingServiceImplementation implementation;
	
	@PostMapping("/create")
	public String createSetting(@RequestBody Setting setting) {
		
		return implementation.createSetting(setting);
		}
	

	@GetMapping("/viewAll")
	public List<Setting> getAll() {
		
		return implementation.getAll();
	}

	@GetMapping("/viewbyId")
	public Optional<Setting> getsettingbyId(int id) {
		
		return implementation.getsettingbyId(id);
	}

	@PutMapping("/update")
	public String updateSetting(Setting setting) {
		
		
		return implementation.updateSetting(setting);
		}
		


	@DeleteMapping("/delete")
	public String deleteSetting(int id) {
		
			return implementation.deleteSetting(id);
	
	}


}
