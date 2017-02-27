# webhose.io client for Java

A simple way to access the [webhose.io](https://webhose.io) API from your Java code

```java
		WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(API_KEY);
		WebhoseResult result = webhoseClient.query("github");
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
		WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(API_KEY);
```

```java
		WebhoseResult result = webhoseClient.query("github");

		// Print posts count
		System.out.println(result.getTotalResults());
		
		for(Post post : result.getPosts()) {
			System.out.println(post.getTitle());
			System.out.println(post.getAuthor());
			System.out.println(post.getLanguage());
		}		
```
