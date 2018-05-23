package com.vini.skillstracker.service;

import java.util.List;
import java.util.Map;

import com.vini.skillstracker.dto.SkillDTO;

/**
 * SkillService interface
 * 
 * @author Vinit Kumar
 *
 */
public interface ISkillService {

	/**
	 * method to add skill
	 * 
	 * @param skillDTO the skill dto
	 * @return status
	 */
	String addSkill(SkillDTO skillDTO);

	/**
	 * method to update skill
	 * 
	 * @param skillDTO the skill dto
	 * @return status
	 */
	String updateSkill(SkillDTO skillDTO);

	/**
	 * method to delete skill
	 * 
	 * @param skillId the skill id
	 * @return status
	 */
	String deleteSkill(Long skillId);

	/**
	 * method find all skills
	 * 
	 * @return skills
	 */
	List<SkillDTO> findAllSkills();

	/**
	 * method to find all skills count data
	 * 
	 * @return skillsCountData
	 */
	Map<String, Integer> findAllSkillsCount();

}
