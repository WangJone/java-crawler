import crawling.Crawling;

import java.net.*;
import java.util.List;

public class StartUp {
    public static void main(String[] args)
    {
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        String url = "https://docs.oracle.com/javase/7/docs/api/java/net/CookieManager.html#CookieManager()";
        Crawling crawling = new Crawling();
        crawling.gainHTMLContent(url, "POST",null,null);
        HttpURLConnection httpURLConnection =crawling.getConnection();
        CookieStore cookieStore =cookieManager.getCookieStore();
        List<HttpCookie> list = cookieStore.getCookies();
        for(HttpCookie cookie :list)
        {
            System.out.println(cookie);
        }
    }
}
