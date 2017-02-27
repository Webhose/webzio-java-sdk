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

### WebhoseClient Instance

* getInstance(token)

  * token - your API key

* search(endpoint, query)

	* `query` - the search query as Map Object query.
  

### WebhoseQuery class

WebhoseQuery objects correspond to the advanced search options that appear on https://webhose.io/use

WebhoseQuery objects have the following members:

* ``allTerms`` - a list of strings, all of which must appear in the results
* ``someTerms`` - a list of strings, some of which must appear in the results
* ``phrase`` - a phrase that must appear verbatim in the results
* ``exclude`` - terms that should not appear in the results
* ``siteType`` - one or more of ``discussions``, ``news``, ``blogs``
* ``language`` - one or more of language names, in lowercase english
* ``site`` - one or more of site names, top level only (i.e., yahoo.com and not news.yahoo.com)
* ``title`` - terms that must appear in the title
* ``bodyText`` - term that must appear in the body text

Query objects implement the ``toString()`` method, which shows the resulting search string.

### WebhoseResponse class

Response objects have the following members:

* ``totalResults`` - the total number of posts which match this search
* ``moreResultsAvailable`` - the number of posts not included in this response
* ``posts`` - a list os Post objects
* ``next`` - a URL for the next results page for this search

Response objects implement the ``__iter__()`` method, which can be used to loop
over all posts matching the query. (Automatic page fetching)

### WebhosePost and WebhoseThread classes

WebhosePost and WebhoseThread object contain the actual data returned from the
API. Consult https://webhose.io/documentation to find out about their structure.
