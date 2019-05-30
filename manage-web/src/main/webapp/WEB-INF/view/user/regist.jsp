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
	<link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APP_PATH}/css/login.css">
	<style>
	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="index.html" style="font-size:32px;">后台管理系统</a></div>
        </div>
      </div>
    </nav>

    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in"></i> 用户注册</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginName" placeholder="请输入登录账号" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="loginPwd" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="userName" placeholder="请输入姓名" autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="email" placeholder="请输入邮箱地址" style="margin-top:10px;">
			<span class="glyphicon glyphicon glyphicon-envelope form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<select class="form-control" >
                <option>会员</option>
                <option>管理</option>
            </select>
		  </div>
        <div class="checkbox">
          <label>忘记密码</label>
          <label style="float:right">
            <a href="${APP_PATH}/login">我有账号</a>
          </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="doRegister()" href="#" > 注册</a>
      </form>
    </div>
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/layer/layer.js"></script>
    <script type="text/javascript">
    	function doRegister(){
    		var loginName = $("#loginName").val();
    		if(loginName == ""){
    			layer.msg("请输入登录账号", {time:1000, icon:5});
    			return ;
    		}
    		var loginPwd = $("#loginPwd").val();
    		if(loginPwd == ""){
    			layer.msg("请输入登录密码", {time:1000, icon:7});
    			return ;
    		}
    		var userName = $("#userName").val();
    		if(userName == ""){
    			layer.msg("请输入用户名称", {time:1000, icon:7});
    			return ;
    		}
    		var loadingIndex = null;
    		$.ajax({
    			url: "${APP_PATH}/user/doRegister",
    			type : "POST",
    			contentType:"application/json",
    			data:JSON.stringify({
    				"loginName": loginName,
    				"loginPwd" : loginPwd,
    				"userName" : userName,
    				"email"    : $("#email").val()
    			}),
    			beforeSend : function() {
	    			loadingIndex = layer.msg('处理中', {time:1000, icon: 16});
	    		},
	    		success : function(res){
	    			layer.close(loadingIndex);
	    			if(res.code == "000"){
	    				layer.msg("账号注册成功", {time:3000, icon:6});
// 	    				window.location.href="${APP_PATH}/login";
	    			}else{
	    				layer.msg(res.message, {time:2000, icon:5});
	    			}
	    		}
    		});
    	}
    </script>
  </body>
</html>