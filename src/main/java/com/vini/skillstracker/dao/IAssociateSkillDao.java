package com.vini.skillstracker.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.AssociateSkill;

/**
 * AssociateSkillDao interface
 * @author Vinit Kumar
 *
 */
public interface IAssociateSkillDao extends MongoRepository<AssociateSkill, String> {

	/**
	 * find an associate's skills by associate id
	 * @param associateId the associate id
	 * @return associate's skills
	 */
	List<AssociateSkill> findByAssociateId(Long associateId);

	/**
	 * delete associate's skills by associate id
	 * @param associateId the associate id
	 */
	void deleteByAssociateId(Long associateId);

}
