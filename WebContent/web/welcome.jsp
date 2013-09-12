<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>四川广电工程管理系统</title>
<link href="<s:url value="/css/examplecss"/>" rel="stylesheet"
          type="text/css"/>
</head>

<body topmargin="50">

    <table width="800" height="400" border="0" align="center"
        bordercolor="#F0F0F0">

        <tr align="center" bgcolor="#33B5E5">
            <td colspan="2" bgcolor="#33B5E5">
                <h2><font color="white">四川广电工程管理系统</font></h2>
            </td>
        <tr>
            <td width="456" height="300" background="<%=request.getContextPath()%>/img/network01.jpg">&nbsp;</td>
            <td width="375" align="center">
            <s:form action="Login">
                <s:textfield name="username" label="用户名" cssStyle="width:140px"/>
                <s:password name="password" label="密　码" cssStyle="width:140px"/>
                <s:submit value="登陆" />
            </s:form>
          </td>
        </tr>
</table>




    <h2>
        <%-- <ul>
    <li><a href="<s:url action="Login_input"/>">Sign On</a></li>
    <li><a href="<s:url action="Register"/>">Register</a></li>
</ul> --%>

    </h2>
</body>
</html>
