<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录认证 - 人人微服务</title>
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style>
    body {
        background:url(../images/login_bg.jpg) #00b4ef;
    }
    .form-horizontal {
        background: #fff;
        padding-bottom: 40px;
        border-radius: 10px;
        text-align: center;
    }
    .form-horizontal .heading {
        display: block;
        font-size: 28px;
        font-weight: 700;
        padding: 20px 0;
        border-bottom: 1px solid #f0f0f0;
        margin-bottom: 30px;
    }
    .form-horizontal .form-group {
        padding: 0 40px;
        margin: 0 0 25px 0;
        position: relative;
    }
    .form-horizontal .form-control {
        background: #f0f0f0;
        border: none;
        border-radius: 10px;
        box-shadow: none;
        padding: 0 20px 0 45px;
        height: 40px;
        transition: all 0.3s ease 0s;
    }
    .form-horizontal .form-control:focus {
        background: #e0e0e0;
        box-shadow: none;
        outline: 0 none;
    }
    .form-horizontal .form-group i {
        position: absolute;
        top: 12px;
        left: 60px;
        font-size: 17px;
        color: #c8c8c8;
        transition: all 0.5s ease 0s;
    }
    .form-horizontal .form-control:focus + i {
        color: #00b4ef;
    }
    .form-horizontal .btn {
        font-size: 14px;
        border-radius: 6px;
        padding: 10px 25px;
        width: 380px;
        color: rgb(255 255 255);
        background-color: rgb(235 103 9);
        border-color: rgb(235 103 9);
    }
    .form-main {
        width: 460px;
        margin: 0 auto;
    }
    .aui-page-footer {
        position: absolute;
        bottom: 0;
        padding: 15px;
        color: rgb(144 147 153);
        left: 0;
        right: 0;
        text-align: center;
    }
    .aui-page-footer a {
        color: rgb(239 133 58);
        text-decoration: none;
    }
    .aui-page-footer a:hover {
        color: rgb(235 103 9);
    }
</style>
<body>
<div style="padding-top: 160px;">
    <div class="container">
        <div class="row">
            <div class="form-main">
                <form class="form-horizontal" action="../sso/login" method="post">
                    <span class="heading">登录认证</span>
                    <div class="form-group">
                        <input type="text" class="form-control" name="username" placeholder="账号"><i class="fa fa-user"></i>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="密码"><i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<footer class="aui-page-footer">
    <p><a href="https://www.yy.com/" target="_blank">yy</a> 2022 © yy.com</p>
</footer>
</body>
</html>