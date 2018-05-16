package com.vini.skillstracker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.AppConstant;
import com.vini.skillstracker.dao.ISkillDao;
import com.vini.skillstracker.model.Skill;
import com.vini.skillstracker.service.ISequenceService;
import com.vini.skillstracker.service.ISkillService;

@Service
public class SkillService implements ISkillService {

	@Autowired
	private ISequenceService sequenceService;

	@Autowired
	private ISkillDao skillDao;

	@Override
	public String addSkill(Skill skill) {
		String status = null;
		try {
			Long skillId = sequenceService.getNextSequence("Skill");
			skill.setSkillId(skillId);

			skillDao.save(skill);
			status = AppConstant.SUCCESS;

		} catch (DuplicateKeyException de) {
			status = AppConstant.EXIST;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	@Override
	public String updateSkill(Skill skill) {
		String status = null;
		try {
			skillDao.save(skill);
			status = AppConstant.SUCCESS;

		} catch (DuplicateKeyException de) {
			status = AppConstant.EXIST;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	@Override
	public String deleteSkill(Long skillId) {
		String status = null;
		try {
			skillDao.delete(skillId);
			status = AppConstant.SUCCESS;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

}
