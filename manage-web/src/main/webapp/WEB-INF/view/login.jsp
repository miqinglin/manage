<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keys" content="">
<meta name="author" content="">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<style>
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" href="index.html" style="font-size: 32px;">后台管理系统</a>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">

		<form class="form-signin" role="form">
			<h2 class="form-signin-heading">
				<i class="glyphicon glyphicon-user"></i> 用户登录
			</h2>
			<div class="form-group has-success has-feedback">
				<input type="text" class="form-control" id="loginName"
					placeholder="请输入登录账号" autofocus> <span
					class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<input type="password" class="form-control" id="loginPwd"
					placeholder="请输入登录密码" style="margin-top: 10px;"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-success has-feedback">
				<select class="form-control">
					<option value="member">会员</option>
					<option value="user">管理</option>
				</select>
			</div> 
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					记住我
				</label> <br> <label> 忘记密码 </label> <label style="float: right">
					<a href="${APP_PATH}/user/regist">我要注册</a>
				</label>
			</div>
			<a class="btn btn-lg btn-success btn-block" onclick="doLogin()">登录</a>
		</form>
	</div>
	<script src="jquery/jquery-2.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="layer/layer.js"></script>
	<script type="text/javascript">
		function doLogin() {
			var loginName = $("#loginName").val();
			var loginPwd = $("#loginPwd").val();
			if (loginName == "") {
				layer.msg("请输入登录账号", {time : 1000, icon : 7 });
				return;
			}
			if (loginPwd == "") {
				layer.msg("请输入登录密码", {time : 1000, icon : 7 });
				return;
			}
			 var loadingIndex = null;
			$.ajax({
				url: "${APP_PATH}/user/doLogin",
				type : "POST",
				data : {
					"loginName" : loginName,
					"loginPwd" : loginPwd
				},
				beforeSend : function(){
	        		loadingIndex = layer.msg('处理中', {icon: 16});
	        	},
	        	success : function(res){
	        		if(res.code == "000"){
	        			window.location.href = "main";
	        		}else{
	        			layer.msg("用户登录账号或密码不正确", {time:2000, icon:5});
	        		}
	        	}
			});
		}
	</script>
</body>
</html>