package com.vini.skillstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vini.skillstracker.dto.AssociateDTO;
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
	public @ResponseBody String addSkill(@RequestBody AssociateDTO associateDTO) {
		return associateService.addAssociate(associateDTO);
	}

	

}
