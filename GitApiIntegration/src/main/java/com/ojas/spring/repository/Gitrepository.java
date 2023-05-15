package com.ojas.spring.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ojas.spring.model.GitIntegration;
@Repository
public interface Gitrepository extends MongoRepository<GitIntegration, Integer>{

}
