package com.vini.skillstracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.dao.IAssociateSkillDao;
import com.vini.skillstracker.model.AssociateSkill;
import com.vini.skillstracker.service.IAssociateSkillService;
import com.vini.skillstracker.service.ISequenceService;

@Service
public class AssociateSkillService implements IAssociateSkillService {

	@Autowired
	private IAssociateSkillDao associateSkillDao;

	@Autowired
	private ISequenceService sequenceService;

	@Override
	public boolean saveAssociateSkills(List<AssociateSkill> associateSkills) {
		boolean status = false;
		try {
			for (AssociateSkill associateSkill : associateSkills) {
				Long associateSkillId = sequenceService.getNextSequence("AssociateSkill");
				associateSkill.setId(associateSkillId);

				associateSkillDao.save(associateSkill);
			}
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
