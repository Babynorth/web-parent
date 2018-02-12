
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
    <meta charset="utf-8">
    <title>基础项目</title>
    <link rel="shortcut icon" href="img/favicon.ico.gif" type="image/x-icon" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- CSS -->
    <link rel="stylesheet" href="login/css/reset.css">
    <link rel="stylesheet" href="login/css/supersized.css">
    <link rel="stylesheet" href="login/css/style.css">

</head>

<body oncontextmenu="return false">

<div class="page-container">
    <h1>登录</h1>
    <form action="" method="post">
        <div>
            <input type="text" name="username" class="username" placeholder="Username" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="Password" oncontextmenu="return false" onpaste="return false" />
        </div>
        <button id="submit" type="button">Sign in</button>
    </form>
    <div class="connect">
        <p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>
        <p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
    </div>
</div>
<div class="alert" style="display:none">
    <h2>消息</h2>
    <div class="alert_con">
        <p id="ts"></p>
        <p style="line-height:70px"><a class="btn">确定</a></p>
    </div>
</div>

<!-- Javascript -->

<!--[if !IE]> -->
<script src="assets/js/jquery-2.0.3.min.js" type="text/javascript"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="assets/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<![endif]-->
<script src="login/js/supersized.3.2.7.min.js"></script>
<script src="login/js/supersized-init.js"></script>
<script>
    var u = $("input[name=username]");
    var p = $("input[name=password]");
    $("#submit").click(function() {
        if(u.val() == '' || p.val() ==''){
            alert("用户名或密码不能为空！");
            return false;
        } else {
            window.location.href="index.jsp";
        }
    });
</script>
</body>

</html>

