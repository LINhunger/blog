<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>邮箱提交界面</title>

    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <%@include file="/WEB-INF/jsp/common/tag.jsp"%>
</head>
<body>
<%--页面显示部分--%>
<!-- Fixed navbar -->

    <form action="/ggblog/user/verification" method="post">
        <input name="email"  value=""  id="email"/>
        <input type="submit" value="验证邮箱"/>
    </form>


</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
