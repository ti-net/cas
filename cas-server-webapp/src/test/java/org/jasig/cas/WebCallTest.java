package org.jasig.cas;

import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.tinet.cas.util.MD5Encoder;

public class WebCallTest {

	public static void main(String[] args) {

		String appId = "5000003";
		String token = "27861a51e22301d8ab6f6c6efabe6203";
		Long currTimeStamp = new Date().getTime() / 1000;
		String sign = MD5Encoder.encode(appId + token + currTimeStamp);

		StringBuilder url = new StringBuilder("http://api.vlink.cn/interface/open/v1/webcall");
		url.append("?appId=").append(appId).append("&tel=").append("13716619459").append("&timestamp=")
				.append(currTimeStamp).append("&code=").append("1234").append("&sign=").append(sign);

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url.toString());
		try {
			HttpResponse response = httpClient.execute(httpGet);
			String text = EntityUtils.toString(response.getEntity());

			System.out.println(text);

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
