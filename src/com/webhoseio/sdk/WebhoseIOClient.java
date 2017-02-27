package com.webhoseio.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;
import com.webhoseio.sdk.models.WebhoseResult;

public class WebhoseIOClient {

	private static WebhoseIOClient mClient;
	private String mApiKey;
	private Gson mGson;

	private WebhoseIOClient() {
	}

	private WebhoseIOClient(String apiKey) {
		this.mApiKey = apiKey;
		
		this.mGson = new Gson();
	}

	public static WebhoseIOClient getInstance(String apiKey) {
		if (mClient == null) {
			mClient = new WebhoseIOClient(apiKey);
		}

		return mClient;
	}

	public WebhoseResult query(String endpoint,  Map<String, Object> queries) {
		try {
			String queryString = "";
			
			for(String key : queries.keySet()) {
				queryString += String.format("%s=%s", key, queries.get(key));
			}
			
			System.out.println("queryString : " + queryString);
			
			URL url = new URL(String.format("http://webhose.io/%s?token=%s&format=json&%s", endpoint, mApiKey, queryString));
			System.out.println(url.toString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
		    connection.setDoOutput(true);

		    //Get Response  
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    StringBuilder response = new StringBuilder();
		    String line;
		    while ((line = rd.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
		    rd.close();
		    return mGson.fromJson(response.toString(), WebhoseResult.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;

	}
}
