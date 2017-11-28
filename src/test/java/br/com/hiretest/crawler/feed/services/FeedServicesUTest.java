package br.com.hiretest.crawler.feed.services;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hiretest.crawler.commontests.feed.FeedForTests;
import br.com.hiretest.crawler.exceptions.IntegrationException;
import br.com.hiretest.crawler.feed.model.Feed;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedServicesUTest {
	
	@Autowired
	private FeedServices feedServices;
	
	@Value("${feed.one-item-feed}")
	private URL oneItemURL;
	
	@Value("${feed.list-item-feed}")
	private URL listItemURL;
	
	@Value("${feed.one-item-feed-with-null-content-item}")
	private URL oneItemFeedWithNullContentItemURL;
	
	@Value("${feed.null-feed}")
	private URL nullFeed;
	
	@Value("${feed.invalid-url}")
	private URL invalidURL;
	
	@Before
	public void setUp() {
		((FeedServicesImpl)feedServices).setURL(null);
	}
	
	@Test
	public void retrieveOneItemFeed() {
		((FeedServicesImpl)feedServices).setURL(oneItemURL);
		
		List<Feed> feeds = feedServices.retrieve();
		
		Assert.assertTrue(!feeds.isEmpty() && feeds.size() == 1);
		Assert.assertTrue(FeedForTests.getOneItemFeed().equals(feeds.get(0)));
	}
	
	@Test
	public void retrieveListItemFeed() {
		((FeedServicesImpl)feedServices).setURL(listItemURL);
		
		List<Feed> feeds = feedServices.retrieve();
		
		Assert.assertTrue(!feeds.isEmpty() && feeds.size() == 2);
		Assert.assertTrue(FeedForTests.getListItemFeed().equals(feeds));
	}
	
	@Test
	public void retrieveOneItemFeedWithNullContentItem() {
		((FeedServicesImpl)feedServices).setURL(oneItemFeedWithNullContentItemURL);
		
		List<Feed> feeds = feedServices.retrieve();
		
		Assert.assertTrue(!feeds.isEmpty() && feeds.size() == 1);
		Assert.assertTrue(FeedForTests.getOneItemFeedWithoutItemContents().equals(feeds.get(0)));
	}
	
	@Test
	public void retrieveNullFeed() {
		((FeedServicesImpl)feedServices).setURL(nullFeed);
		
		List<Feed> feeds = feedServices.retrieve();
		
		Assert.assertTrue(feeds.isEmpty());
	}
	
	@Test(expected=IntegrationException.class)
	public void retrieveIOException() throws IOException {
		((FeedServicesImpl)feedServices).setURL(invalidURL);
		
		feedServices.retrieve();
	}
}
