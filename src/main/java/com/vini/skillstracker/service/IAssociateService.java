package com.vini.skillstracker.service;

import java.util.List;

import com.vini.skillstracker.dto.AssociateDTO;
import com.vini.skillstracker.dto.AssociateSkillDTO;

/**
 * AssociateService interface
 * @author Vinit Kumar
 *
 */
public interface IAssociateService {

	String addAssociate(AssociateDTO associateDTO);

	String updateAssociate(AssociateDTO associate);

	String deleteAssociate(Long associateId);

	AssociateDTO findAssociate(Long associateId);

	List<AssociateDTO> findAllAssociates();

	List<AssociateSkillDTO> findAssociateSkills(Long associateId);

}
