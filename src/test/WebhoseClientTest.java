package test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.webhoseio.sdk.WebhoseIOClient;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


public class WebhoseClientTest {

    public static void main(String[] args)  throws IOException, URISyntaxException {

        WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance("XXX-XXXX-XXXX-XXXX-XXXX");
        Map<String, String> queries = new HashMap<String, String>();
        queries.put("q", "ipod");

        JsonElement result = webhoseClient.query("filterWebData", queries);
        System.out.println(result.getAsJsonObject().get("totalResults"));


        JsonArray postArray = result.getAsJsonObject().getAsJsonArray("posts");

        for(JsonElement o  : postArray) {
            System.out.println(o.getAsJsonObject().get("title"));  // Print title
            System.out.println(o.getAsJsonObject().get("author")); // Print author
            System.out.println(o.getAsJsonObject().get("language"));   // Print language
        }
    }
}