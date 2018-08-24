
import crawling.Crawling;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartUp {
    public static void main(String[] args)
    {
        HttpURLConnection connection = null;
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        String urlstr = new String("https://full.odrcloud.net/personal/login/admin");
        String map = "{\"name\":\"5958234274\",\"pwd\":\"123456\"}";
        byte [] bytes = map.getBytes();
        try{
            URL url = new URL(urlstr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            //post 请求不能使用缓存
            connection.setUseCaches(false);
            connection.setRequestProperty("Accept","application/json, text/plain, */*");
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.33 Safari/537.36");
            connection.setRequestMethod("POST");
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
            System.out.println("code"+connection.getResponseCode());

            if (connection != null && connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                CookieStore cookieStore = cookieManager.getCookieStore();
                List<HttpCookie> list = cookieStore.getCookies();
                System.out.println("Cookies here");
                for (HttpCookie httpCookie : list) {
                    System.out.println(httpCookie);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
