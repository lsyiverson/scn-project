<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
User useraccount = (User)session.getAttribute("user");
if (useraccount == null) {
    response.sendRedirect("welcome.jsp");
    return;
}
String password = useraccount.getPassword();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电网络工程管理系统-修改密码</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5.js"></script>
<script type="text/javascript">
String.prototype.trim= function(){  
    // 用正则表达式将前后空格  
    // 用空字符串替代。  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
};
var username;
var oldpsw;
var newpsw;
var confirmpsw;
var password;

function md5andsubmit() {
    password = "<%=password%>";
    username = change.username.value.trim();
    oldpsw = change.oldpsw.value.trim();
    newpsw = change.newpsw.value.trim();
    confirmpsw = change.confirmpsw.value.trim();
    var hash = hex_md5(username+newpsw);
    change.password.value = hash;
    
    // 提交原密码进行校验
    var old = hex_md5(username+oldpsw);
    change.oldpassword.value = old;
}

function md5oldpassword() {
    return hex_md5(username+oldpsw);
}

function isEmpty(str) {
    return (str == "" || str == null || str == undefined);
}

function validate() {
    
    if(isEmpty(oldpsw)) {
        alert("原密码不能为空");
        return false;
    }
    if(isEmpty(newpsw)) {
        alert("新密码不能为空");
        return false;
    }
    if(newpsw !== confirmpsw) {
        alert("新密码与确认密码不一致，请重新输入");
        return false;
    }
    if (md5oldpassword() !== password) {
        alert("原密码输入错误，请重新输入。忘记密码请联系管理员进行密码重置");
        return false;
    }
    change.oldpsw.disabled = true;
    change.newpsw.disabled = true;
    change.confirmpsw.disabled = true;
}
</script>
<style>
.tdLabel{
text-align:right;
}

.content{
height:500px;
background-image:url(<%=request.getContextPath()%>/img/account_mgr_bg.jpg);
}
.formStyle{
display:inline-block; 
vertical-align:middle;
padding:20px;
border:2px solid;
border-color:#33B5E5;
border-radius:10px;
-moz-border-radius:25px; /* Old Firefox */
background: #FFFFFF;
}
</style>
</head>
<body>
<center>
<div style="width:800px">
<%@include file="page_title.jsp" %>
<div class="content">
<table width="100%" height="100%">
<tr align="center">
<td align="center">
<div class="formStyle">
<s:form onsubmit="return validate()" action="ModifyPassword" name="change">
<s:textfield id="username" name="username" label="用户名" cssStyle="width:140px" readonly="true" value="%{#session.user.username}"/>
<s:password id="oldpsw" name="oldpsw" label="原密码" cssStyle="width:140px"/>
<s:password id="newpsw" name="newpsw" label="新密码" cssStyle="width:140px"/>
<s:password id="confirmpsw" name="confirmpsw" label="确认密码" cssStyle="width:140px"/>
<s:hidden id="password" name="password" />
<s:hidden id="oldpassword" name="oldpassword"/>
<tr>
<td colspan="2">
<div align="right">
<s:reset value="重置"  theme="simple"/><s:submit value="提交" theme="simple" onclick="md5andsubmit()"/>
</div>
</td>
</tr>
</s:form>
</div>
</td>
</tr>
</table>
</div>
</div>
</center>
</body>
</html>