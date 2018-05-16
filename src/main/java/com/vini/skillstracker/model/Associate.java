/**
 * 
 */
package com.vini.skillstracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author kumarv19
 *
 */
@Document(collection = "associate")
public class Associate extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	private Long associateId;
	private String name;
	private String email;
	private Long mobile;
	private String pic;
	private String status;
	private String level;
	private String remarks;
	private String strength;
	private String weakness;

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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public Long getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * @param pic
	 *            the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the strength
	 */
	public String getStrength() {
		return strength;
	}

	/**
	 * @param strength
	 *            the strength to set
	 */
	public void setStrength(String strength) {
		this.strength = strength;
	}

	/**
	 * @return the weakness
	 */
	public String getWeakness() {
		return weakness;
	}

	/**
	 * @param weakness
	 *            the weakness to set
	 */
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Associate [associateId=" + associateId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", pic=" + pic + ", status=" + status + ", level=" + level + ", remarks=" + remarks + ", strength="
				+ strength + ", weakness=" + weakness + ", toString()=" + super.toString() + "]";
	}

}
