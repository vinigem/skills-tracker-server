package com.vini.skillstracker.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.CustomSequences;

public interface ISequenceDao extends MongoRepository<CustomSequences, String> {

}
