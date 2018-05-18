/**
 * 
 */
package com.vini.skillstracker.dto;

import java.io.Serializable;

/**
 * @author kumarv19
 *
 */
public class SkillDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SkillDTO [id=" + id + ", name=" + name + "]";
	}

}
