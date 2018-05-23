package com.vini.skillstracker.service;

import java.util.List;

import com.vini.skillstracker.dto.AssociateSkillDTO;

public interface IAssociateSkillService {

	boolean saveAssociateSkills(List<AssociateSkillDTO> associateSkillDTOs);

	List<AssociateSkillDTO> findAssociateSkills(Long associateId);

	boolean deleteAssociateSkills(Long associateId);

}
