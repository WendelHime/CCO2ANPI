/**
 * 
 */
package br.com.cco2anpi.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wotan Classe utilizada para gerenciar arquivos
 */
public class FileHandler {

	/**
	 * Método utilizado para escrever arquivo
	 * 
	 * @param path
	 *            Caminho a ser usado
	 * @param filename
	 *            Nome do arquivo com extensão
	 * @param content
	 *            Conteúdo a ser escrito
	 * @return Retorna arquivo
	 * @throws IOException
	 */
	public static File write(String path, String filename, String content) throws IOException {
		createDirectory(path);
		File file = new File(path, filename);
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(content.getBytes());
		stream.close();
		return file;
	}

	/**
	 * Método utilizado para realizar leitura do arquivo
	 * 
	 * @param path
	 *            Caminho a ser usado
	 * @param filename
	 *            Nome do arquivo
	 * @return Retorna String com o conteúdo
	 * @throws IOException
	 */
	public static String read(String path, String filename) throws IOException {
		File file = new File(path, filename);
		byte[] bytes = new byte[(int) file.length()];
		FileInputStream in = new FileInputStream(file);
		in.read(bytes);
		in.close();
		return new String(bytes);
	}

	/**
	 * Método utilizado para deletar arquivo
	 * 
	 * @param path
	 *            Caminho a ser usado
	 * @param filename
	 *            Nome do arquivo
	 */
	public static void delete(String path, String filename) {
		File file = new File(path, filename);
		file.delete();
	}

	/**
	 * Método utilizado para criar diretório
	 * 
	 * @param path
	 *            Caminho a ser usado
	 */
	public static void createDirectory(String path) {
		File directory = new File(path);
		if (!directory.exists()) {
			directory.mkdirs();
		}
	}
}
