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
    <thead>
        <tr align="center" bgcolor="#4472C4">
            <th width="25%"><font color="#FFFFFF">项目来源</font></th>
            <th width="25%"><font color="#FFFFFF">来单时间</font></th>
            <th width="25%"><font color="#FFFFFF">来单名称</font></th>
            <th width="25%"><font color="#FFFFFF">项目编号</font></th>
        </tr>
    </thead>
    <tbody>
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
    </tbody>
    <thead>
        <tr align="center" bgcolor="#4472C4">
            <th><font color="#FFFFFF">项目名称</font></th>
            <th><font color="#FFFFFF">项目性质</font></th>
            <th><font color="#FFFFFF">项目类别</font></th>
            <th><font color="#FFFFFF">项目地址</font></th>
        </tr>
    </thead>
    <tbody>
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
    </tbody>
<%
ArrayList<String> permissionlist = user.getPermission();
request.setAttribute("permissionlist", permissionlist);
%>
    <s:if test="#request.permissionlist.size != 1" >
    <thead>
        <tr align="center" bgcolor="#4472C4">
            <th colspan="4"><font color="#FFFFFF">查询区域</font></th>
        </tr>
    </thead>
    <tbody>
        <tr align="center" bgcolor="#D9E2F3">
            <td colspan="4">
                <div><br/></div>
                <s:checkboxlist name="area" list="#request.permissionlist" theme="simple" />
                <div><br/></div>
            </td>
        </tr>
    </tbody>
    </s:if>
    <s:else>
    <s:hidden name="area" value="%{#request.permissionlist[0]}" />
    </s:else>
</table>
<div style="width:100%;text-align:left;padding-top:5px">请选择输入一个或多个项进行查询，如果全都不输入将查询所有项</div>
<div class="btnQuery"><s:submit cssClass="btnStyle" value="查询" theme="simple"/></div>
</s:form>
</div>
</center>
</body>
</html>