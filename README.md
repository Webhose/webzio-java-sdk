# webhose.io client for Java

A simple way to access the [webhose.io](https://webhose.io) API from your Java code

```java
		// Create a WebhoseIOClient instance
		WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(API_KEY);
		// Create set of queries
	    Map<String, String> queries = new HashMap<String, String>();
	    queries.put("q", "github");
	    // Fetch query result
	    JsonElement result = webhoseClient.query("filterWebData", queries);
        System.out.println(result.getAsJsonObject().get("totalResults"));     // Print posts count
```
## API Key
	
To make use of the webhose.io API, you need to obtain a token that would be
used on every request. To obtain an API key, create an account at
https://webhose.io/auth/signup, and then go into
https://webhose.io/dashboard to see your token.


## Use the API

To get started, you need to import the library, and set your access token.
(Replace YOUR_API_KEY with your actual API key).

```java
		import com.webhoseio.sdk.WebhoseIOClient;

		WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(API_KEY);
```
	
Now you can make a request and inspect the results:

```java
		// Create set of queries
	    Map<String, String> queries = new HashMap<String, String>();
	    queries.put("q", "foobar");
	    
	    JsonElement result = webhoseClient.query("filterWebData", queries);
	
		System.out.println(result.getAsJsonObject().get("totalResults"));     // Print posts count
		
		JsonArray postArray = result.getAsJsonObject().getAsJsonArray("posts");

        for(JsonElement o  : postArray) {
            System.out.println(o.getAsJsonObject().get("title"));  // Print title
            System.out.println(o.getAsJsonObject().get("author")); // Print author
            System.out.println(o.getAsJsonObject().get("language"));   // Print language
        }
```
	
	
***API Endpoints***

The first parameter the `Query` function accepts is the API endpoint string. Available endpoints:
* `filterWebData` - access to the news/blogs/forums/reviews API
* `productSearch` - access to data about eCommerce products/services
* `darkWebAPI` - access to the dark web (coming soon)


## Full documentation
### WebhoseIOClient Class

**getInstance(token)**
	Initialize WebhoseIOClient and return an instance. 
	
```java
	WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(TOKEN);
```
  * `token` - your API key
  
  
### Query

**query(endpoint, queries)**
	Convenient method to query a specific keyword. Returns JSONObject instance.

```java
		// Create set of queries
	    Map<String, String> queries = new HashMap<String, String>();
	    queries.put("q", "github"); // Query using keyword "github"
	    queries.put("size", "3"); 	// (OPTIONAL) Limit response to maximum of 3 items
	    // Fetch query result
		JsonElement result = webhoseClient.query("filterWebData", queries);

        System.out.println(result.getAsJsonObject().get("totalResults"));     // Print posts count

        JsonArray postArray = result.getAsJsonObject().getAsJsonArray("posts");

        for(JsonElement o  : postArray) {
            System.out.println(o.getAsJsonObject().get("title"));  // Print title
            System.out.println(o.getAsJsonObject().get("author")); // Print author
            System.out.println(o.getAsJsonObject().get("language"));   // Print language
        }
```

* queries - a set of key value hashmap for each parameter to be passed to the API endpoint. 
* endpoint 
   * `filterWebData` - access to the news/blogs/forums/reviews API
   * `productSearch` - access to data about eCommerce products/services
   * `darkWebAPI` - access to the dark web (coming soon)


**getNext()**
	Convenient method to fetch next query page. Returns JSONObject instance.

```java
		JsonElement result = webhoseClient.getNext();

		System.out.println(result.getAsJsonObject().get("totalResults"));     // Print posts count
		
		JsonArray postArray = result.getAsJsonObject().getAsJsonArray("posts");

        for(JsonElement o  : postArray) {
            System.out.println(o.getAsJsonObject().get("title"));  // Print title
            System.out.println(o.getAsJsonObject().get("author")); // Print author
            System.out.println(o.getAsJsonObject().get("language"));   // Print language
        }
```
  -----------------------------------------------------------------------
  

