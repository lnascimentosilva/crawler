package br.com.hiretest.crawler.utils.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.hiretest.crawler.exceptions.IntegrationException;
import br.com.hiretest.crawler.utils.connection.Connection;

@Component
public class Reader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);
	
	private static InputStreamReader getInputStream(URL url) {
		
		//obtem a conexão
		URLConnection urlConnection = Connection.getConnection(url);
		
		try {
			return new InputStreamReader(urlConnection.getInputStream());
		} catch (IOException e) {
			String msg = String.format("Não foi possível criar um stream da URL: %s", url);
			LOGGER.error(msg);
			throw new IntegrationException(msg, e);
		}
		
	}
	
	/**
	 * Obtém o conteúdo da conexão
	 */
	public static String getContent(URL url) {
		
		try (BufferedReader reader = new BufferedReader(Reader.getInputStream(url))){

			StringBuilder stringBuilder = new StringBuilder();
			String inputLine;

			//escreve o conteudo em um StringBuilder
			while ((inputLine = reader.readLine()) != null) {
				stringBuilder.append(inputLine);
			}
			
			return stringBuilder.toString();
		} catch (IOException e) {
			String msg = String.format("Não foi possível ler o conteúdo da URL: %s", url);
			LOGGER.error(msg);
			throw new IntegrationException(msg, e);
		}

		

	}

}
