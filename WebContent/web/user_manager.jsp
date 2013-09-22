<%@page import="database.DBHelper"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.User" %>
<%@page import="database.DBHelper" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电工程管理系统-用户管理</title>
<script type="text/javascript">
function deluser(username){
    return confirm("是否要删除用户:"+username);
}
function resetpassword(username) {
    return confirm("是否要将用户"+ username +"的密码重置为123456");
}
</script>
<style type="text/css">
.halfContent{
width:50%;
float:left
}
</style>
</head>
<body>
<center>
<%@include file="user_group_ctrl.jsp"%>
<div style="width:800px">
<%@include file="page_title.jsp" %>
<%
ArrayList<User> allUserList = null;
allUserList = (ArrayList<User>)request.getAttribute("alluserlist");
if(allUserList == null) {
    response.sendRedirect("welcome.jsp");
    return;
}
int allUserCount = allUserList.size();
%>
<div style="margin-top:50px">
<div class="halfContent" align=left>
当前共有<%=allUserCount%>个用户帐号
</div>
<div class="halfContent" align=right>
<s:a href="add_user.jsp">添加用户帐号</s:a>
</div>
</div>
<table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#4472C4" style="border-collapse:collapse">
  <tr bgcolor="#4472C4">
    <td width="50%" align="center"><font color="#FFFFFF">用户名</font></td>
    <td width="50%" align="center"><font color="#FFFFFF">操作</font></td>
  </tr>
<s:iterator value="#request.alluserlist" status="st" id="list">
<s:if test="#st.odd == true">
<tr bgcolor="#D9E2F3">
</s:if>
<s:else>
<tr>
</s:else>
    <td width="50%" align="center"><s:property value="username"/></td>
    <td width="50%" align="center">
    <s:a action="ResetUserPassword?username=%{#list.username}" onclick="return resetpassword('%{#list.username}')">密码重置</s:a>
     <%
    if(allUserCount>1){
     %>
     <s:a action="DelUser?username=%{#list.username}" onclick="return deluser('%{#list.username}')">删除帐号</s:a>
     <%
    }
     %>
    </td>
</tr>
</s:iterator>
</table>
</div>
</center>
</body>
</html>