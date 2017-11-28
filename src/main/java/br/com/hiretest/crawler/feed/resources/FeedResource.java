package br.com.hiretest.crawler.feed.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hiretest.crawler.feed.model.FeedWrapper;
import br.com.hiretest.crawler.feed.services.FeedServices;

@RestController
public class FeedResource {

	@Autowired
	private FeedServices feedService;
	
	@GetMapping("/feeds")
	public FeedWrapper getAllFeeds() {
		//mantém o exato formato de saída
		return new FeedWrapper(feedService.retrieve());
	}
}