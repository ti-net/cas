<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>天润系统管理平台 - 个人中心</title>
	<link rel="bookmark" href="favicon.ico" />
	<link rel="icon" href="favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/home.css" />
	<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
  </head>  
  <body>

    <div class="hzh_con">
		<div class="top"></div>
		<div class="logo">
			<img src="images/logo.png"/>
			<a href="javascript:void(0);" onclick="logoutSSO()" target="_top">退出</a>
			<span><!-- 您好： --></span>
		</div>
		<div class="bl"></div>
		<div class="home_con">
			<div class="left">
				<div class="t"></div>
				<div class="c">
					<ul>
						<li><label><!-- 角色: --></label><p></p></li>
						<li><label><!-- 全称: --></label><p></p></li>
					</ul>
				</div>
				<div class="b"></div>
			</div>
			<div class="right">
				<div class="t"></div>
				<div class="c">
					<ul>
						<li><a href="http://test.ti-net.com.cn:8080/crm" target="_blank">CRM客户中心</a></li>
						<li><a href="http://test.ti-net.com.cn:8080/boss2" target="_blank">C2营帐中心</a></li>
					</ul>
				</div>
				<div class="b"></div>
			</div>
			<div class="home_clear"></div>
		</div>
		<div class="bottom_white"></div>
	</div>

  </body>
  <script type="text/javascript">
  	function logoutSSO(){
  		var href = window.location.href;
  		window.location.href = href.replace("login", "logout") + "?service=" + href.replace("logout", "login");
  	}
  </script>
  
</html>
