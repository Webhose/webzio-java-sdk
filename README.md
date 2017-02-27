# webhose.io client for Java

A simple way to access the [webhose.io](https://webhose.io) API from your Java code

```java
		WebhoseIOClient webhoseClient = WebhoseIOClient.getInstance(API_KEY);
		WebhoseResult result = webhoseClient.query("github");
		System.out.println(result.getTotalResults());
```
