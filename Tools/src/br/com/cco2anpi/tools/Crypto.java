/**
 * 
 */
package br.com.cco2anpi.tools;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.NoSuchPaddingException;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.engines.RijndaelEngine;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encoders.Base64;

/**
 * @author wotan Classe utilizada para criptografia
 */
public class Crypto {

	private static final int keySize = 256;
	private static final char[] initVector = "tu89geji340t89u2".toCharArray();
	private static final int iterationCount = 5;

	/**
	 * Metodo usado para encriptar texto
	 * 
	 * @param plainText
	 *            texto a ser encriptado
	 * @param passPhrase
	 *            Salt utilizado para encriptar
	 * @return texto cifrado
	 * @throws InvalidCipherTextException
	 * @throws IllegalStateException
	 * @throws DataLengthException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt(String plainText, String passPhrase)
			throws DataLengthException, IllegalStateException, InvalidCipherTextException {
		PKCS12ParametersGenerator parameterGenerator = new PKCS12ParametersGenerator(new SHA3Digest(256));
		byte[] pkcs12PasswordBytes = PBEParametersGenerator.PKCS12PasswordToBytes(initVector);

		parameterGenerator.init(pkcs12PasswordBytes, passPhrase.getBytes(), iterationCount);

		BlockCipher engine = new RijndaelEngine(keySize);
		CBCBlockCipher cbc = new CBCBlockCipher(engine);
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(cbc, new PKCS7Padding());

		ParametersWithIV aesCBCParams = (ParametersWithIV) parameterGenerator.generateDerivedParameters(keySize,
				keySize);
		cipher.init(true, aesCBCParams);

		byte[] input = plainText.getBytes(StandardCharsets.US_ASCII);
		byte[] cipherText = new byte[cipher.getOutputSize(input.length)];

		int cipherLength = cipher.processBytes(input, 0, input.length, cipherText, 0);
		cipher.doFinal(cipherText, cipherLength);

		return new String(Base64.encode(cipherText));
	}

	/**
	 * Metodo usado para decriptar texto
	 * 
	 * @param ciphredText
	 *            texto encriptado
	 * @param passPhrase
	 *            salt utilizado para decriptar
	 * @return texto decriptado
	 * @throws InvalidCipherTextException
	 * @throws IllegalStateException
	 * @throws DataLengthException
	 */
	public static String decrypt(String ciphredText, String passPhrase)
			throws DataLengthException, IllegalStateException, InvalidCipherTextException {
		PKCS12ParametersGenerator pGen = new PKCS12ParametersGenerator(new SHA3Digest(256));
		char[] passwordChars = initVector;

		final byte[] pkcs12PasswordBytes = PBEParametersGenerator.PKCS12PasswordToBytes(passwordChars);
		pGen.init(pkcs12PasswordBytes, passPhrase.getBytes(), iterationCount);

		BlockCipher engine = new RijndaelEngine(256);
		CBCBlockCipher cbc = new CBCBlockCipher(engine);
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(cbc, new PKCS7Padding());

		ParametersWithIV aesCBCParams = (ParametersWithIV) pGen.generateDerivedParameters(256, 256);
		cipher.init(false, aesCBCParams);

		byte[] output = Base64.decode(ciphredText.getBytes());
		byte[] cipherText = new byte[cipher.getOutputSize(output.length)];

		int cipherLength = cipher.processBytes(output, 0, output.length, cipherText, 0);
		int outputLength = cipher.doFinal(cipherText, cipherLength);
		outputLength += cipherLength;

		byte[] resultBytes = cipherText;
		if (outputLength != output.length) {
			resultBytes = new byte[outputLength];
			System.arraycopy(cipherText, 0, resultBytes, 0, outputLength);
		}

		return new String(resultBytes);
	}

	/**
	 * Método utilizado para gerar salt para a senha encriptar
	 * 
	 * @return salt
	 * @throws UnsupportedEncodingException 
	 */
	public static String generateRandomSalt() throws UnsupportedEncodingException {
		Random random = new SecureRandom();
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		return Base64.toBase64String(salt);
	}

}
