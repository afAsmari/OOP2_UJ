import java.util.HashMap;
import java.util.Map;

public class ExchangeRatesApiConfiguration implements ApiConfig {
    private String BASE_URL = "https://api.exchangeratesapi.io/v1/";
    private String ENDPOINT;
    Map<String, String> parameters = new HashMap<>();

    public String getBASE_URL() {
        return BASE_URL;
    }

    public String getENDPOINT() {
        return ENDPOINT;
    }

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
