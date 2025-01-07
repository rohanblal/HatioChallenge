import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CurrencyService {
	@Value("${currency.api.url}")
	private String apiUrl;
	private final RestTemplate restTemplate;
	public CurrencyService(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	public Map<String, Double> getExchangeRates(String baseCurrency) {
	    try {
	        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).queryParam("base", baseCurrency).toUriString();
	        System.out.println("Request URL: " + url);
	        CurrencyResponse response = restTemplate.getForObject(url, CurrencyResponse.class);
	        System.out.println("API Response: " + response);
	        
	        if (response != null && response.getRates() != null) {
	            return response.getRates();
	        }

	        throw new IllegalStateException("Invalid API response");
	    } catch (HttpClientErrorException e) {
	        System.err.println("API call failed: " + e.getMessage());
	        throw new RuntimeException("API Error: " + e.getStatusCode() + " " + e.getResponseBodyAsString(), e);
	    } catch (RestClientException e) {
	        System.err.println("Error calling API: " + e.getMessage());
	        throw new RuntimeException("Error calling API", e);
	    }catch (Exception e) {
	        throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
	    }
	}

}
