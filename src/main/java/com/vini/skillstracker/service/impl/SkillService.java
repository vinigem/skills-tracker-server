package com.vini.skillstracker.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.AppConstant;
import com.vini.skillstracker.dao.ISkillDao;
import com.vini.skillstracker.dto.SkillDTO;
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
	public String addSkill(SkillDTO skillDto) {
		String status = null;
		try {

			Skill skill = new Skill();
			BeanUtils.copyProperties(skillDto, skill);

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
	public String updateSkill(SkillDTO skillDto) {
		String status = null;
		try {

			Skill skill = new Skill();
			BeanUtils.copyProperties(skillDto, skill);

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
