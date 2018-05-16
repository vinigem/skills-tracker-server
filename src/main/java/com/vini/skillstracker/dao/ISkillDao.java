package com.vini.skillstracker.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vini.skillstracker.model.Skill;

public interface ISkillDao extends MongoRepository<Skill, Long> {

}
