package com.vini.skillstracker.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.model.CustomSequences;
import com.vini.skillstracker.service.ISequenceService;

/**
 * SequenceService implementation
 * @author Vinit Kumar
 *
 */
@Service
public class SequenceService implements ISequenceService {

	@Autowired
	private MongoOperations mongo;

	/**
	 * update and return new sequence
	 */
	public Long getNextSequence(String seqName) {
		CustomSequences sequences = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), CustomSequences.class);
		return sequences.getSeq();
	}

}
