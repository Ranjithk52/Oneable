package com.ojas.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ojas.mongo.model.Setting;
@Repository
public interface SettingRepository extends MongoRepository<Setting, Integer> {

}
