package com.tinet.cas.dao;
/**
 * 权限验证业务逻辑接口
 * <p>
 *  fileName：AuthWhiteIpService.java
 * <p>
 * 
 * 此处使用了最原始的xml注入方式而不是扫包 + 注解的方式
 * 
 * Copyright (c) 2006-2016 T&I Net Communication CO.,LTD.  All rights reserved.
 * @author 王立力
 * @since 4.0.0
 * @version 4.0.0
 * @see com.tinet.jboss.wm.yeepay.service.AuthWhiteIpService
 * 
 */

public interface AuthWhiteIpService {
	/**
	 * 接口IP验证
	 * 
	 */
	public boolean checkAuth(String ip, Integer type);
}
