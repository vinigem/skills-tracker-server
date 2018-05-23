/**
 * 
 */
package com.vini.skillstracker.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;
import com.vini.skillstracker.AppConstant;
import com.vini.skillstracker.dao.ISkillDao;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.dto.SkillDTO;
import com.vini.skillstracker.model.Skill;
import com.vini.skillstracker.service.IAssociateSkillService;
import com.vini.skillstracker.service.ISequenceService;

/**
 * @author Vinit Kumar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillServiceTest {
	
	@InjectMocks
	private SkillService skillService;
	
	@Mock
	private ISequenceService sequenceService;

	@Mock
	private ISkillDao skillDao;

	@Mock
	private IAssociateSkillService associateSkillService;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.SkillService#addSkill(com.vini.skillstracker.dto.SkillDTO)}.
	 */
	@Test
	public void testAddSkill() {
		SkillDTO skillDTO = new SkillDTO();
		try {
			Mockito.when(skillDao.save(Mockito.any(Skill.class))).thenReturn(new Skill());
			Mockito.when(sequenceService.getNextSequence(Mockito.anyString())).thenReturn(1L);
			assertEquals(AppConstant.SUCCESS, skillService.addSkill(skillDTO));
						
			Mockito.when(skillDao.save(Mockito.any(Skill.class))).thenThrow(new DuplicateKeyException(""));
			Mockito.when(sequenceService.getNextSequence(Mockito.anyString())).thenReturn(1L);
			assertEquals(AppConstant.EXIST, skillService.addSkill(skillDTO));
			
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.SkillService#updateSkill(com.vini.skillstracker.dto.SkillDTO)}.
	 */
	@Test
	public void testUpdateSkill() {
		SkillDTO skillDTO = new SkillDTO();
		try {
			Mockito.when(skillDao.save(Mockito.any(Skill.class))).thenReturn(new Skill());
			Mockito.when(sequenceService.getNextSequence(Mockito.anyString())).thenReturn(1L);
			assertEquals(AppConstant.SUCCESS, skillService.updateSkill(skillDTO));
			
			Mockito.when(skillDao.save(Mockito.any(Skill.class))).thenThrow(new DuplicateKeyException(""));
			Mockito.when(sequenceService.getNextSequence(Mockito.anyString())).thenReturn(1L);
			assertEquals(AppConstant.EXIST, skillService.updateSkill(skillDTO));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.SkillService#deleteSkill(java.lang.Long)}.
	 */
	@Test
	public void testDeleteSkill() {
		try {
			Mockito.doNothing().when(skillDao).deleteBySkillId(Mockito.anyLong());
			assertEquals(AppConstant.SUCCESS, skillService.deleteSkill(123456L));
			
			Mockito.doThrow(new DuplicateKeyException("")).when(skillDao).deleteBySkillId(Mockito.anyLong());
			assertEquals(AppConstant.FAILURE, skillService.deleteSkill(123456L));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.SkillService#findAllSkills()}.
	 */
	@Test
	public void testFindAllSkills() {
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(new Skill());
		try {
			Mockito.when(skillDao.findAll()).thenReturn(skills);
			assertNotNull(skillService.findAllSkills());
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.SkillService#findAllSkillsCount()}.
	 */
	@Test
	public void testFindAllSkillsCount() {
		List<Skill> skills = new ArrayList<Skill>();
		
		Skill skill = new Skill();
		skill.setSkillId(1L);
		skill.setSkillName("Java");
		skills.add(skill);
		
		List<AssociateSkillDTO> associateSkillDTOs = new ArrayList<AssociateSkillDTO>();
		AssociateSkillDTO associateSkillDTO = new AssociateSkillDTO();
		associateSkillDTO.setSkillId(1L);
		associateSkillDTO.setValue(1);
		associateSkillDTOs.add(associateSkillDTO);
		try {
			Mockito.when(skillDao.findAll()).thenReturn(skills);
			Mockito.when(associateSkillService.findAllAssociateSkills()).thenReturn(associateSkillDTOs);
			assertNotNull(skillService.findAllSkillsCount());
		} catch (Exception e) {
			fail("Exception");
		}
	}

}
