package com.vini.skillstracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.vini.skillstracker.AppConstant;
import com.vini.skillstracker.dao.IAssociateDao;
import com.vini.skillstracker.dto.AssociateDTO;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.model.Associate;
import com.vini.skillstracker.model.AssociateSkill;
import com.vini.skillstracker.service.IAssociateService;
import com.vini.skillstracker.service.IAssociateSkillService;

@Service
public class AssociateService implements IAssociateService {

	@Autowired
	private IAssociateDao associateDao;
	
	@Autowired
	private IAssociateSkillService associateSkillService;

	/**
	 * method to save associate
	 * @param associate the Associate model
	 * @return status
	 */
	@Override
	public String addAssociate(AssociateDTO associateDTO) {
		String status = null;
		try {
			Associate associate = new Associate();
			BeanUtils.copyProperties(associateDTO, associate);
			System.out.println(associate);			
			Associate savedAssociate = associateDao.save(associate);
			
			List<AssociateSkill> associateSkills = new ArrayList<AssociateSkill>();
			for(AssociateSkillDTO associateSkillDTO: associateDTO.getAssociateSkills()) {
				AssociateSkill associateSkill = new AssociateSkill();
				BeanUtils.copyProperties(associateSkillDTO, associateSkill);
				associateSkill.setAssociateId(savedAssociate.getAssociateId());
				associateSkills.add(associateSkill);
				System.out.println(associateSkill);
			}
			
			boolean success = associateSkillService.saveAssociateSkills(associateSkills);
			
			status = success ? AppConstant.SUCCESS: AppConstant.FAILURE;

		} catch (DuplicateKeyException de) {
			status = AppConstant.EXIST;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	/**
	 * method to update associate
	 * @param associate the associate
	 * @return status
	 */
	@Override
	public String updateAssociate(Associate associate) {
		String status = null;
		try {
			associateDao.save(associate);
			status = AppConstant.SUCCESS;

		} catch (DuplicateKeyException de) {
			status = AppConstant.EXIST;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	/**
	 * method to delete associate
	 * @param associateId the associate id
	 * @return status
	 */
	@Override
	public String deleteAssociate(Long associateId) {
		String status = null;
		try {
			associateDao.delete(associateId);
			status = AppConstant.SUCCESS;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	/**
	 * method to find an associate
	 * @param associateId the associate id
	 * @return associate
	 */
	@Override
	public Associate viewAssociate(Long associateId) {
		return associateDao.findOne(associateId);
	}

	/**
	 * method to find all associate
	 * @return associates
	 */
	@Override
	public List<Associate> viewAllAssociates() {
		return associateDao.findAll();
	}

	/**
	 * method to search associates by name
	 * @param name the associate name
	 * @return associates
	 */
	@Override
	public List<Associate> searchByName(String name) {
		return associateDao.findByNameIgnoreCaseContaining(name);
	}

	/**
	 * method to find associates by strong skills
	 * @param skillName the skill name
	 * @return associates
	 */
	@Override
	public List<Associate> searchByStrongSkills(String skillName) {
		return associateDao.findByStrengthIgnoreCaseContaining(skillName);
	}

	/**
	 * method to find an associate by mobile
	 * @param mobile the associate mobile
	 * @return associate
	 */
	@Override
	public Associate searchByMobile(Long mobile) {
		return associateDao.findByMobile(mobile);
	}

	/**
	 * method to find an associate by email
	 * @param email the associate email
	 * @return associate
	 */
	@Override
	public Associate searchByEmail(String email) {
		return associateDao.findByEmail(email);
	}

}
