package br.com.hiretest.crawler.commontests.feed;

import java.util.ArrayList;
import java.util.List;

import br.com.hiretest.crawler.feed.model.Feed;
import br.com.hiretest.crawler.feed.model.Item;

public class FeedForTests {
	
	public static Feed getOneItemFeed() {
		Feed feed = new Feed();
		
		feed.setItem(ItemForTests.getVolkswagenArteon());
		
		return feed;
	}
	
	public static List<Feed> getListItemFeed() {
		List<Feed> feeds = new ArrayList<>(2);
		
		Feed feed = new Feed();
		feed.setItem(ItemForTests.getVolkswagenArteon());
		feeds.add(feed);
		
		feed = new Feed();
		feed.setItem(ItemForTests.getChevroletTracker());
		feeds.add(feed);
		
		return feeds;
	}
	
	public static Feed getOneItemFeedWithoutItemContents() {
		Feed feed = new Feed();		

		Item item = ItemForTests.getVolkswagenArteon();		
		item.setContent(null);
		
		feed.setItem(item);
		
		return feed;
	}
	
	public static Feed getNullFeed() {
		return null;
	}
	

}
