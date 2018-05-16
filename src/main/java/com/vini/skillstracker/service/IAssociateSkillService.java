package com.vini.skillstracker.service;

import java.util.List;

import com.vini.skillstracker.model.AssociateSkill;

public interface IAssociateSkillService {
	
	boolean saveAssociateSkills(List<AssociateSkill> associateSkills);
	
}
