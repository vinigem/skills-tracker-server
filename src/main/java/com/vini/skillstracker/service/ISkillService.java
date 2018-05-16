package com.vini.skillstracker.service;

import com.vini.skillstracker.model.Skill;

public interface ISkillService {
	
	String addSkill(Skill skill);
	
	String updateSkill(Skill skill);
	
	String deleteSkill(Long skillId);

}
