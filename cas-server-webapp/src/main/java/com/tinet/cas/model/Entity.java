package com.tinet.cas.model;

import java.io.Serializable;
import java.util.Date;

/**
 * entity用户实体类
 * <p>
 * FileName： Entity.java
 * <p>
 * Copyright (c) 2006-2016 T&I Net Communication CO.,LTD. All rights reserved.
 * 
 * @author 王立力
 * @since 4.0.0
 * @version 4.0.0
 */

public class Entity implements Serializable {

	private static final long serialVersionUID = 7977574163255823955L;

	private Integer id;
	private String entityName;
	private String entityPwd;
	private Integer entityType;
	private Integer entityParent;
	private Integer entityParentType;
	private String entitySn;
	private String fullName;
	private String areaCode;
	private String principal;
	private Integer sex;
	private String sexTitle;
	private String mobile;
	private String tel;
	private String email;
	private String fax;
	private String address;
	private String post;
	private Integer status;
	private String legalPerson;
	private String trade;
	private String businessNo;
	private String question;
	private String answer;
	private String website;
	private Integer certificateType;
	private String certificateId;
	private String certificateTime;
	private String certificateAddress; // 身份证地址
	private String comment;
	private String country;
	private String state;
	private String city;
	private String language;
	private String roleName;
	private String statusDesc;
	private String roleSex;
	private String roleCertificate;
	private String entityParentName;
	private String directSectionId;
	private String payerName;
	private String payerMobile;
	private String payerEmail;
	private Date createTime;
	private Integer pwdStrong;
	private Integer readOnly;

	private String transactorName; // 经办人姓名
	private String transactorMobile; // 经办人手机
	private String transactorEmail; // 经办人邮箱

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityPwd() {
		return entityPwd;
	}

	public void setEntityPwd(String entityPwd) {
		this.entityPwd = entityPwd;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public void setEntityType(Integer entityType) {
		this.entityType = entityType;
	}

	public Integer getEntityParent() {
		return entityParent;
	}

	public void setEntityParent(Integer entityParent) {
		this.entityParent = entityParent;
	}

	public Integer getEntityParentType() {
		return entityParentType;
	}

	public void setEntityParentType(Integer entityParentType) {
		this.entityParentType = entityParentType;
	}

	public String getEntitySn() {
		return entitySn;
	}

	public void setEntitySn(String entitySn) {
		this.entitySn = entitySn;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSexTitle() {
		return sexTitle;
	}

	public void setSexTitle(String sexTitle) {
		this.sexTitle = sexTitle;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateTime() {
		return certificateTime;
	}

	public void setCertificateTime(String certificateTime) {
		this.certificateTime = certificateTime;
	}

	public String getCertificateAddress() {
		return certificateAddress;
	}

	public void setCertificateAddress(String certificateAddress) {
		this.certificateAddress = certificateAddress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getRoleSex() {
		return roleSex;
	}

	public void setRoleSex(String roleSex) {
		this.roleSex = roleSex;
	}

	public String getRoleCertificate() {
		return roleCertificate;
	}

	public void setRoleCertificate(String roleCertificate) {
		this.roleCertificate = roleCertificate;
	}

	public String getEntityParentName() {
		return entityParentName;
	}

	public void setEntityParentName(String entityParentName) {
		this.entityParentName = entityParentName;
	}

	public String getDirectSectionId() {
		return directSectionId;
	}

	public void setDirectSectionId(String directSectionId) {
		this.directSectionId = directSectionId;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerMobile() {
		return payerMobile;
	}

	public void setPayerMobile(String payerMobile) {
		this.payerMobile = payerMobile;
	}

	public String getPayerEmail() {
		return payerEmail;
	}

	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPwdStrong() {
		return pwdStrong;
	}

	public void setPwdStrong(Integer pwdStrong) {
		this.pwdStrong = pwdStrong;
	}

	public Integer getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Integer readOnly) {
		this.readOnly = readOnly;
	}

	public String getTransactorName() {
		return transactorName;
	}

	public void setTransactorName(String transactorName) {
		this.transactorName = transactorName;
	}

	public String getTransactorMobile() {
		return transactorMobile;
	}

	public void setTransactorMobile(String transactorMobile) {
		this.transactorMobile = transactorMobile;
	}

	public String getTransactorEmail() {
		return transactorEmail;
	}

	public void setTransactorEmail(String transactorEmail) {
		this.transactorEmail = transactorEmail;
	}
}