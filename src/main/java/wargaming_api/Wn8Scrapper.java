package wargaming_api;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Wn8Scrapper {
	
	private final static Logger logger = LogManager.getLogger(Wn8Scrapper.class);
	private final static String url = "https://pl.wot-life.com/eu/player/";
	private final static String path = "#tab1 > table:nth-child(3) > tbody > tr:nth-child(15) > td";
	
	public static double getWN8 (String username) {
		double wn8 = 0;
		
		try {
			Document document = Jsoup.connect(url + username).get();
			Element element = document.select(path).first();
			
			if (element == null) {
				logger.error("Element not found");
				return 1;
			}

			String response = element.toString();
			
			// Check for every s0-9 and replace.
			for (int i = 0; i < 10; i++) {
				response = response.replace("<td colspan=\"2\" class=\"text-right wn s" + String.valueOf(i) + "\">", "");
			}
			
			response = response.replace("</td>", "");
			response = response.replace(",", ".");
			
			logger.info("Success scraping wn8: " + response);
			
			wn8 = Double.parseDouble(response);
			return wn8;
		} catch (IOException e) {
			logger.error("Error scraping wn8.");
			logger.error(e);
		} 
		return wn8;
	}
	
}
