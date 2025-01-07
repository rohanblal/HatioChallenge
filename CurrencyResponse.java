import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyResponse {
	@JsonProperty("conversion_rates")
    private Map<String, Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

}
