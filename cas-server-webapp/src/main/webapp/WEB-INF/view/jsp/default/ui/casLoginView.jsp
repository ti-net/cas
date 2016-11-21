<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="pragma" content="no-cache"> 
  <meta http-equiv="cache-control" content="no-cache"> 
  <meta http-equiv="expires" content="0">   
  
  <title>天润融通</title>
  <spring:theme code="standard.custom.css.file" var="customCssFile" />
  <link rel="stylesheet" href="<c:url value="${customCssFile}" />" />
  <link rel="stylesheet" type="text/css" href="css/base.css" />
  <link rel="icon" href="<c:url value="/favicon.ico" />" type="image/x-icon" />
  <link rel="stylesheet" type="text/css" href="css/logoIn.css" />
  <script src="<c:url value="js/jquery-1.4.2.js" />" type="text/javascript" ></script>
  
  <!--[if lt IE 9]>
    <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js" type="text/javascript"></script>
  <![endif]-->
</head>
<body id="cas" style="background:#c5ccde;">
<div class="wrapper">
<div class="innerWrapper">
<div class="bodyWrapper">
<div class="innerBody">
	<div class="contentWrapper">
		<div class="innerContent">

			<div class="contHeader" style="background:url(images/headerBor.jpg) repeat-x bottom;">
				<img src="images/logo.png" alt="天润融通" /><span>统一登录系统</span>
			</div>
			<div class="contBody">
  <form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">
	<ul>
		<li>
		<b for="username">用户名:</b>
		<div class="un" style="background:#e0e6ed url(images/userIcon.gif) no-repeat 5px 6px;">
	      <c:choose>
	        <c:when test="${not empty sessionScope.openIdLocalId}">
	          <strong>${sessionScope.openIdLocalId}</strong>
	          <input type="hidden" id="username" name="username" value="${sessionScope.openIdLocalId}" />
	        </c:when>
	        <c:otherwise>
	          <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
	          <form:input cssClass="required" cssErrorClass="error" id="username" size="25" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" />
	        </c:otherwise>
	      </c:choose>
      	</div>
      	</li>
		<li>
			<b for="password">密&nbsp;&nbsp;&nbsp;码:</b>
			<div class="pw" style="background:#fff url(images/pswIcon.gif) no-repeat 5px 6px;">

      			<spring:message code="screen.welcome.label.password.accesskey" var="passwordAccessKey" />
      			<form:password cssClass="required" cssErrorClass="error" id="password" size="25" tabindex="2" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
    		</div>
    	</li>
		<li>
			<b>验证码:</b>
			<input type="text" id="securityCode" name="securityCode" class="yan" maxlength="4" tabindex="3"/>
			<img id="securityCodeImg" src="securityCode" width="80" height="25" style="margin: 10px 0 0 10px;" />
     	</li>
     	<li>
      		<b>&nbsp;</b>
			<input class="btn-submit but" name="submit" style="background:#98c5f5 url(images/inButBg.gif) repeat-x;" accesskey="l" value="登录" tabindex="4" type="submit"/>
     	</li>
    </ul>
    <section class="row btn-row">
      <input type="hidden" name="lt" value="${loginTicket}" />
      <input type="hidden" name="execution" value="${flowExecutionKey}"/>
      <input type="hidden" name="_eventId" value="submit" />

    </section>
    <form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" />
  </form:form>
  </div></div>
  </div></div></div></div>
</div>
<script type="text/javascript">
	$(function(){
		$("#username").focus();
		$("#securityCodeImg").click(function(){
			$(this).attr("src","securityCode?" + Math.random());
		});
		
		//$("#fm1").attr("action", "cas/login?timestamp=" + (new Date().valueOf()))
		
	});
</script>
</body>
</html>