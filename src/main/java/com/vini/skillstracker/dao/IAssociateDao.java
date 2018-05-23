package com.vini.skillstracker.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.Associate;

/**
 * AssociateDao interface
 * @author Vinit Kumar
 *
 */
public interface IAssociateDao extends MongoRepository<Associate, String> {

	/**
	 * find an associate by associate id
	 * @param associateId the associate id
	 * @return associate
	 */
	Associate findByAssociateId(Long associateId);

	/**
	 * delete an associate by associate id
	 * @param associateId the associate id
	 */
	void deleteByAssociateId(Long associateId);
}
