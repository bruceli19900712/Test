package cn.itcast.httpclient;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DoGET {

    public static void main(String[] args) throws Exception {

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        

        // 创建http GET请求
      HttpGet httpGet = new HttpGet( "https://www.baidu.com" );
      
      CloseableHttpResponse response=null;
      
      response = httpClient.execute( httpGet );
      System.out.println( response );
      try {
    	  if(response.getStatusLine().getStatusCode()==200){
        	  System.out.println( response.getEntity().toString() );
        	  String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        	  System.out.println("内容长度：" + content.length());
        	  FileUtils.writeStringToFile( new File( "c://baidu.html" ), content );
          }
	}finally{
		if(response!=null ){
			response.close();
		}
		httpClient.close();
	}


}
}
