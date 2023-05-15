package com.ojas.mongo.service;

import java.util.List;
import java.util.Optional;

import com.ojas.mongo.model.Setting;

public interface SettingService {
	
	public String createSetting(Setting setting);
	public List<Setting> getAll();
	public Optional<Setting> getsettingbyId(int id);
	public String updateSetting(Setting setting);
	public String deleteSetting(int id);

}
