<%--
  Created by IntelliJ IDEA.
  User: heling
  Date: 2019/9/30
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title there</title>
  </head>
  <body>
    未注册的用户，请<a href="${pageContext.request.contextPath }/register"> 注册</a>！
    <br/>
    已注册的用户，去<a href="${pageContext.request.contextPath }/login"> 登录</a>！
  </body>
</html>
