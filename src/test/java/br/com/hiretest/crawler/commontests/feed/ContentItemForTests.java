package br.com.hiretest.crawler.commontests.feed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.hiretest.crawler.feed.model.ContentItem;
import br.com.hiretest.crawler.feed.model.ListContentItem;
import br.com.hiretest.crawler.feed.model.SingleContentItem;

public class ContentItemForTests {
	
	private static ContentItem getContentItem(String type, String... content) {
		
		if ("links".equals(type)) {
			ListContentItem contentItem = new ListContentItem();
			contentItem.setType(type);
			contentItem.setContent(Arrays.asList(content));
			
			return contentItem;
		} else {
			SingleContentItem contentItem = new SingleContentItem();
			contentItem.setType(type);
			contentItem.setContent(content[0]);
			
			return contentItem;
			
		}
	}
	
	public static List<ContentItem> getVolkswagenArteonContents() {
		List<ContentItem> contentItems = new ArrayList<>();
		
		ContentItem contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/DIgFxpN0aAu99uvuZ3WmSqAUV2E=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/1_WKIn5xh.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "A Volkswagen revelou hoje (6) o Arteon, cupê de quatro portas escolhido para suceder o CC – antes chamado Passat CC – e que será apresentado ao público durante o Salão de Genebra. O visual não chega a ser novidade, já que é praticamente o mesmo há dois anos, quando deu as caras no evento suíço como o protótipo Sport Coupé GTE Concept.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/NgWcluzNZLlXwCu9Vs8N1UHXGbI=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/2_aEXyzmK.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "Para encarar o mundo real, a novidade recebeu maçanetas nas portas, antena no teto e alguns detalhes exigidos por lei... e só! Até mesmo as rodas gigantes, os para-choques agressivos e a grade do motor integrada aos faróis continuam ali – para a alegria dos fãs. Além do pacote esportivo R-Line, também haverá opções um pouco mais conservadoras.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/lJKzhfcrbXSzQZRKXCcn7pEIRjw=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/3_BZIDgsI.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "Se por fora tudo é diferente (e muito mais agressivo) comparado aos “irmãos”, o painel segue fiel ao estilo da marca – afinal, é o mesmo do Passat. Não sabemos se a queda do teto compromete o espaço para a cabeça de quem vai atrás, mas os 563 litros do porta-malas são bem aproveitados graças à tampa traseira que abre com o vidro, como um hatch.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/RJ9LxS8YaH4bCAlP1f_1Nm8cocY=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/4_vYYIbul.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "A plataforma é a mesma MQB utilizada no Passat (que, graças ao milagre da modularidade, também serve ao Golf e, futuramente, à nova geração do Gol nacional). São 4,86 metros de comprimento; 1,87 m de largura; 1,42 m de altura; e 2,84 m de entre-eixos. Ainda que pareça um latifúndio, apenas quatro ocupantes viajam com conforto na cabine.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/EDuoev-xcbKnAK_QVWRclJa4Mac=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/5_71gviOe.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "No Velho Continente, serão oferecidos motores a gasolina (1.5 turbo com 150 cv e 2.0 turbo nas opções de 190 cv e 280 cv) e também a diesel (2.0 turbo nas opções de 150 cv, 190 cv e 240 cv). Com exceção das versões de entrada, que têm câmbio manual de seis marchas, a transmissão é sempre automatizada com dupla embreagem e sete marchas.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("links", "http://revistaautoesporte.globo.com/Noticias/noticia/2016/01/os-12-mimos-mais-legais-do-volkswagen-passat.html",
				"http://revistaautoesporte.globo.com/Analises/noticia/2015/11/avaliacao-novo-volkswagen-passat.html");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/fkJMyLGJsX_ThzJBHalbemmcb4M=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/6_pih5QJE.jpg");
		contentItems.add(contentItem);
		
		return contentItems;
		
	}
	
	public static List<ContentItem> getChevroletTrackerContents() {
		List<ContentItem> contentItems = new ArrayList<>();
		
		ContentItem contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/GGm6K8tf2_5qRY--hvCZ44eKPo8=/620x413/e.glbimg.com/og/ed/f/original/2017/10/30/1_VkU3MSO.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "O Chevrolet Tracker recebeu isenção de IPI (Imposto sobre Produtos Industrializados) para pessoas com deficiência e, nessas condições, custará R$ 72.346 – ante os R$ 85.890 pedidos pela versão de entrada LT. Diferentemente de outros modelos, não haverá uma configuração exclusiva para o público PCD, mas descontos de até 16% em relação à tabela.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/lk1HftG34eLOpk3stE3rT_LudiY=/620x413/e.glbimg.com/og/ed/f/original/2017/10/30/2_Vl7XXNF.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "O SUV ganhou novos itens de série e uma versão topo de linha em outubro deste ano. Se a “mais barata” recebeu apenas retrovisores com indicadores de seta, restou à Premier estrear os controles de tração e de estabilidade no Tracker. Por R$ 3.200, dá para acrescentar alertas de colisão frontal e de mudança de faixa, além de airbags laterais e de cortina.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("image", "http://s2.glbimg.com/LCvmFcFA553kW6LM668S74jEHl8=/620x413/e.glbimg.com/og/ed/f/original/2017/10/30/3_2fM69i1.jpg");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "O motor flex 1.4 turbo com injeção direta de combustível rende até 153 cv de potência e 24,5 kgfm de torque. Disponível apenas com câmbio automático de seis marchas, o SUV importado do México chega aos 100 km/h em 9,4 segundos, de acordo com a marca, e consegue médias de 7,3 km/l na cidade e 8,2 km/l na estrada, sempre abastecido com etanol.");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("links", "http://revistaautoesporte.globo.com/Noticias/noticia/2017/10/carro-para-pcd-como-comprar-com-isencao-de-impostos.html",
				"http://revistaautoesporte.globo.com/Noticias/noticia/2017/08/hyundai-interrompe-vendas-do-creta-para-pessoas-com-deficiencia.html");
		contentItems.add(contentItem);
		
		contentItem = ContentItemForTests.getContentItem("text", "Curte o conteúdo da Autoesporte?A edição deste mês e outras matérias exclusivas já estáo disponíveis no nosso app e também no Globo Mais. Baixe agora!App Autoesporte - iOS e AndroidApp Globo Mais - app.globomais.com.brDisponível para tablets e smartphones");
		contentItems.add(contentItem);
		
		return contentItems;
		
	}

}
