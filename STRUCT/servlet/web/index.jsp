<%--
  Created by IntelliJ IDEA.
  User: heling
  Date: 2019/11/5
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <h3>
    当前在线人数为：<%=application.getAttribute("intOnlinePersonCount") %>
  </h3>
  <a href="<%=response.encodeUrl("logout.jsp") %>">退出登录</a>
  </body>
</html>
