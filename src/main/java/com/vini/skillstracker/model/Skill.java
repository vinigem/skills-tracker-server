/**
 * 
 */
package com.vini.skillstracker.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author kumarv19
 *
 */
@Document(collection = "skill")
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long skillId;

	@Indexed(unique = true, name = "skillName")
	private String skillName;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Date createdOn;

	@LastModifiedBy
	private String lastUpdatedBy;

	@LastModifiedDate
	private Date lastUpdatedOn;

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

	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * @param skillName
	 *            the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}

}
