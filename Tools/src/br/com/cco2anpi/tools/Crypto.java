/**
 * 
 */
package br.com.cco2anpi.tools;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author wotan
 * Classe utilizada para criptografia
 */
public class Crypto {
	/**
	 * Metodo usado para encriptar texto
	 * @param plainText texto a ser encriptado
	 * @param passPhrase Salt utilizado para encriptar
	 * @return texto cifrado
	 */
	public static String encrypt(String plainText, String passPhrase) {
		return "";
	}

	/**
	 * Metodo usado para decriptar texto
	 * @param ciphredText texto encriptado
	 * @param passPhrase salt utilizado para decriptar
	 * @return texto decriptado
	 */
	public static String decrypt(String ciphredText, String passPhrase) {
		return "";
	}

	/**
	 * Método utilizado para gerar salt para a senha encriptar
	 * @return salt
	 */
	public static String generateRandomSalt() {
		Random random = new SecureRandom();
		byte[] salt = new byte[32];
		random.nextBytes(salt);
		return new String(salt);
	}
}
