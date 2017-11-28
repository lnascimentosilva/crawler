package br.com.hiretest.crawler.commontests.feed;

import br.com.hiretest.crawler.feed.model.Item;

public class ItemForTests {
	
	public static Item getVolkswagenArteon() {
		Item item = new Item();
		
		item.setTitle("Volkswagen Arteon aparece às vésperas do Salão de Genebra");
		item.setLink("http://revistaautoesporte.globo.com/Noticias/noticia/2017/03/volkswagen-arteon-aparece-vesperas-do-salao-de-genebra.html");
		item.setContent(ContentItemForTests.getVolkswagenArteonContents());
		
		return item;
		
	}
	
	public static Item getChevroletTracker() {
		Item item = new Item();
		
		item.setTitle("Chevrolet Tracker ganha isenções para PCD e parte de R$ 72.346");
		item.setLink("http://revistaautoesporte.globo.com/Noticias/noticia/2017/11/chevrolet-tracker-ganha-isencoes-para-pcd-e-parte-de-r-72346.html");
		item.setContent(ContentItemForTests.getChevroletTrackerContents());
		
		return item;
		
	}

}
