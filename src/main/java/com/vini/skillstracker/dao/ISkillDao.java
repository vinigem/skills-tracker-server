package com.vini.skillstracker.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.Skill;

/**
 * SkillDao interface
 * @author Vinit Kumar
 *
 */
public interface ISkillDao extends MongoRepository<Skill, String> {

	void deleteBySkillId(Long skillId);

}
