import wargaming_api.WargamingAPI;
import wargaming_api.Wn8Scrapper;

public class Main {

	public static void main(String[] args) {
		String username = "Szachit";
		WargamingAPI.getStats(WargamingAPI.getUserId(username));
		
		System.out.println(Wn8Scrapper.getWN8(username));
	}

}
