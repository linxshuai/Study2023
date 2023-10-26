import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class getapi {
    public static void main(String[] args) {
        try {
            // 定义请求URL和参数
            URL url = new URL("http://easydemo-dev-ds.163yun.com/easy-data-api/dsc_support/ss/ddd?page_num=1&page_size=200");

            // 创建 HttpURLConnection 对象并设置请求方法
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 添加请求头部
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("appKey", "78ca53353219425bad705aa25300f1b1");
            connection.setRequestProperty("version", "v2");
            connection.setRequestProperty("apiToken", "89806fec95274da1b3147293d8c34da2");

            // 发送请求并获取响应
            //创建一个输入流 BufferedReader 对象，用于读取 HttpURLConnection 对象的输入流，并将其存储到 in 变量中.
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // 打印响应结果
            System.out.println(response.toString());

            // 解析接口返回数据获取邮箱信息
            JSONObject responseJson = new JSONObject(response.toString()); // 将响应数据转换为 JSONObject 对象
            JSONArray userArr = responseJson.getJSONObject("data").getJSONArray("data"); // 获取响应数据中的 data 数组,格力最后一个data换成user
            String mail = userArr.getJSONObject(0).getString("mail"); // 获取 data 数组中第一个元素的 mail 字段的值
            System.out.println(mail); // 输出 mail 字段的值

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}