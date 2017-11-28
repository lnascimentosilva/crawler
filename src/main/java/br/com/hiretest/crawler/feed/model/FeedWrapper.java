package br.com.hiretest.crawler.feed.model;

import java.util.List;

public class FeedWrapper {
	
	private List<Feed> feed;
	
	public FeedWrapper(List<Feed> feeds) {
		this.feed = feeds;
	}

	public List<Feed> getFeed() {
		return feed;
	}

	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}
}
