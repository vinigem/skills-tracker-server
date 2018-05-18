package com.vini.skillstracker.service;

import com.vini.skillstracker.dto.SkillDTO;

public interface ISkillService {
	
	String addSkill(SkillDTO skillDto);
	
	String updateSkill(SkillDTO skillDto);
	
	String deleteSkill(Long skillDto);

}
