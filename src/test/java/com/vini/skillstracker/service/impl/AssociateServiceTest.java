/**
 * 
 */
package com.vini.skillstracker.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.vini.skillstracker.dao.IAssociateDao;
import com.vini.skillstracker.dto.AssociateDTO;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.model.Associate;
import com.vini.skillstracker.service.IAssociateSkillService;

/**
 * @author Vinit Kumar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateServiceTest {
	
	@Mock
    private IAssociateDao associateDao;
	
	@Mock
	private IAssociateSkillService associateSkillService;
	
	@InjectMocks
	private AssociateService associateService;

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
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#addAssociate(com.vini.skillstracker.dto.AssociateDTO)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddAssociate() {
		AssociateDTO associateDTO = new AssociateDTO();
		AssociateSkillDTO associateSkillDTO = new AssociateSkillDTO();
		associateDTO.setAssociateSkills(Arrays.asList(associateSkillDTO));
		try {
			Mockito.when(associateDao.save(Mockito.any(Associate.class))).thenReturn(new Associate());
			Mockito.when(associateSkillService.saveAssociateSkills(Mockito.anyList())).thenReturn(true);
			assertEquals(AppConstant.SUCCESS, associateService.addAssociate(associateDTO));
			
			Mockito.when(associateSkillService.saveAssociateSkills(Mockito.anyList())).thenReturn(false);
			assertEquals(AppConstant.FAILURE, associateService.addAssociate(associateDTO));
			
			Mockito.when(associateDao.save(Mockito.any(Associate.class))).thenThrow(new DuplicateKeyException("exist"));
			assertEquals(AppConstant.EXIST, associateService.addAssociate(associateDTO));
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#addAssociate(com.vini.skillstracker.dto.AssociateDTO)}.
	 */
	@Test
	public void testAddAssociateException() {
		AssociateDTO associateDTO = new AssociateDTO();
		AssociateSkillDTO associateSkillDTO = new AssociateSkillDTO();
		associateDTO.setAssociateSkills(Arrays.asList(associateSkillDTO));
		try {
			Mockito.when(associateDao.save(Mockito.any(Associate.class))).thenThrow(new NullPointerException());
			assertEquals(AppConstant.FAILURE, associateService.addAssociate(associateDTO));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#updateAssociate(com.vini.skillstracker.dto.AssociateDTO)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateAssociate() {
		AssociateDTO associateDTO = new AssociateDTO();
		AssociateSkillDTO associateSkillDTO = new AssociateSkillDTO();
		associateDTO.setAssociateSkills(Arrays.asList(associateSkillDTO));
		try {
			Mockito.when(associateDao.save(Mockito.any(Associate.class))).thenReturn(new Associate());
			Mockito.when(associateSkillService.saveAssociateSkills(Mockito.anyList())).thenReturn(true);
			assertEquals(AppConstant.SUCCESS, associateService.updateAssociate(associateDTO));
			
			Mockito.when(associateSkillService.saveAssociateSkills(Mockito.anyList())).thenReturn(false);
			assertEquals(AppConstant.FAILURE, associateService.updateAssociate(associateDTO));
			
			Mockito.when(associateDao.save(Mockito.any(Associate.class))).thenThrow(new DuplicateKeyException("exist"));
			assertEquals(AppConstant.EXIST, associateService.updateAssociate(associateDTO));
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#updateAssociate(com.vini.skillstracker.dto.AssociateDTO)}.
	 */
	@Test
	public void testUpdateAssociateException() {
		AssociateDTO associateDTO = new AssociateDTO();
		AssociateSkillDTO associateSkillDTO = new AssociateSkillDTO();
		associateDTO.setAssociateSkills(Arrays.asList(associateSkillDTO));
		try {
			Mockito.when(associateDao.save(Mockito.any(Associate.class))).thenThrow(new NullPointerException());
			assertEquals(AppConstant.FAILURE, associateService.updateAssociate(associateDTO));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#deleteAssociate(java.lang.Long)}.
	 */
	@Test
	public void testDeleteAssociate() {
		try {
			Mockito.doNothing().when(associateDao).deleteByAssociateId(Mockito.anyLong());
			Mockito.when(associateSkillService.deleteAssociateSkills(Mockito.anyLong())).thenReturn(true);
			assertEquals(AppConstant.SUCCESS, associateService.deleteAssociate(123456L));
			
			Mockito.doNothing().when(associateDao).deleteByAssociateId(Mockito.anyLong());
			Mockito.when(associateSkillService.deleteAssociateSkills(Mockito.anyLong())).thenReturn(false);
			assertEquals(AppConstant.FAILURE, associateService.deleteAssociate(123456L));
		} catch (Exception e) {
			fail("Exception");
		}
	}
	
	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#deleteAssociate(java.lang.Long)}.
	 */
	@Test
	public void testDeleteAssociateException() {
		try {
			Mockito.doThrow(new NullPointerException()).when(associateDao).deleteByAssociateId(Mockito.anyLong());
			Mockito.when(associateSkillService.deleteAssociateSkills(Mockito.anyLong())).thenReturn(false);
			assertEquals(AppConstant.FAILURE, associateService.deleteAssociate(123456L));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#findAssociate(java.lang.Long)}.
	 */
	@Test
	public void testFindAssociate() {
		try {
			Mockito.when(associateDao.findByAssociateId(Mockito.anyLong())).thenReturn(new Associate());
			assertNotNull(associateService.findAssociate(123456L));
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#findAllAssociates()}.
	 */
	@Test
	public void testFindAllAssociates() {
		try {
			List<Associate> associates = new ArrayList<Associate>();
			associates.add(new Associate());
			Mockito.when(associateDao.findAll()).thenReturn(associates);
			assertNotNull(associateService.findAllAssociates());
		} catch (Exception e) {
			fail("Exception");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.service.impl.AssociateService#findAssociateSkills(java.lang.Long)}.
	 */
	@Test
	public void testFindAssociateSkills() {
		try {
			Mockito.when(associateDao.findAll()).thenReturn(new ArrayList<Associate>());
			assertNotNull(associateService.findAssociateSkills(12345L));
		} catch (Exception e) {
			fail("Exception");
		}
	}

}
