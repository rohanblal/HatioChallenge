import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

	class CurrencyServiceTest {

	    private CurrencyService currencyService;

	    @BeforeEach
	    void setUp() {
	        currencyService = new CurrencyService(new RestTemplate());
	    }

	    @Test
	    void testGetExchangeRates_Success() {
	        try {
	            var rates = currencyService.getExchangeRates("USD");
	            assertNotNull(rates);
	            assertTrue(rates.containsKey("EUR"));
	            assertTrue(rates.get("EUR") > 0);
	        } catch (Exception e) {
	            fail("API call failed: " + e.getMessage());
	        }
	    }

	    @Test
	    void testGetExchangeRates_Failure() {
	        try {
	            var rates = currencyService.getExchangeRates("INVALID");
	            fail("Expected exception for invalid currency");
	        } catch (RuntimeException e) {
	            assertTrue(e.getMessage().contains("Error calling API"));
	        }
	    }
	}

