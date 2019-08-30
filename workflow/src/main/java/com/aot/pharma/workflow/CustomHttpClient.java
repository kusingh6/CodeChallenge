package com.aot.pharma.workflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;
import java.util.Map;
import java.util.Properties;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CustomHttpClient {

	private static final String PHARMA_APP_URL = "pharma.app.url";
	private static final String PHARMA_APP_STATUS_ENDPOINT = "pharma.app.endpoint.status";
	private static final String PUT = "PUT";
	private static final String POST = "POST";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String APPLICATION_JSON = "application/json";
	
	private static final String PHARMA_TOKEN_APP_URL = "pharma.app.url";
	private static final String PHARMA_TOKEN_APP_STATUS_ENDPOINT = "pharma.app.endpoint.status";
	
	
	
	public void get(Map<Object, Object> parameters) {
		throw new UnsupportedOperationException();
	}
	
	public static boolean post(Map<Object, Object> parameters) throws IOException {
		System.out.println("post ======================================================");

		final Properties properties = getSystemProperties();
		System.out.println(properties);
		if(parameters != null && !properties.isEmpty()) {
			validateProperties(properties, parameters);
			final String baseUrl = properties.getProperty(PHARMA_APP_URL);
			System.out.println(baseUrl);

			final String statusEndPoint = properties.getProperty(PHARMA_APP_STATUS_ENDPOINT);
			System.out.println(statusEndPoint);
			final String status = parameters.get("status").toString();
			final String updateEndPoint = baseUrl+statusEndPoint.replaceAll(":(\\w+)", parameters.get("applicationId").toString())+status;
			System.out.println(updateEndPoint);
			
			OutputStream os;
			String token = getAuthToken();
			System.out.println(token);
		
			URL url = new URL(updateEndPoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(PUT);
			conn.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
			conn.setRequestProperty ("Authorization", "Bearer "+token);
			
			os = conn.getOutputStream();
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
		}
		return true;
	}

	private static Properties getSystemProperties() throws IOException {
		Properties props = null;
        try (InputStream input = CustomHttpClient.class.getClassLoader().getResourceAsStream("pharma.properties")) {
        	props = new Properties();
            if (input != null) {
            	 //load a properties file from class path, inside static method
                props.load(input);
            }
        }
		return props;
	}

	private static String getAuthToken()
			throws MalformedURLException, IOException, ProtocolException, UnsupportedEncodingException {
		URL authTokenUrl = new URL("http://keycloak.aottech.com:8080/auth/realms/prime/protocol/openid-connect/token");
		String userName = "service_prime";
		String password = "83a89ee6-354f-4642-9b51-cbd170af4362";
		byte[] encodedBytes = Base64.getEncoder().encode((userName+":"+password).getBytes());
		String basicTokenHeader = "Basic "+ new String(encodedBytes);
		HttpURLConnection tokenConn = (HttpURLConnection) authTokenUrl.openConnection();
		tokenConn.setRequestProperty ("Authorization", basicTokenHeader);
		tokenConn.setRequestMethod(POST);
		tokenConn.setDoOutput(true);
		tokenConn.setDoInput(true);
		
		OutputStream os = tokenConn.getOutputStream();
		BufferedWriter writer = new BufferedWriter(
		        new OutputStreamWriter(os, "UTF-8"));
		writer.write("grant_type=client_credentials");
		writer.flush();
		writer.close();
		os.close();
		tokenConn.connect();
		BufferedReader br = new BufferedReader(new InputStreamReader(tokenConn.getInputStream()));
		StringBuilder tokenResponse = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
		  tokenResponse.append(output);
		}
		JsonParser parser = new JsonParser();
		JsonObject accessTokenObject = parser.parse(tokenResponse.toString()).getAsJsonObject();
		
		return accessTokenObject.get("access_token").getAsString();
	}

	private static void validateProperties(Properties properties, Map<Object, Object> parameters) {
		// TODO Auto-generated method stub		
	}
}
