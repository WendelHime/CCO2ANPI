/**
 * 
 */
package br.com.cco2anpi.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author wotan Classe utilizada para requisições HTTP
 */
public class RestClient {
	private static final String USER_AGENT = "Mozilla/5.0";

	/**
	 * Metodo usado para criar requisição
	 * 
	 * @param route
	 *            url da requisição
	 * @return Retorna HttpURLConnection
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static HttpURLConnection createRequest(String route) throws MalformedURLException, IOException {
		return (HttpURLConnection) (new URL("/" + route)).openConnection();
	}

	/**
	 * Metodo usado para fazer requisições get
	 * 
	 * @param route
	 *            URL da requisição
	 * @param parameters
	 *            parametros
	 * @param method
	 *            metodo
	 * @param type
	 *            tipo da classe a ser retornada
	 * @return Retorna objeto preenchido
	 * @throws IOException
	 */
	public static <T> T get(String route, HashMap<String, Object> parameters, String method, Class<T> type)
			throws IOException {
		StringBuffer response = new StringBuffer();
		if (parameters != null && parameters.size() > 0)
			route = route + "?" + stringifyParameters(parameters);
		HttpURLConnection request = createRequest(route);
		if (!method.isEmpty())
			request.setRequestMethod(method.toUpperCase());
		request.setRequestProperty("User-Agent", USER_AGENT);
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine = "";
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return (new Gson()).fromJson(response.toString(), type);
	}

	/**
	 * Metodo utilizado para fazer requisição put
	 * 
	 * @param route
	 *            URL a ser usada na requisição
	 * @param parameters
	 *            parametros
	 * @param type
	 *            tipo do retorno
	 * @return Retorna objeto preenchido
	 * @throws IOException
	 */
	public static <T> T put(String route, HashMap<String, Object> parameters, Class<T> type) throws IOException {
		return get(route, parameters, "put", type);
	}

	/**
	 * Metodo utilizado para fazer requisição delete
	 * 
	 * @param route
	 *            URL a ser usada na requisição
	 * @param parameters
	 *            parametros
	 * @param type
	 *            tipo do retorno
	 * @return Retorna objeto preenchido
	 * @throws IOException
	 */
	public static <T> T delete(String route, HashMap<String, Object> parameters, Class<T> type) throws IOException {
		return get(route, parameters, "delete", type);
	}

	/**
	 * Metodo utilizado para fazer requisição POST
	 * 
	 * @param route
	 *            URL da requisição
	 * @param parameters
	 *            parametros
	 * @param data
	 *            Objeto
	 * @param type
	 *            tipo do retorno
	 * @return Retorna objeto preenchido
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static <T> T post(String route, HashMap<String, Object> parameters, Object data, Class<T> type)
			throws MalformedURLException, IOException {
		StringBuffer response = new StringBuffer();
		HttpURLConnection request = createRequest(route);
		request.setRequestMethod("POST");
		request.setRequestProperty("User-Agent", USER_AGENT);
		request.setDoOutput(true);
		if (parameters != null && !parameters.isEmpty()) {
			request.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			String requestString = stringifyParameters(parameters);
			byte[] bytes = requestString.getBytes(StandardCharsets.UTF_8);
			OutputStream os = request.getOutputStream();
			os.write(bytes);
			os.flush();
			os.close();
		} else {
			request.setRequestProperty("Content-Type", "application/json");
			String requestString = (new Gson()).toJson(data);
			byte[] bytes = requestString.getBytes(StandardCharsets.UTF_8);
			OutputStream os = request.getOutputStream();
			os.write(bytes);
			os.flush();
			os.close();
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String inputLine = "";
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return (new Gson()).fromJson(response.toString(), type);
	}

	/**
	 * Metodo utilizado para converter parametros para serem usados na URL
	 * 
	 * @param parameters
	 *            parametros
	 * @return Retorna String com parametros como URL
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unchecked")
	public static <T> String stringifyParameters(HashMap<String, T> parameters) throws UnsupportedEncodingException {
		List<String> queryString = new ArrayList<String>();
		for (String key : parameters.keySet()) {
			T value = parameters.get(key);
			if (value.getClass() == String.class)
				value = (T) URLEncoder.encode(value.toString(), "UTF-8");
			queryString.add(key + "=" + value);
		}
		return String.join("&", queryString);
	}
}
