import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiCaller {
    URL url;
    HttpsURLConnection conn;
    String result;
    Map<String, String> parameters = new HashMap<>();
    ApiCaller(String URL, Map<String, String> keys){
        try{
            this.url = new URL(URL);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int status = conn.getResponseCode();
            Object content = conn.getContent();
            String jsonString = content.toString();
            JSONObject jsonResponse = new JSONObject(jsonString);
            result = jsonResponse.getString("result");
        }catch(MalformedURLException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }

    }
}
