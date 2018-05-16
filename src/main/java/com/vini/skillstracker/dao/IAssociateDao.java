package com.vini.skillstracker.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.Associate;

public interface IAssociateDao extends MongoRepository<Associate, Long> {
	
	List<Associate> findByNameIgnoreCaseContaining(String name);
	
	Associate findByEmail(String email);
	
	Associate findByMobile(Long mobile);

	List<Associate> findByStrengthIgnoreCaseContaining(String strength);
}