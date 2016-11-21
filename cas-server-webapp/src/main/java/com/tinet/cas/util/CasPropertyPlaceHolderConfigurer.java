/**
 * 
 */
package com.tinet.cas.util;

/**
 * @author wangll
 *
 */
public class CasPropertyPlaceHolderConfigurer {

	private String webCallVerifyUrl;
	private String webCallVerifyAppid;
	private String webCallVerifyToken;

	public String getWebCallVerifyUrl() {
		return webCallVerifyUrl;
	}

	public void setWebCallVerifyUrl(String webCallVerifyUrl) {
		this.webCallVerifyUrl = webCallVerifyUrl;
	}

	public String getWebCallVerifyAppid() {
		return webCallVerifyAppid;
	}

	public void setWebCallVerifyAppid(String webCallVerifyAppid) {
		this.webCallVerifyAppid = webCallVerifyAppid;
	}

	public String getWebCallVerifyToken() {
		return webCallVerifyToken;
	}

	public void setWebCallVerifyToken(String webCallVerifyToken) {
		this.webCallVerifyToken = webCallVerifyToken;
	}

}
