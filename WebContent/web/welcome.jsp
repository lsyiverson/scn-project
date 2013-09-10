<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>四川广电工程管理系统</title>
    <link href="<s:url value="/css/examplecss"/>" rel="stylesheet"
          type="text/css"/>
</head>

<body>
<h3>四川广电工程管理系统</h3>

<s:form action="Login" theme="simple">
    用户名：<s:textfield key="username"/><br>
    密　码：<s:password key="password"/><br>
    <s:submit value="登陆"/>
</s:form>

<%-- <ul>
    <li><a href="<s:url action="Login_input"/>">Sign On</a></li>
    <li><a href="<s:url action="Register"/>">Register</a></li>
</ul> --%>

</body>
</html>
