package com.study;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class get_easytaskops {
    private static void callApi() throws Exception {
        URL url = new URL("http://easydemo-dev-ds.163yun.com/easy-data-api/dsc_support/ss/ddd111");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("appKey", "78ca53353219425bad705aa25300f1b1");
        connection.setRequestProperty("version", "v2");
        connection.setRequestProperty("apiToken", "b3b1edb432bb40afbd2e3ad65be010ae");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("API request failed, response code: " + responseCode);
        }
    }}
