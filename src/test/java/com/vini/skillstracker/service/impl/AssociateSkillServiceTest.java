/**
 * 
 */
package com.vini.skillstracker.service.impl;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;

import com.vini.skillstracker.dao.IAssociateSkillDao;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.model.AssociateSkill;

/**
 * @author Vinit Kumar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateSkillServiceTest {
	
	@InjectMocks
	private AssociateSkillService associateSkillService;
	
	@Mock
	private IAssociateSkillDao associateSkillDao;

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
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateSkillService#saveAssociateSkills(java.util.List)}.
	 */
	@Test
	public void testSaveAssociateSkills() {
		AssociateSkillDTO associateSkillDTO1 = new AssociateSkillDTO();
		associateSkillDTO1.setId("1");
		associateSkillDTO1.setValue(0);
		AssociateSkillDTO associateSkillDTO2 = new AssociateSkillDTO();
		associateSkillDTO2.setValue(1);
		
		try {
			Mockito.doNothing().when(associateSkillDao).delete(Mockito.any(AssociateSkill.class));
			Mockito.when(associateSkillDao.save(Mockito.any(AssociateSkill.class))).thenReturn(new AssociateSkill());
			assertTrue(associateSkillService.saveAssociateSkills(Arrays.asList(associateSkillDTO1, associateSkillDTO2)));
			
			Mockito.doNothing().when(associateSkillDao).delete(Mockito.any(AssociateSkill.class));
			Mockito.when(associateSkillDao.save(Mockito.any(AssociateSkill.class))).thenThrow(new DuplicateKeyException(""));
			assertFalse(associateSkillService.saveAssociateSkills(Arrays.asList(associateSkillDTO1, associateSkillDTO2)));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateSkillService#findAssociateSkills(java.lang.Long)}.
	 */
	@Test
	public void testFindAssociateSkills() {
		AssociateSkill associateSkill = new AssociateSkill();
		associateSkill.setId("1");
		associateSkill.setValue(0);
		associateSkill.setSkillId(1L);
		associateSkill.setAssociateId(1L);
		try {
			Mockito.when(associateSkillDao.findByAssociateId(Mockito.anyLong())).thenReturn(Arrays.asList(associateSkill));
			assertNotNull(associateSkillService.findAssociateSkills(1L));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateSkillService#deleteAssociateSkills(java.lang.Long)}.
	 */
	@Test
	public void testDeleteAssociateSkills() {
		try {
			Mockito.doNothing().when(associateSkillDao).deleteByAssociateId(Mockito.anyLong());
			assertTrue(associateSkillService.deleteAssociateSkills(123456L));
			
			Mockito.doThrow(new DuplicateKeyException("")).when(associateSkillDao).deleteByAssociateId(Mockito.anyLong());
			assertFalse(associateSkillService.deleteAssociateSkills(123456L));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateSkillService#findAllAssociateSkills()}.
	 */
	@Test
	public void testFindAllAssociateSkills() {

		AssociateSkill associateSkill = new AssociateSkill();
		associateSkill.setId("1");
		associateSkill.setValue(0);
		associateSkill.setSkillId(1L);
		associateSkill.setAssociateId(1L);
		try {
			Mockito.when(associateSkillDao.findAll()).thenReturn(Arrays.asList(associateSkill));
			assertNotNull(associateSkillService.findAllAssociateSkills());
			
			Mockito.when(associateSkillDao.findAll()).thenThrow(new DuplicateKeyException(""));
			assertNotNull(associateSkillService.findAllAssociateSkills());
		} catch (Exception e) {
			fail("Exception");
		}
	
	}

}
