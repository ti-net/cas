package com.tinet.cas.dao.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinet.cas.dao.LogWebCallService;
import com.tinet.cas.util.CasPropertyPlaceHolderConfigurer;
import com.tinet.cas.util.MD5Encoder;

public class LogWebCallServiceImp implements LogWebCallService {

	/*
	 * private LogWebCallDao logWebCallDao;
	 * 
	 * public void setLogWebCallDao(LogWebCallDao logWebCallDao) {
	 * this.logWebCallDao = logWebCallDao; }
	 * 
	 * public LogWebCallDao getLogWebCallDao() { return logWebCallDao; }
	 */

	private CasPropertyPlaceHolderConfigurer casProperty;

	/**
	 * @param
	 * @return voiceCode
	 */
	@Override
	public String executeWebCall(Integer id, String mobile, String ip) {
		StringBuilder voiceCode = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			int random = (int) (Math.random() * 10);
			voiceCode.append(String.valueOf(random));
		}
		try {
			String appId = casProperty.getWebCallVerifyAppid();
			String token = casProperty.getWebCallVerifyToken();
			Long currTimeStamp = new Date().getTime() / 1000;
			String sign = MD5Encoder.encode(appId + token + currTimeStamp);

			StringBuilder url = new StringBuilder(casProperty.getWebCallVerifyUrl());
			url.append("?appId=").append(appId).append("&tel=").append(mobile).append("&timestamp=")
					.append(currTimeStamp).append("&code=").append(voiceCode).append("&sign=").append(sign);

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url.toString());
			HttpResponse response = httpClient.execute(httpGet);
			String result = EntityUtils.toString(response.getEntity());

			/*
			 * LogWebCall logWebCall = new LogWebCall();
			 * logWebCall.setEntityId(id);
			 * logWebCall.setQueryString(url.toString());
			 * logWebCall.setAuthCode(voiceCode); logWebCall.setCreateTime(new
			 * Date()); this.logWebCallDao.create(logWebCall);
			 */

			// 将entity转换成json
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readValue(result, JsonNode.class);

			jsonNode.get("description").textValue();

			Map<String, Object> resultMap = new HashMap<>();

			if (jsonNode.get("result").equals(1)) {
				resultMap.put("result", false);
				resultMap.put("value", jsonNode.get("description").textValue());
				return mapper.writeValueAsString(resultMap);
			} else {
				resultMap.put("result", true);
				resultMap.put("value", voiceCode);
				resultMap.put("timestamp", new Date().getTime());
				return mapper.writeValueAsString(resultMap);
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "URLEncoder进行utf-8编码异常！";
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return "访问webCall接口异常！";
		} catch (IOException e) {
			e.printStackTrace();
			return "IO异常！";
		} catch (Exception e) {
			e.printStackTrace();
			return "其他异常！";
		}
	}

	public void setCasProperty(CasPropertyPlaceHolderConfigurer casProperty) {
		this.casProperty = casProperty;
	}
}
