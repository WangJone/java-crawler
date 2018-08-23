package crawling;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Crawling {


private HttpURLConnection connection = null;
private URL url = null;
private BufferedReader bufferedReader = null;
private StringBuffer stringBuffer = null;


public Crawling() {
}


    /**
     * Post or ang other methods
     * @param urlstr
     * @param method
     * @param map
     * @param jsonObject
     * @return
     */
    public String gainHTMLContent(String urlstr, String method, Map<String,String> map,String jsonObject)
{
    stringBuffer = new StringBuffer("");
    try {
        this.url = new URL(urlstr);
        this.connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(10*1000);
        if(method!=null) {
             connection.setRequestMethod(method.toUpperCase());
             //Set request header
             if (!map.isEmpty()) {
                 for (Map.Entry<String, String> entry : map.entrySet()) {
                     connection.setRequestProperty(entry.getKey(), entry.getValue());
                 }
             }
             //Send or get the data
             byte [] data = jsonObject.toString().getBytes();
             OutputStream outputStream =  connection.getOutputStream();
             outputStream.write(data);
             outputStream.flush();
             outputStream.close();
         }
         //Response code==200 ,then return the context from response
        getContent(stringBuffer);
    }
    catch (IOException e){
        e.printStackTrace();
    }
    catch(SecurityException e){
        e.printStackTrace();
    }
    catch (IllegalArgumentException e)
    {
        e.printStackTrace();
    }
    catch (UnsupportedOperationException e)
    {
        e.printStackTrace();
    }
    finally {
        return stringBuffer.toString();
    }
}

    /**
     * Get method
     * @param urlstr
     */
    public String gainHTMLContent(String urlstr)
    {
    StringBuffer data =new StringBuffer();
    try {
        this.url = new URL(urlstr);
        this.connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(10*1000);
        //Response code==200 ,then return the content from response
        getContent(data);
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return data.toString();
    }


    /**
     * Return the content from the website
     * @param data
     * @throws IOException
     */
    public void getContent(StringBuffer data) throws IOException {
        if(connection.getResponseCode()== 200 )
        {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String s = null;
            while((s = bufferedReader.readLine())!=null)
            {
                data.append(s).append("\n");
            }
        }
        else{
            data.append("error:"+connection.getResponseCode());
        }
    }
    public HttpURLConnection getConnection()
    {
        return this.connection;
    }

}
