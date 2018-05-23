package com.vini.skillstracker.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.dao.IAssociateSkillDao;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.model.AssociateSkill;
import com.vini.skillstracker.service.IAssociateSkillService;

/**
 * AssociatSkilleService implementation
 * @author Vinit Kumar
 *
 */
@Service
public class AssociateSkillService implements IAssociateSkillService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssociateSkillService.class.getName());

	@Autowired
	private IAssociateSkillDao associateSkillDao;

	@Override
	public boolean saveAssociateSkills(List<AssociateSkillDTO> associateSkillDTOs) {
		boolean status = false;
		try {
			for (AssociateSkillDTO associateSkillDTO : associateSkillDTOs) {
				AssociateSkill associateSkill = new AssociateSkill();

				BeanUtils.copyProperties(associateSkillDTO, associateSkill);

				if (associateSkill.getId() != null && associateSkill.getValue() == 0) {
					associateSkillDao.delete(associateSkill);
				} else {
					associateSkillDao.save(associateSkill);
				}
			}
			status = true;
		} catch (Exception e) {
			LOGGER.error("Error while saving associate skills.\n{}", e);
			status = false;
		}
		return status;
	}

	@Override
	public List<AssociateSkillDTO> findAssociateSkills(Long associateId) {
		List<AssociateSkillDTO> associateSkillDTOs = new ArrayList<AssociateSkillDTO>();

		List<AssociateSkill> associateSkills = associateSkillDao.findByAssociateId(associateId);

		for (AssociateSkill associateSkill : associateSkills) {
			AssociateSkillDTO associateSkillDTO = new AssociateSkillDTO();
			BeanUtils.copyProperties(associateSkill, associateSkillDTO);
			associateSkillDTOs.add(associateSkillDTO);
		}

		return associateSkillDTOs;
	}

	@Override
	public boolean deleteAssociateSkills(Long associateId) {
		boolean status = false;
		try {
			associateSkillDao.deleteByAssociateId(associateId);
			status = true;
		} catch (Exception e) {
			LOGGER.error("Error while deleting associate skills.\n{}", e);
			status = false;
		}
		return status;
	}

	@Override
	public List<AssociateSkillDTO> findAllAssociateSkills() {
		List<AssociateSkillDTO> associateSkillDTOs = new ArrayList<>();
		try {
			List<AssociateSkill> associateSkills = associateSkillDao.findAll();

			for (AssociateSkill associateSkill : associateSkills) {
				AssociateSkillDTO associateSkillDTO = new AssociateSkillDTO();
				BeanUtils.copyProperties(associateSkill, associateSkillDTO);
				associateSkillDTOs.add(associateSkillDTO);
			}
		} catch (Exception e) {
			LOGGER.error("Error while fetching all associate skills. \n{}", e);
		}
		return associateSkillDTOs;
	}

}
