package com.vini.skillstracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * AssociateService implementation
 * @author Vinit Kumar
 *
 */
@Service
public class AssociateService implements IAssociateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssociateSkillService.class.getName());

	@Autowired
	private IAssociateDao associateDao;

	@Autowired
	private IAssociateSkillService associateSkillService;

	/**
	 * method to save associate
	 * 
	 * @param associateDTO the Associate dto
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
			LOGGER.error("Associate alread exist. {}, {}", associateDTO, de);

		} catch (Exception e) {
			status = AppConstant.FAILURE;
			LOGGER.error("Error while saving Associate.\n {}", e);
		}
		return status;
	}

	/**
	 * method to update associate
	 * 
	 * @param associateDTO the associate dto
	 * @return status
	 */
	@Override
	public String updateAssociate(AssociateDTO associateDTO) {
		String status = null;
		try {
			Associate associate = new Associate();
			BeanUtils.copyProperties(associateDTO, associate);

			associateDao.save(associate);

			boolean success = associateSkillService.saveAssociateSkills(associateDTO.getAssociateSkills());

			status = success ? AppConstant.SUCCESS : AppConstant.FAILURE;

		} catch (DuplicateKeyException de) {
			status = AppConstant.EXIST;
			LOGGER.error("Associate alread exist. {}, {}", associateDTO, de);

		} catch (Exception e) {
			status = AppConstant.FAILURE;
			LOGGER.error("Error while saving Associate.\n {}", e);
		}
		return status;
	}

	/**
	 * method to delete associate
	 * 
	 * @param associateId the associate id
	 * @return status
	 */
	@Override
	public String deleteAssociate(Long associateId) {
		String status = null;
		try {
			associateDao.deleteByAssociateId(associateId);

			boolean success = associateSkillService.deleteAssociateSkills(associateId);

			status = success ? AppConstant.SUCCESS : AppConstant.FAILURE;

		} catch (Exception e) {
			status = AppConstant.FAILURE;
			LOGGER.error("Error while deleting Associate.\n {}", e);
		}
		return status;
	}

	/**
	 * method to find an associate
	 * 
	 * @param associateId the associate id
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
	 * method to find an associate skills
	 * 
	 * @param associateId the associate id
	 * @return associateSkilss
	 */
	@Override
	public List<AssociateSkillDTO> findAssociateSkills(Long associateId) {
		return associateSkillService.findAssociateSkills(associateId);
	}

}
