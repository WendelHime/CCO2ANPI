/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public class Employer extends User implements IEmployer {
	private Integer id;
	private String accessHour;
	private Boolean permissionTemperature;
	private ICompany company;

	public Employer() {

	}

	public Employer(IEmployer sourceObject) {
		this.id = sourceObject.getId();
		this.userID = sourceObject.getUserID();
		this.accessHour = sourceObject.getAccessHour();
		this.permissionTemperature = sourceObject.getPermissionTemperature();
		this.company = sourceObject.getCompany();
		this.setUsername(sourceObject.getUsername());
		this.setPassword(sourceObject.getPassword());
		this.setSalt(sourceObject.getSalt());
		this.setName(sourceObject.getName());
		this.setCpf(sourceObject.getCpf());
		this.setAccess(sourceObject.getAccess());
		this.setType(sourceObject.getType());
		this.setCompany(sourceObject.getCompany());
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            id of the employee
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the accessHour
	 */
	public String getAccessHour() {
		return accessHour;
	}

	/**
	 * @param accessHour
	 *            the accessHour to set
	 */
	public void setAccessHour(String accessHour) {
		this.accessHour = accessHour;
	}

	/**
	 * @return the permissionTemperature
	 */
	public Boolean getPermissionTemperature() {
		return permissionTemperature;
	}

	/**
	 * @param permissionTemperature
	 *            the permissionTemperature to set
	 */
	public void setPermissionTemperature(Boolean permissionTemperature) {
		this.permissionTemperature = permissionTemperature;
	}

	/**
	 * @return the companys
	 */
	public ICompany getCompany() {
		return this.company;
	}

	/**
	 * @param companys
	 *            the companies to set
	 */
	public void setCompany(ICompany company) {
		this.company = company;
	}

	/**
	 * @return the user id
	 */
	public Integer getUserID() {
		return super.getUserId();
	}

	/**
	 * @param id
	 *            id of the user
	 */
	public void setUserID(Integer id) {
		super.setUserId(id);
	}

}
