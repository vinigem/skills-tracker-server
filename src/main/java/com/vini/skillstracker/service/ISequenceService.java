package com.vini.skillstracker.service;

/**
 * SequenceService interface
 * 
 * @author Vinit Kumar
 *
 */
public interface ISequenceService {

	/**
	 * method to get next sequence number
	 * 
	 * @param seqName the sequence name
	 * @return sequence number
	 */
	Long getNextSequence(String seqName);

}
