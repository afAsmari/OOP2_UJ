import java.util.HashMap;
import java.util.Map;

public interface ApiConfig {
    String BASE_URL = new String();
    String ENDPOINT = new String();
    Map<String, String> parameters = new HashMap<>();

    public String getBASE_URL();

    public String getENDPOINT();

    public void setENDPOINT(String ENDPOINT);

    public Map<String, String> getParameters();

    public void setParameters(Map<String, String> parameters);
}
