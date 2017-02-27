package com.webhoseio.sdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

	public WebhoseResult query(String query) {
		try {
			URL url = new URL(String.format("http://webhose.io/search?token=%s&format=json&q=%s", mApiKey, query));
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
