package com.vini.skillstracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vini.skillstracker.dto.AssociateDTO;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.service.IAssociateService;

/**
 * Associate Controller to handle all associate related requests
 * 
 * @author kumarv19
 *
 */
@RestController
@RequestMapping("/associate")
public class AssociateController {

	@Autowired
	private IAssociateService associateService;

	/**
	 * Add a new Associate
	 * 
	 * @param associateDTO
	 *            the associate dto
	 * @return status
	 */
	@RequestMapping(value = "/add-associate", method = RequestMethod.POST)
	public @ResponseBody String addAssociate(@RequestBody AssociateDTO associateDTO) {
		return associateService.addAssociate(associateDTO);
	}

	/**
	 * Update an Associate
	 * 
	 * @param associateDTO
	 *            the associate dto
	 * @return status
	 */
	@RequestMapping(value = "/update-associate", method = RequestMethod.POST)
	public @ResponseBody String updateAssociate(@RequestBody AssociateDTO associateDTO) {
		return associateService.updateAssociate(associateDTO);
	}

	/**
	 * find an Associate
	 * 
	 * @param associateId
	 * @return associate
	 */
	@RequestMapping(value = "/find-associate", method = RequestMethod.POST)
	public @ResponseBody AssociateDTO findAssociate(@RequestBody Long associateId) {
		return associateService.findAssociate(associateId);
	}

	/**
	 * get all associates
	 * 
	 * @return associates
	 */
	@RequestMapping(value = "/find-all-associates", method = RequestMethod.GET)
	public @ResponseBody List<AssociateDTO> findAllAssociates() {
		return associateService.findAllAssociates();
	}

	/**
	 * find an Associate skills
	 * 
	 * @param associateId
	 * @return associateSkills
	 */
	@RequestMapping(value = "/find-associate-skills", method = RequestMethod.POST)
	public @ResponseBody List<AssociateSkillDTO> findAssociateSkills(@RequestBody Long associateId) {
		return associateService.findAssociateSkills(associateId);
	}
	
	/**
	 * Delete an associate by id
	 * 
	 * @param associateId
	 *            the associate id
	 * @return status
	 */
	@RequestMapping(value = "/delete-associate", method = RequestMethod.POST)
	public @ResponseBody String deleteAssociate(@RequestBody Long associateId) {
		return associateService.deleteAssociate(associateId);
	}

}
