package com.webhoseio.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public class WebhoseIOClient {

	private static final String WEBHOSE_BASE_URL = "http://webhose.io";
	private static WebhoseIOClient mClient;
	private String mNext;
	private String mApiKey;

	/**
	 * Private constructor
	 */
	private WebhoseIOClient() {
	}

	private WebhoseIOClient(String apiKey) {
		this.mApiKey = apiKey;
	}

	public static WebhoseIOClient getInstance(String apiKey) {
		if (mClient == null) {
			mClient = new WebhoseIOClient(apiKey);
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
	public JSONObject getResponse(String rawUrl) throws IOException, URISyntaxException {
		System.out.println("Connecting to url : " + rawUrl);
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
			response.append('\r');
		}
		rd.close();
		
		JSONObject o = new JSONObject(response.toString());
		
		// Set next query URL
		mNext = WEBHOSE_BASE_URL + o.getString("next");

		return o;
	}

	public JSONObject query(String endpoint, Map<String, String> queries) {
		try {
			URIBuilder builder = new URIBuilder(String.format("%s/%s?token=%s&format=json", WEBHOSE_BASE_URL, endpoint, mApiKey));
			for (String key : queries.keySet()) {
				builder.addParameter(key, queries.get(key));
			}		
			
			return getResponse(builder.toString());
		} catch (JSONException | IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get next response of current request
	 * @return JSONObject response
	 */
	public JSONObject getNext() {
		try {
			return  getResponse(mNext);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
