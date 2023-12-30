import wargaming_api.WargamingAPI;

public class Main {

	public static void main(String[] args) {
		String username = "Szachit";
		WargamingAPI.getStats(WargamingAPI.getUserId(username));
		
	}

}
