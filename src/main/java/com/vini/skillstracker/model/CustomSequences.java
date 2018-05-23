package com.vini.skillstracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Custom Sequence Model
 * @author Vinit Kumar
 *
 */
@Document(collection = "customSequences")
public class CustomSequences {

	@Id
	private String id;
	private Long seq;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the seq
	 */
	public Long getSeq() {
		return seq;
	}

	/**
	 * @param seq
	 *            the seq to set
	 */
	public void setSeq(Long seq) {
		this.seq = seq;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomSequences [id=" + id + ", seq=" + seq + "]";
	}

}
