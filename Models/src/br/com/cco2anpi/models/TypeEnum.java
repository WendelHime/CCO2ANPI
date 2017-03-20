/**
 * 
 */
package br.com.cco2anpi.models;

/**
 * @author wotan
 *
 */
public enum TypeEnum {
    SYNDIC(1), // síndico
    CLERK(2), // atendente
    COMPANY(3);

    private int value;

    /**
     * Set the value of the type
     * @param value value to be used
     */
    private TypeEnum(int value) {
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
    public static TypeEnum getValue(int value) {
	for (TypeEnum type : TypeEnum.values()) {
	    if (type.value == value) {
		return type;
	    }
	}
	return null;
    }
}
