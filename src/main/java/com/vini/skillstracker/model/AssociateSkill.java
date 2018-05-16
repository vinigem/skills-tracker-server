package com.vini.skillstracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author kumarv19
 *
 */
@Document(collection = "associate_skill")
public class AssociateSkill extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Long associateId;
	private Long skillId;

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
	 * @return the associateId
	 */
	public Long getAssociateId() {
		return associateId;
	}

	/**
	 * @param associateId
	 *            the associateId to set
	 */
	public void setAssociateId(Long associateId) {
		this.associateId = associateId;
	}

	/**
	 * @return the skillId
	 */
	public Long getSkillId() {
		return skillId;
	}

	/**
	 * @param skillId
	 *            the skillId to set
	 */
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociateSkill [id=" + id + ", associateId=" + associateId + ", skillId=" + skillId + ", toString()="
				+ super.toString() + "]";
	}

}
