/**
 * 
 */
package com.vini.skillstracker.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vini.skillstracker.AppConstant;
import com.vini.skillstracker.dto.AssociateDTO;
import com.vini.skillstracker.dto.AssociateSkillDTO;
import com.vini.skillstracker.service.IAssociateService;

/**
 * @author Vinit Kumar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AssociateControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private AssociateController associateController;
	
	@Mock
	private IAssociateService associateService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(associateController).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}

	/**
	 * Test method for {@link com.vini.skillstracker.controller.AssociateController#addAssociate(com.vini.skillstracker.dto.AssociateDTO)}.
	 */
	@Test
	public void testAddAssociate() {
		try {
			Mockito.when(associateService.addAssociate(Mockito.any(AssociateDTO.class))).thenReturn(AppConstant.SUCCESS);
			mockMvc.perform(post("/associate/add-associate").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(new AssociateDTO()))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.controller.AssociateController#updateAssociate(com.vini.skillstracker.dto.AssociateDTO)}.
	 */
	@Test
	public void testUpdateAssociate() {
		try {
			Mockito.when(associateService.updateAssociate(Mockito.any(AssociateDTO.class))).thenReturn(AppConstant.SUCCESS);
			mockMvc.perform(post("/associate/update-associate").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(new AssociateDTO()))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.controller.AssociateController#findAssociate(java.lang.Long)}.
	 */
	@Test
	public void testFindAssociate() {
		try {
			Mockito.when(associateService.findAssociate(Mockito.anyLong())).thenReturn(new AssociateDTO());
			mockMvc.perform(post("/associate/find-associate").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(1L))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.controller.AssociateController#findAllAssociates()}.
	 */
	@Test
	public void testFindAllAssociates() {
		try {
			Mockito.when(associateService.findAllAssociates()).thenReturn(new ArrayList<AssociateDTO>());
			mockMvc.perform(get("/associate/find-all-associates").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.controller.AssociateController#findAssociateSkills(java.lang.Long)}.
	 */
	@Test
	public void testFindAssociateSkills() {
		try {
			Mockito.when(associateService.findAssociateSkills(Mockito.anyLong())).thenReturn(new ArrayList<AssociateSkillDTO>());
			mockMvc.perform(post("/associate/find-associate-skills").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(1L))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	/**
	 * Test method for {@link com.vini.skillstracker.controller.AssociateController#deleteAssociate(java.lang.Long)}.
	 */
	@Test
	public void testDeleteAssociate() {
		try {
			Mockito.when(associateService.deleteAssociate(Mockito.anyLong())).thenReturn(AppConstant.SUCCESS);
			mockMvc.perform(post("/associate/delete-associate").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(1L))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}
	
	private static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
