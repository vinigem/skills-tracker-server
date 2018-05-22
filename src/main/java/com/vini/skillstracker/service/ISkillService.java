package com.vini.skillstracker.service;

import java.util.List;

import com.vini.skillstracker.dto.SkillDTO;

public interface ISkillService {

	String addSkill(SkillDTO skillDTO);

	String updateSkill(SkillDTO skillDTO);

	String deleteSkill(Long skillId);

	List<SkillDTO> findAllSkills();

}
