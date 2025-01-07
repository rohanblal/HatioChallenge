import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConvertorController {
	private final CurrencyService currencyService;
	
	@Autowired
	public CurrencyConvertorController(CurrencyService currencyService) {
		this.currencyService=currencyService;
	}
	@GetMapping("/convert")
	public  ResponseEntity<String> convertCurrency(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        try {
            Map<String, Double> exchangeRates = currencyService.getExchangeRates(from);
            Double exchangeRate = exchangeRates.get(to);
            if (exchangeRate == null) {
                return new ResponseEntity<>("Invalid currency code: " + to, HttpStatus.BAD_REQUEST);
            }
            double convertedAmount = amount * exchangeRate;
            return new ResponseEntity<>(String.format("%.2f %s = %.2f %s", amount, from, convertedAmount, to), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
