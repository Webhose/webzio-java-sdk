# webz.io client for Java

A simple way to access the [webz.io](https://webz.io) API from your Java code

```java
// Create a WebzIOClient instance
WebzIOClient webzClient = WebzIOClient.getInstance(API_KEY);
// Create set of queries
Map<String, String> queries = new HashMap<String, String>();
queries.put("q", "github");
// Fetch query result
JsonElement result = webzClient.query("filterWebContent", queries);
System.out.println(result.getAsJsonObject().get("totalResults"));     // Print posts count
```
## API Key
	
To make use of the webz.io API, you need to obtain a token that would be
used on every request. To obtain an API key, create an account at
https://webz.io/auth/signup, and then go into
https://webz.io/dashboard to see your token.


## Use the API

To get started, you need to import the library, and set your access token.
(Replace YOUR_API_KEY with your actual API key).

```java
import com.webz.sdk.WebzIOClient;
WebzIOClient webzClient = WebzIOClient.getInstance(API_KEY);
```
	
Now you can make a request and inspect the results:

```java
// Create set of queries
Map<String, String> queries = new HashMap<String, String>();
queries.put("q", "foobar");
	    
JsonElement result = webzClient.query("filterWebContent", queries);
	
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
* `filterWebContent` - access to the news/blogs/forums/reviews API
* `productFilter` - access to data about eCommerce products/services
* `darkFilter` - access to the dark web (coming soon)


## Full documentation
### WebzIOClient Class

**getInstance(token)**
	Initialize WebzIOClient and return an instance. 
	
```java
WebzIOClient webzClient = WebzIOClient.getInstance(TOKEN);
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
JsonElement result = webzClient.query("filterWebContent", queries);

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
   * `filterWebContent` - access to the news/blogs/forums/reviews API
   * `cyberFilter` - access to the dark web/cyber API
   * `nseFilter` - access to the enriched news API
   * `reviewFilter` - access to the reviews API
   * `dbdocFilter` - access to the breach detection API
   * `govFilter` - access to the government data API
   * `nbdSeg` - access to the news/blogs/forums/reviews data segmentation API
   * `enaSeg` - access to the enriched news data segmentation API
   * `reviewSeg` - access to the reviews data segmentation API
   * `cyberSeg` - access to the dark web/cyber data segmentation API


**getNext()**
	Convenient method to fetch next query page. Returns JSONObject instance.

```java
JsonElement result = webzClient.getNext();

System.out.println(result.getAsJsonObject().get("totalResults"));     // Print posts count
		
JsonArray postArray = result.getAsJsonObject().getAsJsonArray("posts");

for(JsonElement o  : postArray) {
	System.out.println(o.getAsJsonObject().get("title"));  // Print title
        System.out.println(o.getAsJsonObject().get("author")); // Print author
        System.out.println(o.getAsJsonObject().get("language"));   // Print language
}
```
  -----------------------------------------------------------------------
  

