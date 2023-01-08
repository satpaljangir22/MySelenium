package application.apis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	public int get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGetRequest = new HttpGet(url); //GET Request
		CloseableHttpResponse httpGetResponse = httpClient.execute(httpGetRequest); //Hit GET Request
		
		int statusCode = httpGetResponse.getStatusLine().getStatusCode();
		System.out.println("Status code: " + statusCode);
		
		String responseString = EntityUtils.toString(httpGetResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response: " + responseJson);
		
		Header[] responseHeaders = httpGetResponse.getAllHeaders();
		
		Map<String, String> allHeaders = new HashMap<String, String>();
		for(Header responseHeader : responseHeaders) {
			allHeaders.put(responseHeader.getName(), responseHeader.getValue());
		}
		System.out.println("Headers: " + allHeaders);
		
		return statusCode;
	}
}
