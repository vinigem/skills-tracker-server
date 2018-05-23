package com.vini.skillstracker.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.Skill;

/**
 * SkillDao interface
 * @author Vinit Kumar
 *
 */
public interface ISkillDao extends MongoRepository<Skill, String> {

	/**
	 * delete skill by skill id
	 * @param skillId the skill id
	 */
	void deleteBySkillId(Long skillId);

}
