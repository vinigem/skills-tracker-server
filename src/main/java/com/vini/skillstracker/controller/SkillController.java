package com.vini.skillstracker.controller;

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
 * @author kumarv19
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
	 * @param skillDto
	 *            the skill dto
	 * @return status
	 */
	@RequestMapping(value = "/add-skill", method = RequestMethod.POST)
	public @ResponseBody String addSkill(@RequestBody SkillDTO skillDto) {
		return skillService.addSkill(skillDto);
	}

	/**
	 * Update an existing skill
	 * 
	 * @param skillDto
	 *            the skill dto
	 * @return status
	 */
	@RequestMapping(value = "/update-skill", method = RequestMethod.POST)
	public @ResponseBody String updateSkill(@RequestBody SkillDTO skillDto) {
		return skillService.updateSkill(skillDto);
	}

	/**
	 * Delete a skill by id
	 * 
	 * @param skillId
	 *            the skill id
	 * @return status
	 */
	@RequestMapping(value = "/delete-skill", method = RequestMethod.POST)
	public @ResponseBody String deleteSkill(@RequestBody Long skillId) {
		return skillService.deleteSkill(skillId);
	}

}
