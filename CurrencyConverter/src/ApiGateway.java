import java.util.Map;

public class ApiGateway {
    String URL;
    Double result;
    ApiGateway(ExchangeRatesApiConfiguration params){
        URL = getURLWithParams(params);
        ApiCaller caller = new ApiCaller(URL, params.getParameters());
        result = Double.parseDouble(caller.result);
    }

    private String getURLWithParams(ExchangeRatesApiConfiguration params) {
        StringBuilder builder = new StringBuilder();
        builder.append(params.getBASE_URL());
        builder.append(params.getENDPOINT());
        builder.append("?");
        for (Map.Entry<String, String> entry : params.getParameters().entrySet()) {
            builder.append(entry.getKey());
            builder.append("=");
            builder.append(entry.getValue());
            builder.append("&");
        }
        builder.deleteCharAt(builder.length()-1); //removes last '&'
        return builder.toString();
    }

}
