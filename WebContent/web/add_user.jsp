<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="org.apache.poi.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电网络工程管理系统-添加用户</title>
<script type="text/javascript">
String.prototype.trim = function(){  
    // 用正则表达式将前后空格  
    // 用空字符串替代。  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
};

var username;

function createuser() {
    username = add.username.value.trim();
}

function isEmpty(str) {
    return (str == "" || str == null || str == undefined);
}

function validate() {
    if(isEmpty(username)) {
        alert("用户名不能为空");
        return false;
    }
    add.username.value = username;
}
</script>
<style type="text/css">
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
<%@include file="user_group_ctrl.jsp"%>
<center>
<div style="width:800px">
<%@include file="page_title.jsp" %>
<div class="content">
<table width="100%" height="100%">
<tr align="center">
<td align="center">
<div class="formStyle">
<%
String usergroup = request.getParameter("usergroup");
int group = 0;
if (StringUtils.isEmpty(usergroup)) {
    group = 0;
} else if(StringUtils.isNumeric(usergroup)) {
    group = Integer.parseInt(usergroup);
    if (group == 1) {
        group = user.getGroup()==UserGroup.SUPERADMIN?group:0;
    }
} else {
    group = 0;
}
request.setAttribute("group", group);
%>
<s:if test="#request.group == 0">
<h4>创建用户</h4>
</s:if>
<s:elseif test="#request.group == 1">
<h4>创建管理员</h4>
</s:elseif>
<s:form onsubmit="return validate()" action="CreateUser?" name="add">
<s:hidden id="group" name="group" value="%{#request.group}"/>
<s:textfield id="username" name="username" label="用户名" cssStyle="width:140px"/>
<tr>
<td colspan="2">
<div align="right"><font size="2px" color="#808080">初始密码为:123456</font></div>
<div align="right" style="padding-top: 20px">
<s:submit value="创建" theme="simple" onclick="createuser()"/>
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