<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>四川广电工程管理系统</title>
<link href="<s:url value="/css/examplecss"/>" rel="stylesheet"
          type="text/css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5.js"></script>
<script type="text/javascript">
function md5andsubmit() {
    var hash = hex_md5(login.username.value+login.psw.value);
    login.password.value = hash;
}

function validate() {
    if (login.username.value == "") {
        alert("用户名不能为空");
        return false;
    }
    if (login.psw.value == "") {
        alert("密码不能为空");
        return false;
    }
    login.psw.disabled = true;
}
</script>

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
            <s:form onsubmit="return validate()" action="Login" name="login">
                <s:textfield id="username" name="username" label="用户名" cssStyle="width:140px" />
                <s:password id="psw" name="psw" label="密　码" cssStyle="width:140px" />
                <s:hidden id="password" name="password" />
                <s:submit value="登陆" onclick="md5andsubmit()" />
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
