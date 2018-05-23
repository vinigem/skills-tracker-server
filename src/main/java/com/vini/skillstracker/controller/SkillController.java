package com.vini.skillstracker.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vini.skillstracker.dto.SkillDTO;
import com.vini.skillstracker.service.ISkillService;

/**
 * Skill Controller to handle all skill related requests
 * 
 * @author Vinit Kumar
 *
 */
@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private ISkillService skillService;

	/**
	 * Add a new skill
	 * 
	 * @param skillDto the skill dto
	 * @return status
	 */
	@RequestMapping(value = "/add-skill", method = RequestMethod.POST)
	public @ResponseBody String addSkill(@RequestBody SkillDTO skillDTO) {
		return skillService.addSkill(skillDTO);
	}

	/**
	 * Update an existing skill
	 * 
	 * @param skillDto the skill dto
	 * @return status
	 */
	@RequestMapping(value = "/update-skill", method = RequestMethod.POST)
	public @ResponseBody String updateSkill(@RequestBody SkillDTO skillDTO) {
		return skillService.updateSkill(skillDTO);
	}

	/**
	 * Delete a skill by id
	 * 
	 * @param skillId the skill id
	 * @return status
	 */
	@RequestMapping(value = "/delete-skill", method = RequestMethod.POST)
	public @ResponseBody String deleteSkill(@RequestBody Long skillId) {
		return skillService.deleteSkill(skillId);
	}

	/**
	 * get all skills
	 * 
	 * @return skills
	 */
	@RequestMapping(value = "/find-all-skills", method = RequestMethod.GET)
	public @ResponseBody List<SkillDTO> findAllSkills() {
		return skillService.findAllSkills();
	}
	
	/**
	 * get all skills count
	 * 
	 * @return skillsCount
	 */
	@RequestMapping(value = "/find-all-skills-count", method = RequestMethod.GET)
	public @ResponseBody Map<String, Integer> findAllSkillsCount() {
		return skillService.findAllSkillsCount();
	}

}
