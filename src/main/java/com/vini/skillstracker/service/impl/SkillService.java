package com.vini.skillstracker.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	public String addSkill(SkillDTO skillDTO) {
		String status = null;
		try {

			Skill skill = new Skill();
			BeanUtils.copyProperties(skillDTO, skill);

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
	public String updateSkill(SkillDTO skillDTO) {
		String status = null;
		try {

			Skill skill = new Skill();
			BeanUtils.copyProperties(skillDTO, skill);

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
			skillDao.deleteBySkillId(skillId);
			status = AppConstant.SUCCESS;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	@Override
	public List<SkillDTO> findAllSkills() {
		List<SkillDTO> skillDTOList = new ArrayList<>();
		try {
			List<Skill> skills = skillDao.findAll();

			for (Skill skill : skills) {
				SkillDTO skillDTO = new SkillDTO();
				BeanUtils.copyProperties(skill, skillDTO);
				skillDTOList.add(skillDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return skillDTOList;
	}

}
