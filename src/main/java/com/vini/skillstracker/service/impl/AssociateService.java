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
	 * 
	 * @param associateDTO
	 *            the Associate dto
	 * @return status
	 */
	@Override
	public String addAssociate(AssociateDTO associateDTO) {
		String status = null;
		try {
			Associate associate = new Associate();
			BeanUtils.copyProperties(associateDTO, associate);

			associateDao.save(associate);

			boolean success = associateSkillService.saveAssociateSkills(associateDTO.getAssociateSkills());

			status = success ? AppConstant.SUCCESS : AppConstant.FAILURE;

		} catch (DuplicateKeyException de) {
			status = AppConstant.EXIST;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	/**
	 * method to update associate
	 * 
	 * @param associateDTO
	 *            the associate dto
	 * @return status
	 */
	@Override
	public String updateAssociate(AssociateDTO associateDTO) {
		String status = null;
		try {
			Associate associate = new Associate();
			BeanUtils.copyProperties(associateDTO, associate);

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
	 * 
	 * @param associateId
	 *            the associate id
	 * @return status
	 */
	@Override
	public String deleteAssociate(Long associateId) {
		String status = null;
		try {
			associateDao.deleteByAssociateId(associateId);
			status = AppConstant.SUCCESS;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
		}
		return status;
	}

	/**
	 * method to find an associate
	 * 
	 * @param associateId
	 *            the associate id
	 * @return associate
	 */
	@Override
	public AssociateDTO findAssociate(Long associateId) {
		Associate associate = associateDao.findByAssociateId(associateId);
		AssociateDTO associateDTO = new AssociateDTO();
		BeanUtils.copyProperties(associate, associateDTO);
		return associateDTO;
	}

	/**
	 * method to find all associate
	 * 
	 * @return associates
	 */
	@Override
	public List<AssociateDTO> findAllAssociates() {
		List<AssociateDTO> associateDTOs = new ArrayList<AssociateDTO>();

		List<Associate> associates = associateDao.findAll();

		for (Associate associate : associates) {
			AssociateDTO associateDTO = new AssociateDTO();
			BeanUtils.copyProperties(associate, associateDTO);
			associateDTOs.add(associateDTO);
		}

		return associateDTOs;
	}

	/**
	 * method to search associates by name
	 * 
	 * @param name
	 *            the associate name
	 * @return associates
	 */
	@Override
	public List<AssociateDTO> searchByName(String name) {
		List<AssociateDTO> associateDTOs = new ArrayList<AssociateDTO>();

		List<Associate> associates = associateDao.findByNameIgnoreCaseContaining(name);

		for (Associate associate : associates) {
			AssociateDTO associateDTO = new AssociateDTO();
			BeanUtils.copyProperties(associate, associateDTO);
			associateDTOs.add(associateDTO);
		}

		return associateDTOs;
	}

	/**
	 * method to find associates by strong skills
	 * 
	 * @param skillName
	 *            the skill name
	 * @return associates
	 */
	@Override
	public List<AssociateDTO> searchByStrongSkills(String skillName) {
		List<AssociateDTO> associateDTOs = new ArrayList<AssociateDTO>();

		List<Associate> associates = associateDao.findByStrengthIgnoreCaseContaining(skillName);

		for (Associate associate : associates) {
			AssociateDTO associateDTO = new AssociateDTO();
			BeanUtils.copyProperties(associate, associateDTO);
			associateDTOs.add(associateDTO);
		}

		return associateDTOs;
	}

	/**
	 * method to find an associate by mobile
	 * 
	 * @param mobile
	 *            the associate mobile
	 * @return associate
	 */
	@Override
	public AssociateDTO searchByMobile(Long mobile) {
		AssociateDTO associateDTO = new AssociateDTO();

		Associate associate = associateDao.findByMobile(mobile);

		BeanUtils.copyProperties(associate, associateDTO);

		return associateDTO;
	}

	/**
	 * method to find an associate by email
	 * 
	 * @param email
	 *            the associate email
	 * @return associate
	 */
	@Override
	public AssociateDTO searchByEmail(String email) {
		AssociateDTO associateDTO = new AssociateDTO();

		Associate associate = associateDao.findByEmail(email);

		BeanUtils.copyProperties(associate, associateDTO);

		return associateDTO;
	}

	@Override
	public List<AssociateSkillDTO> findAssociateSkills(Long associateId) {
		return associateSkillService.findAssociateSkills(associateId);
	}

}
