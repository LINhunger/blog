<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>邮箱验证界面</title>

    <%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <%@include file="/WEB-INF/jsp/common/tag.jsp"%>
</head>
<body>
<%--页面显示部分--%>
<!-- Fixed navbar -->

<h1>${result.state}</h1>
<h1>${result.stateInfo}</h1>
<h1>${result.data}</h1>
<a href="/ggblog/user/form">没有收到？,再发一次</a>


</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
