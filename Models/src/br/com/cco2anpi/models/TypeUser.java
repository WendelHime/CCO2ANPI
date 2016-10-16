/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public enum TypeUser {
    SYNDIC(1), // síndico
    CLERK(2), // atendente
    EMPLOYER(3);

    private int value;

    /**
     * Set the value of the type
     * @param value value to be used
     */
    private TypeUser(int value) {
	this.value = value;
    }

    /**
     * Method used to return value of the current type
     * @return return the value
     */
    public int getValue() {
	return this.value;
    }

    /**
     * Method used to return the enum of the value
     * @param value value to be used
     * @return return type of the user by de value
     */
    public TypeUser getValue(int value) {
	for (TypeUser type : TypeUser.values()) {
	    if (type.value == value) {
		return type;
	    }
	}
	return null;
    }
}
