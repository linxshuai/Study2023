import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class get_value {
    private static String getvalueByApi(String email) throws Exception{

// 定义请求URL和参数
            String apiUrl = String.format("http://easydemo-dev-ds.163yun.com/easy-data-api/dsc_support/ss/demoapiiphone?email=%s&page_num=1&page_size=200", email);
            URL url = new URL(apiUrl);

            // 创建 HttpURLConnection 对象并设置请求方法
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 添加请求header
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("appKey", "78ca53353219425bad705aa25300f1b1");
            connection.setRequestProperty("version", "v2");
            connection.setRequestProperty("apiToken", "28b6c8381eb84a66a1a81dfc6388a2b8");

            // 发送请求并获取响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // 解析接口返回数据获取phone信息
            JSONObject responseJson = new JSONObject(response.toString());
        System.out.println(responseJson);
            JSONArray userArr = responseJson.getJSONObject("data").getJSONArray("data");
            String phone = userArr.getJSONObject(0).getString("phone");
            return phone;

    }

    public static void main(String[] args) throws Exception{
//        String email = "linshuai@corp.netease.com";
        String email = "linshuai@corp.netease.com";
        String phone = getvalueByApi(email);
        System.out.println(phone);
    }
}