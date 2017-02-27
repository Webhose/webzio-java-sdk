# webhose.io client for Java

A simple way to access the [webhose.io](https://webhose.io) API from your Java code

```java
		// Create a WebhoseIOClient instance
		WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(API_KEY);
		
		// Create set of queries
	    Map<String, Object> queries = new HashMap<String, Object>();
	    queries.put("q", "github");
	    
	    JSONObject result = webhoseClient.query("filterWebData", queries);
		System.out.println(result.getTotalResults());
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
**API Endpoints**

The first parameter the `Query` function accepts is the API endpoint string. Available endpoints:
* `filterWebData` - access to the news/blogs/forums/reviews API
* `productSearch` - access to data about eCommerce products/services
* `darkWebAPI` - access to the dark web (coming soon)

	
Now you can make a request and inspect the results:

```java
		// Create set of queries
	    Map<String, Object> queries = new HashMap<String, Object>();
	    queries.put("q", "foobar");
	    
	    JSONObject result = webhoseClient.query("filterWebData", queries);

		System.out.println(result.get("totalResults")); 	// Print posts count
		
		JSONArray postArray = result.getJSONArray("posts");
		
		for(Object o  : postArray) {
			System.out.println(((JSONObject) o).get("title"));	// Print title
			System.out.println(((JSONObject) o).get("author"));	// Print author
			System.out.println(((JSONObject) o).get("language"));	// Print language
		}		
```

## Full documentation
### WebhoseIOClient Class

* getInstance(token)
```java
	WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(TOKEN);
```
  * `token` - your API key
  
  
### Query

* query(endpoint, keyword) - Convenient method to query a specific keyword. Returns JSONObject instance.
```java
		// Create set of queries
	    Map<String, Object> queries = new HashMap<String, Object>();
	    queries.put("q", "github"); // Query using keyword `github`
	    queries.put("size", 3); 	// (OPTIONAL) Limit response to maximum of 3 items
	    
		JSONObject result = webhoseClient.query("filterWebData", queries);

		System.out.println(result.get("totalResults")); 	// Print posts count
		
		JSONArray postArray = result.getJSONArray("posts");
		
		for(Object o  : postArray) {
			System.out.println(((JSONObject) o).get("title"));	// Print title
			System.out.println(((JSONObject) o).get("author"));	// Print author
			System.out.println(((JSONObject) o).get("language"));	// Print language
		}		
```
	* `keyword` - the search query as Map Object query.
  
  Arguments:

  * `endpoint`: 
    * `filterWebData` - access to the news/blogs/forums/reviews API
    * `productSearch` - access to data about eCommerce products/services
    * `darkWebAPI` - access to the dark web (coming soon)


* getNext() - Convenient method to fetch next query page. Returns JSONObject instance.
```java
		JSONObject result = webhoseClient.getNext();

		System.out.println(result.get("totalResults")); 	// Print posts count
		
		JSONArray postArray = result.getJSONArray("posts");
		
		for(Object o  : postArray) {
			System.out.println(((JSONObject) o).get("title"));	// Print title
			System.out.println(((JSONObject) o).get("author"));	// Print author
			System.out.println(((JSONObject) o).get("language"));	// Print language
		}		
```
  -----------------------------------------------------------------------
  

