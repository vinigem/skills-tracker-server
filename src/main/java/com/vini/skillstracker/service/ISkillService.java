package com.vini.skillstracker.service;

import java.util.List;
import java.util.Map;

import com.vini.skillstracker.dto.SkillDTO;

/**
 * SkillService interface
 * @author Vinit Kumar
 *
 */
public interface ISkillService {

	String addSkill(SkillDTO skillDTO);

	String updateSkill(SkillDTO skillDTO);

	String deleteSkill(Long skillId);

	List<SkillDTO> findAllSkills();

	Map<String, Integer> findAllSkillsCount();

}
