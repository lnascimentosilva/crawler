package br.com.hiretest.crawler.feed.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.hiretest.crawler.feed.model.ContentItem;
import br.com.hiretest.crawler.feed.model.Feed;
import br.com.hiretest.crawler.feed.model.Item;
import br.com.hiretest.crawler.feed.model.ListContentItem;
import br.com.hiretest.crawler.feed.model.SingleContentItem;
import br.com.hiretest.crawler.utils.normalizer.Normalizer;
import br.com.hiretest.crawler.utils.reader.Reader;
import br.com.hiretest.crawler.utils.regex.MatcherUtils;
import br.com.hiretest.crawler.utils.regex.PatternConstants;

@Service
public class FeedServicesImpl implements FeedServices{

	@Value("${feed.url}")
	private URL url;
	
	/**
	 * Setter for test classes
	 */
	void setURL(URL url) {
		this.url = url;
	}
	
	/**
	 * Preenche o feed de acordo com a URL informada
	 * 
	 * @return Retorna o objeto feed preenchido
	 */
	public List<Feed> retrieve() {
		
		//retrieve the feed content
		String content = Reader.getContent(url);

		// remove tabs, non breaking spaces(&nbsp;) and breaking lines
		String cleanContent = Normalizer.normalizeHtml(content);

		// initialize feeds
		List<Feed> feeds = new ArrayList<>();

		// encontra os primeiros nós <item> na hierarquia do feed, necessário para
		// manter a ordem de leitura
		this.getItems(cleanContent, feeds);

		return feeds;

	}

	/**
	 * Encontra os primeiros nós <item> na hierarquia do feed
	 */
	private void getItems(String content, List<Feed> feeds) {

		Matcher matcher = MatcherUtils.getItemMatcher(content);
		
		while (matcher.find()) {
			Feed feed = new Feed();
			Item item = new Item();
			
			String innerContent = matcher.group(1);
			this.getItemContent(innerContent, item);
			
			feed.setItem(item);
			feeds.add(feed);
		}
	}

	/**
	 * Encontra os nós <title>, <link> e <description> na hierarquia do feed
	 */
	private void getItemContent(String content, Item item) {

		Matcher matcher = MatcherUtils.getItemContentMatcher(content);
		while (matcher.find()) {
			String tagName = matcher.group(1);
			String innerContent = matcher.group(2);

			switch (tagName) {
			case "title":
				item.setTitle(innerContent.replaceAll(PatternConstants.REPLACE_CDATA, ""));
				break;
				
			case "link":
				item.setLink(innerContent);
				break;

			default:
				this.getParagraphAndDiv(innerContent, item);
				break;
			}
		}

	}

	/**
	 * Encontra os nós <p> e <div> na hierarquia do feed
	 */
	private void getParagraphAndDiv(String content, Item item) {

		Matcher matcher = MatcherUtils.getItemContentParagraphAndDivMatcher(content);
		List<ContentItem> descriptionItems = new ArrayList<>();
		while (matcher.find()) {
			String tagName = matcher.group(1);
			String innerContent = matcher.group(2);
			if ("p".equals(tagName)) {
				String pText = innerContent.replaceAll(PatternConstants.REPLACE_HTML_TAGS, "");
				if (!pText.isEmpty()) {
					
					SingleContentItem singleContentItem = new SingleContentItem();
					singleContentItem.setType("text");
					singleContentItem.setContent(pText);
					
					descriptionItems.add(singleContentItem);
				}
			} else {
				ContentItem contentItem = this.getImageAndUnorderedList(innerContent);
				if (contentItem != null) {
					descriptionItems.add(contentItem);
				}				
			}
		}
		
		item.setContent(descriptionItems);

	}

	/**
	 * Encontra os nós <img> e <ul> na hierarquia do feed
	 */
	private ContentItem getImageAndUnorderedList(String content) {

		Matcher matcher = MatcherUtils.getItemContentImageAndUnorderedListMatcher(content);
		while (matcher.find()) {
			String ulContent = matcher.group(1);
			String tagName = matcher.group(2);
			String src = matcher.group(3);

			if ("img".equals(tagName)) {
				
				SingleContentItem singleContentItem = new SingleContentItem();
				singleContentItem.setType("image");
				singleContentItem.setContent(src);
				
				return singleContentItem;
			} else {
				return getHyperlink(ulContent);
			}
		}
		
		return null;
	}
	
	/**
	 * Encontra os nós <a> na hierarquia do feed
	 */
	private ContentItem getHyperlink(String content) {

		Matcher matcher = MatcherUtils.getItemContentHyperlinkMatcher(content);
		
		ListContentItem listContentItem = null;
		List<String> descriptionItemContentList = new ArrayList<>();
		
		while (matcher.find()) {
			String href = matcher.group(1);		
			
			descriptionItemContentList.add(href);			
		}
		
		if (!descriptionItemContentList.isEmpty()) {
			listContentItem = new ListContentItem();
			listContentItem.setType("links");
			listContentItem.setContent(descriptionItemContentList);
		}
		
		return listContentItem;
	}

}
