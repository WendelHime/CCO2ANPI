/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 * Interface related of access
 */
public interface IAccess {
	void setId(int id);
	void setDateIn(int date);
	void setDateOut(int date);
	int getId();
	int getDateIn();
	int getDateOut();
}
