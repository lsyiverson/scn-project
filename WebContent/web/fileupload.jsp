<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电网络工程管理系统-上传文件</title>
<style type="text/css">
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
<h4>上传数据表格</h4>
<s:form action="fileUpload" method="post"
        enctype="multipart/form-data">
<s:file name="doc" label="Excel文件" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
<tr>
<td colspan="2">
<div align="right" style="padding-top: 20px">
<s:submit value="上传"/>
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