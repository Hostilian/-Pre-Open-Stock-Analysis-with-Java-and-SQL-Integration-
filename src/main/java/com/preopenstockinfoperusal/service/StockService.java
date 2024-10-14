@Service
public class StockService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String API_KEY = "your_marketstack_api_key";

    public Stock getStock(String symbol) {
        String url = "http://api.marketstack.com/v1/eod?access_key=" + API_KEY + "&symbols=" + symbol;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        // Add JSON parsing logic here
        return parseResponse(response.getBody());
    }

    private Stock parseResponse(String jsonResponse) {
        // Use ObjectMapper to parse JSON response to Stock object
    }
}
