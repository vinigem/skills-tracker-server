/**
 * 
 */
package com.vini.skillstracker.service.impl;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.vini.skillstracker.model.CustomSequences;

/**
 * @author Vinit Kumar
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SequenceServiceTest {
	
	@InjectMocks
	private SequenceService sequenceService;
	
	@Mock
	private MongoOperations mongoOperations;
	
	@Mock
	private Query query;
	
	@Mock
	private Update update;
	
	@Mock
	private FindAndModifyOptions findAndModifyOptions;

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
	 * Test method for {@link com.vini.skillstracker.service.impl.SequenceService#getNextSequence(java.lang.String)}.
	 */
	@Test
	public void testGetNextSequence() {
		try {
			String seqName = "Skill";
			CustomSequences customSequences = new CustomSequences();
			customSequences.setSeq(1L);
			customSequences.setId(seqName);
			
			Mockito.when(update.inc(Mockito.anyString(), Mockito.anyInt())).thenReturn(update);
			Mockito.when(findAndModifyOptions.returnNew(Mockito.anyBoolean())).thenReturn(findAndModifyOptions);
			Mockito.when(findAndModifyOptions.upsert(Mockito.anyBoolean())).thenReturn(findAndModifyOptions);
			Mockito.when(update.inc(Mockito.anyString(), Mockito.anyInt())).thenReturn(update);
			Mockito.when(mongoOperations.findAndModify(query, update, findAndModifyOptions, CustomSequences.class)).thenReturn(customSequences);
			
			Long expected = new Long(1);
			assertEquals(expected, sequenceService.getNextSequence(seqName));
			
		} catch (Exception e) {
			
		}
	}

}
