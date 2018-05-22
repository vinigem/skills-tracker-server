package com.vini.skillstracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.dao.IAssociateSkillDao;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.model.AssociateSkill;
import com.vini.skillstracker.service.IAssociateSkillService;

@Service
public class AssociateSkillService implements IAssociateSkillService {

	@Autowired
	private IAssociateSkillDao associateSkillDao;

	@Override
	public boolean saveAssociateSkills(List<AssociateSkillDTO> associateSkillDTOs) {
		boolean status = false;
		try {
			for (AssociateSkillDTO associateSkillDTO : associateSkillDTOs) {
				AssociateSkill associateSkill = new AssociateSkill();

				BeanUtils.copyProperties(associateSkillDTO, associateSkill);

				associateSkillDao.save(associateSkill);
			}
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
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

}
