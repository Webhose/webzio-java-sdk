package com.webz.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.utils.URIBuilder;


public class WebzIOClient {

	private static final String WEBZ_BASE_URL = "http://api.webz.io";
	private static WebzIOClient mClient;
	private String mNext;
	private String mApiKey;

	/**
	 * Private constructor
	 */
	private WebzIOClient() {
	}

	private WebzIOClient(String apiKey) {
		this.mApiKey = apiKey;
	}

	public static WebzIOClient getInstance(String apiKey) {
		if (mClient == null) {
			mClient = new WebzIOClient(apiKey);
		}

		return mClient;
	}

	/**
	 * Convenient method to fetch response from server
	 * 
	 * @param rawUrl Server URL
	 * @return JSONObject Converted server response string 
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	public JsonElement getResponse(String rawUrl) throws IOException, URISyntaxException {

		URL url = new URL(rawUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setDoOutput(true);

		// Get Response
		InputStream is = connection.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		StringBuilder response = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			response.append(line);
		}
		rd.close();

        JsonParser parser = new JsonParser();
        JsonElement o = parser.parse(response.toString());
		
		// Set next query URL
        	mNext = String.format("%s%s", WEBZ_BASE_URL, o.getAsJsonObject().get("next").getAsString());

		return o;
	}

	public JsonElement query(String endpoint, Map<String, String> params) throws URISyntaxException, IOException {
		try {
			URIBuilder builder = new URIBuilder(String.format("%s/%s?token=%s&format=json", WEBZ_BASE_URL, endpoint, mApiKey));
			for (String key : params.keySet()) {
				builder.addParameter(key, params.get(key));
			}		
			
			return getResponse(builder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get next response of current request
	 * @return JSONObject response
	 */
	public JsonElement getNext() throws IOException, URISyntaxException {
		try {
			return  getResponse(mNext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
