package com.vini.skillstracker.service;

import java.util.List;
import com.vini.skillstracker.dto.AssociateSkillDTO;

/**
 * AssociateSkillService interface
 * 
 * @author Vinit Kumar
 *
 */
public interface IAssociateSkillService {

	/**
	 * method to save an associate skills
	 * 
	 * @param associateSkillDTOs the associate skill dtos
	 * @return status
	 */
	boolean saveAssociateSkills(List<AssociateSkillDTO> associateSkillDTOs);

	/**
	 * method to find an associate skills
	 * 
	 * @param associateId the associate id
	 * @return skills
	 */
	List<AssociateSkillDTO> findAssociateSkills(Long associateId);

	/**
	 * method to delete an associate skills
	 * 
	 * @param associateId the associate id
	 * @return status
	 */
	boolean deleteAssociateSkills(Long associateId);

	/**
	 * method to find all associate's skills
	 * 
	 * @return skills
	 */
	List<AssociateSkillDTO> findAllAssociateSkills();

}
