package com.study;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class json {
    public static void main(String[] args) throws JSONException {
        String jsonStr = "{\"code\":0,\"data\":{\"user\":[{\"mail\":\"abc@gree.com\",\"mobile\":\"13192255007\",\"name\":\"门户用户wnNADl\",\"pinyinKey\":\"mhyhwnnadl\",\"id\":\"USEBP4lZMHQOLpJWYYB2q679ABbL6FuQ1ZuR\",\"username\":\"HeMengWen00\",\"status\":\"正常\"}],\"total_num\":null,\"page_num\":1,\"result_num\":1,\"page_size\":200,\"sql\":null},\"message\":\"success\"}";

        JSONObject jsonObj = new JSONObject(jsonStr);
        JSONArray userArr = jsonObj.getJSONObject("data").getJSONArray("user");
        String mail = userArr.getJSONObject(0).getString("mail");

        System.out.println(mail);
    }
}