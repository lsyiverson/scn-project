<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电网络工程管理系统-上传文件</title>
<script type="text/javascript">
var districts;
var fileupload;
var filename;

function getdataarea() {
    districts = document.getElementsByName('area');
    fileupload = document.getElementById('doc');
    filename = fileupload.value;
}

function isEmpty(str) {
    return (str == "" || str == null || str == undefined);
}

function isChecked(list) {
    var length = list.length;
    for(var i = 0 ;i<length;i++){
        if(list[i].checked == true){
            return true;
        }  
    }  
    return false;
}

function validate() {
    if(isEmpty(filename)) {
        alert("请选择要上传的数据表格");
        return false;
    }
    if(districts.length > 1) {
        if(!isChecked(districts)) {
            alert("必须选择上传数据所属区域");
            return false;
        }
    }
}
</script>
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
        <tr>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>
        </tr>
        <tr align="center">
            <td>
            </td>
            <td align="center">
                <s:form onsubmit="return validate()" action="fileUpload" method="post" enctype="multipart/form-data">
                    <table class="formStyle">
                    <tr>
                    <td colspan="2">
                    <h4>上传数据表格</h4>
                    </td>
                    </tr>
                    <tr>
                    <!-- <s:hidden id="group" name="group" value="%{#request.group}"/> -->
                    <s:file id="doc" name="doc" label="Excel文件" accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
                    </tr>
<%
ArrayList<String> permissionlist = user.getPermission();
request.setAttribute("permissionlist", permissionlist);
%>
                    <s:if test="#request.permissionlist.size != 1" >
                        <tr>
                            <s:radio id="area" label="数据区域" name="area" list="#request.permissionlist" />
                        </tr>
                    </s:if>
                    <s:else>
                        <s:hidden name="area" value="%{#request.permissionlist[0]}" />
                    </s:else>
                    <tr>
                    <td colspan="2">
                    <div align="right" style="padding-top: 20px">
                    <s:submit value="上传" onclick="getdataarea()"/>
                    </div>
                    </td>
                    </tr>
                    </table>
                </s:form>
            </td>
            <td>
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
            </td>
            <td>
            </td>
        </tr>
</table>
</div>
</div>
</center>
</body>
</html>