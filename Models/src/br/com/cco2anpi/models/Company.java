/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public class Company implements ICompany {
	private int id;
	private String cnpj;
	private String socialReason;
	private int businessHours;
	private double maximumTemperature;
	private ComplexBuilding complexBuilding;
	private Employer[] employers;
	
	public Company()
	{
		
	}
	
	public Company(ICompany sourceObject)
	{
		id = sourceObject.getId();
		cnpj = sourceObject.getCnpj();
		socialReason = sourceObject.getSocialReason();
		businessHours = sourceObject.getBusinessHours();
		maximumTemperature = sourceObject.getMaximumTemperature();
		complexBuilding = (ComplexBuilding) sourceObject.getComplexBuilding();
		employers = (Employer[]) sourceObject.getEmployers();
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}
	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	/**
	 * @return the socialReason
	 */
	public String getSocialReason() {
		return socialReason;
	}
	/**
	 * @param socialReason the socialReason to set
	 */
	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}
	/**
	 * @return the businessHours
	 */
	public int getBusinessHours() {
		return businessHours;
	}
	/**
	 * @param businessHours the businessHours to set
	 */
	public void setBusinessHours(int businessHours) {
		this.businessHours = businessHours;
	}
	/**
	 * @return the maximumTemperature
	 */
	public double getMaximumTemperature() {
		return maximumTemperature;
	}
	/**
	 * @param maximumTemperature the maximumTemperature to set
	 */
	public void setMaximumTemperature(double maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	/**
	 * @return the complexBuilding
	 */
	public IComplexBuilding getComplexBuilding() {
		return complexBuilding;
	}
	/**
	 * @param complexBuilding the complexBuilding to set
	 */
	public void setComplexBuilding(IComplexBuilding complexBuilding) {
		this.complexBuilding = (ComplexBuilding) complexBuilding;
	}
	/**
	 * @return the employers
	 */
	public IEmployer[] getEmployers() {
		return (IEmployer[]) employers;
	}
	/**
	 * @param employers the employers to set
	 */
	public void setEmployers(IEmployer[] employers) {
		this.employers = (Employer[]) employers;
	}	
	
}
