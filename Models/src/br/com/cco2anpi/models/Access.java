/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public class Access implements IAccess {
	private int id;
	private int dateIn;
	private int dateOut;
	
	public Access()
	{
		
	}
	
	public Access(IAccess sourceObject)
	{
		id = sourceObject.getId();
		dateIn = sourceObject.getDateIn();
		dateOut = sourceObject.getDateOut();
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
	 * @return the dateIn
	 */
	public int getDateIn() {
		return dateIn;
	}
	/**
	 * @param dateIn the dateIn to set
	 */
	public void setDateIn(int dateIn) {
		this.dateIn = dateIn;
	}
	/**
	 * @return the dateOut
	 */
	public int getDateOut() {
		return dateOut;
	}
	/**
	 * @param dateOut the dateOut to set
	 */
	public void setDateOut(int dateOut) {
		this.dateOut = dateOut;
	}
	
}
