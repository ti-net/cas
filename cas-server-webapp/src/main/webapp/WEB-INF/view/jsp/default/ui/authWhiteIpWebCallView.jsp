<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>天润融通</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/logoIn.css" />
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
	<style type="text/css">
		.yanVoice {
			float:left;
			display:inline;
			width:100px;
			height:30px;
			border:1px #bfcadb solid;
			background:#fff;
			margin:7px 0px 0px 0px;
			padding:4px 4px 4px 4px;
			font-size:12px;
			color:gray;
		}
		#msg.errors{
			color: #BB0000;
			padding-left: 60px;
		}
	</style>
</head>
	<body style="height: 100%;">
		<div class="wrapper">
			<div class="innerWrapper">
				<!--body-->
				<div class="bodyWrapper">
					<div class="innerBody">
						<div class="contentWrapper">
							<div class="innerContent">
								<div class="contHeader">
									<img src="images/logo.png" alt="天润融通统一登录系统" /><span>统一登录系统</span>
								</div>
								<div class="contBody">
									<ul>
										<form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true">
											<li>
												<b style="width: 70px">语音验证码:</b>
												<input id="voiceCode" type="text" name="voiceCode" style="color:gray" class="validate[required,custom[numberGTZero]] yanVoice" 
													maxlength="4" placeholder="请输入语音验证码"/>
												<input id="entityId" name="entityId" type="hidden" value="${entityId}" />
											</li>
											<li>
												<b>&nbsp;</b>
												<input type="submit" class="but" style="background:#98c5f5 url(images/inButBg.gif) repeat-x;" value="确定"  name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;
												<input id="btnBack" type="button" style="background:#98c5f5 url(images/inButBg.gif) repeat-x;" class="but" value="返回" onclick="location.href='login'"/>
											</li>
											<li>
												<form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false" />
											</li>
											<li>
												<font color="gray">
													由于您当前IP无法登录，需要输入语音验证码，<br/>
													请接听手机语音播报，并在5分钟内验证，过期无效！<br/>
													语音验证码输入错误5次将重新登录！
												</font>
											</li>
										    <input type="hidden" name="lt" value="${loginTicket}" />
										    <input type="hidden" name="execution" value="${flowExecutionKey}"/>
										    <input type="hidden" name="_eventId" value="submitVoiceCode" />											
										</form:form>
									</ul>
								</div><!--end of contBody -->
							</div><!--end of innerContent -->
						</div><!--end of contentWrapper -->
						<div class="footerBg"></div>	
					</div><!--end of innerBody -->
				</div><!--end of bodyWrapper -->
				<!--body-->
			</div><!--end of innerWrapper -->
		</div><!--end of wrapper -->
	</body>
	<script type="text/javascript">
		$(function(){
			$("#voiceCode").click(function(){
				$(this).removeAttr("style");
			});
		});
	</script>
</html>