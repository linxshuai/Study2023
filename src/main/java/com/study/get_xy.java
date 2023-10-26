import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class get_xy {
    public static String callApi(String urlStr, String apiToken, String appKey, String version) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("apiToken", apiToken);
            con.setRequestProperty("appKey", appKey);
            con.setRequestProperty("version", version);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String url = "http://easydemo-dev-ds.163yun.com/easy-data-api/dsc_support/mysql_hive_api/ddd111111?service=https://www.baidu.com/&ticket=ST-ABC123";
        String apiToken = "80330cf0882542e9a6c7b5a833ed2069";
        String appKey = "78ca53353219425bad705aa25300f1b1";
        String version = "v2";
        String result = callApi(url, apiToken, appKey, version);
        System.out.println(result);
    }
}