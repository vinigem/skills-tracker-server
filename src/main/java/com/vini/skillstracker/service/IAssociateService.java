package com.vini.skillstracker.service;

import java.util.List;

import com.vini.skillstracker.dto.AssociateDTO;
import com.vini.skillstracker.dto.AssociateSkillDTO;

public interface IAssociateService {

	String addAssociate(AssociateDTO associateDTO);

	String updateAssociate(AssociateDTO associate);

	String deleteAssociate(Long associateId);

	AssociateDTO findAssociate(Long associateId);

	List<AssociateDTO> findAllAssociates();

	List<AssociateDTO> searchByName(String name);

	List<AssociateDTO> searchByStrongSkills(String skillName);

	AssociateDTO searchByMobile(Long mobile);

	AssociateDTO searchByEmail(String email);

	List<AssociateSkillDTO> findAssociateSkills(Long associateId);

}
