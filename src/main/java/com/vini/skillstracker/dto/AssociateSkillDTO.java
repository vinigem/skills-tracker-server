package com.vini.skillstracker.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Associate Skill DTO
 * @author Vinit Kumar
 *
 */
public class AssociateSkillDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Long associateId;
	private Long skillId;
	private int value;
	private String createdBy;
	private Date createdOn;
	private String lastUpdatedBy;
	private Date lastUpdatedOn;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the associateId
	 */
	public Long getAssociateId() {
		return associateId;
	}

	/**
	 * @param associateId the associateId to set
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
	 * @param skillId the skillId to set
	 */
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * @return the lastUpdatedOn
	 */
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	/**
	 * @param lastUpdatedOn the lastUpdatedOn to set
	 */
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociateSkillDTO [id=" + id + ", associateId=" + associateId + ", skillId=" + skillId + ", value="
				+ value + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastUpdatedBy=" + lastUpdatedBy
				+ ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}
	
}
