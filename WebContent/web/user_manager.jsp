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
allUserList = DBHelper.getInstance().getAllUSERAccounts();
int allUserCount = allUserList.size();
%>
<div style="margin-top:50px">
<div class="halfContent" align=left>
当前共有<%=allUserCount%>个用户帐号
</div>
<div class="halfContent" align=right>
<s:a action="xxx">添加用户帐号</s:a>
</div>
</div>
<table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#4472C4" style="border-collapse:collapse">
  <tr bgcolor="#4472C4">
    <td width="50%" align="center"><font color="#FFFFFF">用户名</font></td>
    <td width="50%" align="center"><font color="#FFFFFF">操作</font></td>
  </tr>
<%
for(int i=0; i<allUserList.size(); i++){
    User item = allUserList.get(i);
%>
<tr <%if (i%2 == 0) {out.print("bgcolor=\"#D9E2F3\"");}%>>
    <td width="50%" align="center"><%=item.getUsername()%></td>
    <td width="50%" align="center"><s:a>密码重置</s:a> <s:a>删除帐号</s:a></td>
</tr>
<%
}
%>
</table>
</div>
</center>
</body>
</html>