/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 * Class used to represent complex building
 */
public class ComplexBuilding implements IComplexBuilding {
	private int id;
	private String number;
	
	public ComplexBuilding()
	{
		
	}
	
	public ComplexBuilding(IComplexBuilding sourceObject)
	{
		id = sourceObject.getId();
		number = sourceObject.getNumber();
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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
