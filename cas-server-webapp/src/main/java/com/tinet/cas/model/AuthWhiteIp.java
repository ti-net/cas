package com.tinet.cas.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 认证白名单实体类
 * <p>
 * 文件名：AuthWhiteIp.java
 * <p>
 * Copyright (c) 2006-2016 T&I Net Communication CO.,LTD. All rights reserved.
 * 
 * @author 王立力
 * @since 4.0.0
 * @version 4.0.0
 */
public class AuthWhiteIp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5612539117758245894L;

	private Integer id;
	private String name;
	private String ip;
	private String comment;
	private Date createTime;
	private Integer type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}