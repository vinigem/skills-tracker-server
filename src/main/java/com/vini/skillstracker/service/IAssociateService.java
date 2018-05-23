package com.vini.skillstracker.service;

import java.util.List;

import com.vini.skillstracker.dto.AssociateDTO;
import com.vini.skillstracker.dto.AssociateSkillDTO;

/**
 * AssociateService interface
 * 
 * @author Vinit Kumar
 *
 */
public interface IAssociateService {

	/**
	 * method to save associate
	 * 
	 * @param associateDTO the Associate dto
	 * @return status
	 */
	String addAssociate(AssociateDTO associateDTO);

	/**
	 * method to update associate
	 * 
	 * @param associateDTO the associate dto
	 * @return status
	 */
	String updateAssociate(AssociateDTO associate);

	/**
	 * method to delete associate
	 * 
	 * @param associateId the associate id
	 * @return status
	 */
	String deleteAssociate(Long associateId);

	/**
	 * method to find an associate
	 * 
	 * @param associateId the associate id
	 * @return associate
	 */
	AssociateDTO findAssociate(Long associateId);

	/**
	 * method to find all associate
	 * 
	 * @return associates
	 */
	List<AssociateDTO> findAllAssociates();

	/**
	 * method to find an associate skills
	 * 
	 * @param associateId the associate id
	 * @return associateSkilss
	 */
	List<AssociateSkillDTO> findAssociateSkills(Long associateId);

}
