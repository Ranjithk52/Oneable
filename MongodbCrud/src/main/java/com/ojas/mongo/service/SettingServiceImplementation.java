package com.ojas.mongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.mongo.model.Setting;
import com.ojas.mongo.repo.SettingRepository;
@Service
public class SettingServiceImplementation implements SettingService {
	@Autowired
	private SettingRepository repository;

	@Override
	public String createSetting(Setting setting) {
		Setting set=repository.save(setting);
		if(set!=null) {
			return "Data Inserted Successfully...";
		}
		else {
		return "Data Not Inserted...try Again..";
		}
	}

	@Override
	public List<Setting> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Setting> getsettingbyId(int id) {
		
		return repository.findById(id);
	}

	@Override
	public String updateSetting(Setting setting) {
		
		Setting set= repository.save(setting);
		if(set!=null) {
			return "Data Updated Successfully...";
		}
		else {
		return "Data Not updated...try Again..";
		}
		
	}

	@Override
	public String deleteSetting(int id) {
		repository.deleteById(id);
		Optional<Setting> set=repository.findById(id);
		if(set==null) {
			return "Data Deleted..";
		}else {
			return "Data Not Deleted ...Try Again..";
		}
	}

}
