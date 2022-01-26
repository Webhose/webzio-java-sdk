package test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.webz.sdk.WebzIOClient;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


public class WebzClientTest {

	public static void main(String[] args) throws IOException, URISyntaxException {

		WebzIOClient webzClient = WebzIOClient.getInstance("670f37a4-2e44-49be-afbb-10a92a25c664");
		Map<String, String> params = new HashMap<String, String>();
		params.put("q", "ipod");

		JsonElement result = webzClient.query("filterWebData", params);
		System.out.println(result.getAsJsonObject().get("totalResults"));

		JsonArray postArray = result.getAsJsonObject().getAsJsonArray("posts");

		for (JsonElement o : postArray) {
			System.out.println(o.getAsJsonObject().get("title")); // Print title
			System.out.println(o.getAsJsonObject().get("author")); // Print author
			System.out.println(o.getAsJsonObject().get("language")); // Print language
		}
	}
}
