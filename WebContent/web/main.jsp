<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电网络工程管理系统-数据查询</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
 .centerDiv { 
    display:inline-block; 
    zoom:1; 
    *display:inline;
    vertical-align:middle;
    text-align:left;
    width:auto;
}
.textContent {
    width:140px;
    height:18px;
}
.btnQuery {
    width:100%;
    padding-top:10px;
    text-align:right;
}
.btnStyle {
    font-size: medium;
    padding-top: 5px;
    padding-bottom: 5px;
    padding-left: 12px;
    padding-right: 12px;
}
</style>
</head>
<body>
<center>
<div style="width:800px">
<%@include file="page_title.jsp" %>
<div align="center"><h2>工程项目查询</h2></div>
<s:form action="QueryProject" name="query">
<table width="100%" border="1" cellpadding="2" cellspacing="0" bordercolor="#4472C4" style="border-collapse:collapse">
    <tr align="center" bgcolor="#4472C4">
        <td width="25%"><font color="#FFFFFF">项目来源</font></td>
        <td width="25%"><font color="#FFFFFF">来单时间</font></td>
        <td width="25%"><font color="#FFFFFF">来单名称</font></td>
        <td width="25%"><font color="#FFFFFF">项目编号</font></td>
    </tr>
    <tr align="center" bgcolor="#D9E2F3">
        <td>
            <div class="centerDiv">
                <s:checkboxlist name="itemsource" list="{'市场','技维','VIP','省公司派单'}" theme="custom"/>
            </div>
         </td>
         <td>
            <div class="centerDiv">
                 <s:textfield cssClass="Wdate" name="itemdate" onclick="WdatePicker()" theme="simple"/>
            </div>
         </td>
         <td>
            <div class="centerDiv">
                 <s:textfield cssClass="textContent" name="itemname" theme="simple"/>
            </div>
         </td>
         <td>
            <div class="centerDiv">
                 <s:textfield cssClass="textContent" name="pronumber" theme="simple"/>
            </div>
        </td>
    </tr>
    <tr align="center" bgcolor="#4472C4">
        <td><font color="#FFFFFF">项目名称</font></td>
        <td><font color="#FFFFFF">项目性质</font></td>
        <td><font color="#FFFFFF">项目类别</font></td>
        <td><font color="#FFFFFF">项目地址</font></td>
    </tr>
    <tr align="center" bgcolor="#D9E2F3">
        <td>
            <div class="centerDiv">
                 <s:textfield cssClass="textContent" name="proname" theme="simple"/>
            </div>
        </td>
        <td>
            <div class="centerDiv">
                <s:checkboxlist name="proproperty" list="{'新建','改造','迁改','专网'}" theme="custom"/>
            </div>
        </td>
        <td>
            <div class="centerDiv">
                <s:checkboxlist name="protype" list="{'城域网','接入','HFC','管道'}" theme="custom"/>
            </div>
        </td>
        <td>
            <div class="centerDiv">
                 <s:textfield cssClass="textContent" name="proaddress" theme="simple"/>
            </div>
        </td>
    </tr>
</table>
<div style="width:100%;text-align:left;padding-top:5px">请选择输入一个或多个项进行查询，如果全都不输入将查询所有项</div>
<div class="btnQuery"><s:submit cssClass="btnStyle" value="查询" theme="simple"/></div>
</s:form>
</div>
</center>
</body>
</html>