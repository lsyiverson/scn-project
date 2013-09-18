<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电工程管理系统-帐号管理</title>
<style>
.tdLabel{text-align:right;}

.content{
height:500px;
background-image:url(<%=request.getContextPath()%>/img/account_mgr_bg.jpg);
}
.formStyle{
display:inline-block; 
      vertical-align:middle;
      padding:20px;
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
<s:form>
<s:textfield id="username" name="username" label="用户名" cssStyle="width:140px"/>
<s:password id="oldpsw" name="oldpsw" label="原来的密码" cssStyle="width:140px"/>
<s:password id="newpsw" name="newpsw" label="新的密码" cssStyle="width:140px"/>
<s:password id="confirmpsw" name="confirmpsw" label="确认密码" cssStyle="width:140px"/>
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