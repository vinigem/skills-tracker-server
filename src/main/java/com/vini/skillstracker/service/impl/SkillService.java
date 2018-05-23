package com.vini.skillstracker.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.AppConstant;
import com.vini.skillstracker.dao.ISkillDao;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.dto.SkillDTO;
import com.vini.skillstracker.model.Skill;
import com.vini.skillstracker.service.IAssociateSkillService;
import com.vini.skillstracker.service.ISequenceService;
import com.vini.skillstracker.service.ISkillService;

/**
 * SkillService implementation
 * 
 * @author Vinit Kumar
 *
 */
@Service
public class SkillService implements ISkillService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssociateSkillService.class.getName());

	@Autowired
	private ISequenceService sequenceService;

	@Autowired
	private ISkillDao skillDao;

	@Autowired
	private IAssociateSkillService associateSkillService;

	/**
	 * method to add skill
	 * 
	 * @param skillDTO the skill dto
	 * @return status
	 */
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
			LOGGER.error("Skill alread exist. {}, {}", skillDTO, de);

		} catch (Exception e) {
			status = AppConstant.FAILURE;
			LOGGER.error("Error while saving Skill.\n {}", e);
		}
		return status;
	}

	/**
	 * method to update skill
	 * 
	 * @param skillDTO the skill dto
	 * @return status
	 */
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
			LOGGER.error("Skill alread exist. {}, {}", skillDTO, de);

		} catch (Exception e) {
			status = AppConstant.FAILURE;
			LOGGER.error("Error while updating Skill.\n {}", e);
		}
		return status;
	}

	/**
	 * method to delete skill
	 * 
	 * @param skillId the skill id
	 * @return status
	 */
	@Override
	public String deleteSkill(Long skillId) {
		String status = null;
		try {
			skillDao.deleteBySkillId(skillId);
			status = AppConstant.SUCCESS;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
			LOGGER.error("Error while deleting Skill.\n {}", e);
		}
		return status;
	}

	/**
	 * method find all skills
	 * 
	 * @return skills
	 */
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
			LOGGER.error("Error while fetching all Skill.\n {}", e);
		}
		return skillDTOList;
	}

	/**
	 * method to find all skills count data
	 * 
	 * @return skillsCountData
	 */
	@Override
	public Map<String, Integer> findAllSkillsCount() {
		Map<String, Integer> skillsCount = new HashMap<String, Integer>();

		List<SkillDTO> skills = findAllSkills();
		List<AssociateSkillDTO> associateSkills = associateSkillService.findAllAssociateSkills();

		for (SkillDTO skillDTO : skills) {

			for (AssociateSkillDTO associateSkillDTO : associateSkills) {

				if (skillDTO.getSkillId().equals(associateSkillDTO.getSkillId())) {

					String skillKey = skillDTO.getSkillName();

					int skillCount = 0;

					if (skillsCount.containsKey(skillKey)) {
						skillCount = skillsCount.get(skillKey);
					}

					skillCount++;

					skillsCount.put(skillKey, skillCount);
				}
			}
		}

		return skillsCount;
	}

}
