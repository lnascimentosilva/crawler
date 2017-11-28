package br.com.hiretest.crawler.feed.resources;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.hiretest.crawler.commontests.feed.FeedForTests;
import br.com.hiretest.crawler.exceptions.IntegrationException;
import br.com.hiretest.crawler.feed.model.Feed;
import br.com.hiretest.crawler.feed.services.FeedServices;
import br.com.hiretest.crawler.utils.reader.Reader;

@RunWith(SpringRunner.class)
@WebMvcTest(value = FeedResource.class, secure = false)
public class FeedResourceUTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Value("${feed.one-item-feed-json}")
	private URL oneItemURL;
	
	@Value("${feed.list-item-feed-json}")
	private URL listItemURL;
	
	@Value("${feed.one-item-feed-with-null-content-item-json}")
	private URL oneItemFeedWithoutItemContentsURL;
	
	@Value("${feed.null-feed-json}")
	private URL nullFeed;
	
	@Value("${feed.internal-error-json}")
	private URL internalError;

	@MockBean
	private FeedServices feedServices;
	
	@Test
	public void retrieveOneItemFeed() throws Exception {
		List<Feed> feeds = new ArrayList<>();
		feeds.add(FeedForTests.getOneItemFeed());
		when(feedServices.retrieve()).thenReturn(feeds);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/feeds").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(Reader.getContent(oneItemURL), response.getContentAsString(), false);
	}
	
	@Test
	public void retrieveListItemFeed() throws Exception {
		when(feedServices.retrieve()).thenReturn(FeedForTests.getListItemFeed());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/feeds").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(Reader.getContent(listItemURL), response.getContentAsString(), false);
	}
	
	@Test
	public void retrieveOneItemFeedWithoutItemContents() throws Exception {
		List<Feed> feeds = new ArrayList<>();
		feeds.add(FeedForTests.getOneItemFeedWithoutItemContents());
		when(feedServices.retrieve()).thenReturn(feeds);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/feeds").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(Reader.getContent(oneItemFeedWithoutItemContentsURL), response.getContentAsString(), false);
	}
	
	@Test
	public void retrieveNullFeed() throws Exception {
		List<Feed> feeds = new ArrayList<>();
		feeds.add(FeedForTests.getNullFeed());
		when(feedServices.retrieve()).thenReturn(feeds);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/feeds").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		JSONAssert.assertEquals(Reader.getContent(nullFeed), response.getContentAsString(), false);
	}
	
	@Test
	public void retrieveInternalError() throws Exception {
		when(feedServices.retrieve()).thenThrow(new IntegrationException("Não foi possível conectar a URL: XPTO", new IOException()));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/feeds").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
		
		JSONAssert.assertEquals(Reader.getContent(internalError), response.getContentAsString(), false);
	}

}
