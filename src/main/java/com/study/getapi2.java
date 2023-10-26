import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import org.json.JSONArray;
        import org.json.JSONObject;
import sun.awt.windows.WPrinterJob;

public class getapi2 {
    private static String getMailByApi(String appKey,String apiToken) {
        try {
            // 定义请求URL和参数
            URL url = new URL("http://easydemo-dev-ds.163yun.com/easy-data-api/dsc_support/ss/ddd?page_num=1&page_size=200");

            // 创建 HttpURLConnection 对象并设置请求方法
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 添加请求header
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("appKey", appKey);
            connection.setRequestProperty("version", "v2");
            connection.setRequestProperty("apiToken", apiToken);

            // 发送请求并获取响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            //System.out.println(response);

            // 解析接口返回数据获取邮箱信息
            JSONObject responseJson = new JSONObject(response.toString());
            System.out.println(responseJson);
            JSONArray userArr = responseJson.getJSONObject("data").getJSONArray("data");
            String email = userArr.getJSONObject(0).getString("mail");
            return email;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) {
        String appKey = "78ca53353219425bad705aa25300f1b1";
        String apiToken = "89806fec95274da1b3147293d8c34da2";
        String email = getMailByApi(appKey,apiToken);
        System.out.println(email);
    }
}