package com.vini.skillstracker.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.AssociateSkill;

public interface IAssociateSkillDao extends MongoRepository<AssociateSkill, Long> {
	
	List<AssociateSkill> findByAssociateId(Long associateId);
		
}
