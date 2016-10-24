<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>邮箱提交界面</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
</head>
<body>
<%--页面显示部分--%>
<!-- Fixed navbar -->
<h1>请填写您的基本信息</h1>
<form action="/ggblog/user/${ciphertext}/register"  onsubmit="return validate_form(this);" method="post">
    <table >
        <tr>
            <th>请输入您的用户名</th>
            <td>
                <input name="name"  value=""  id="name"/>
            </td>
        </tr>
        <tr>
            <th>请输入您的密码</th>
            <td>
                <input name="password" type="password"  value="" id="password"/>
            </td>
        </tr>
        <tr>
            <th>请输入您的邮箱</th>
            <td>
                <input type="email" name="email" value="${email}" id="email"/>
            </td>
        </tr>
        <tr>
            <th>请输入您的简介</th>
            <td>
                <input name="introduction" value="" id="introduction"/>
            </td>
        </tr>
        <tr>
            <th>验证码: </th>
            <td>
                <input type="text" name="valcode"  id="valcode"/>
            </td>
            <td>
                <img src="/verification" id="myimg" onclick="change();" style= "cursor: pointer;"/ >
            </td>
        </tr>
        <input type="hidden" name="role" value="0"/>
    </table>
    <input type="submit" value="注册" class="submitbutton"/>
</form>

<!--切换验证码-->
<script type="text/javascript">
    function change()
    {
        //切换验证码
        document.getElementById("myimg").src= "/verification?"+new Date().getTime();
    }
</script>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
