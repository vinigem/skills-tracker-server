package com.vini.skillstracker.service;

import java.util.List;

import com.vini.skillstracker.model.Associate;

public interface IAssociateService {

	String addAssociate(Associate associate);

	String updateAssociate(Associate associate);

	String deleteAssociate(Long associateId);
	
	Associate viewAssociate(Long associateId);
	
	List<Associate> viewAllAssociates();
	
	List<Associate> searchByName(String name);
	
	List<Associate> searchByStrongSkills(String skillName);
	
	Associate searchByMobile(Long mobile);
	
	Associate searchByEmail(String email);

}
