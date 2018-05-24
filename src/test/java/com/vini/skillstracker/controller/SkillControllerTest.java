package com.vini.skillstracker.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;

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
import com.vini.skillstracker.dto.SkillDTO;
import com.vini.skillstracker.service.ISkillService;

/**
 * @author Vinit Kumar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SkillControllerTest {
	
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private SkillController skillController;
	
	@Mock
	private ISkillService skillService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(skillController).build();
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}

	@Test
	public void testAddSkill() {
		try {
			Mockito.when(skillService.addSkill(Mockito.any(SkillDTO.class))).thenReturn(AppConstant.SUCCESS);
			mockMvc.perform(post("/skill/add-skill").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(new SkillDTO()))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testUpdateSkill() {
		try {
			Mockito.when(skillService.updateSkill(Mockito.any(SkillDTO.class))).thenReturn(AppConstant.SUCCESS);
			mockMvc.perform(post("/skill/update-skill").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(new SkillDTO()))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testDeleteSkill() {
		try {
			Mockito.when(skillService.deleteSkill(Mockito.anyLong())).thenReturn(AppConstant.SUCCESS);
			mockMvc.perform(post("/skill/delete-skill").contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(1L))).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testFindAllSkills() {
		try {
			Mockito.when(skillService.findAllSkills()).thenReturn(new ArrayList<SkillDTO>());
			mockMvc.perform(get("/skill/find-all-skills").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void testFindAllSkillsCount() {
		try {
			Mockito.when(skillService.findAllSkillsCount()).thenReturn(new HashMap<String, Integer>());
			mockMvc.perform(get("/skill/find-all-skills-count").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
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
