<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/flexigrid/css/flexigrid.css"  
            type="text/css"></link>  
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.2.min.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath()%>/flexigrid/js/flexigrid.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电工程管理系统-查询结果</title>
</head>
<body>
    <center>
        <div style="width:800px">
            <%@include file="page_title.jsp" %>
            <h2>Example 1</h2>
    <table class="flexme1" align="left">
        <thead align="left">
            <tr>
                <th width="100">Col 1</th>
                <th width="100">Col 2</th>
                <th width="100">Col 3 is a long header name</th>
                <th width="300">Col 4</th>
            </tr>
        </thead>
        <tbody align="left">
            <tr>
                <td>This is data 1 with overflowing content</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
            <tr>
                <td>This is data 1</td>
                <td>This is data 2</td>
                <td>This is data 3</td>
                <td>This is data 4</td>
            </tr>
        </tbody>
    </table>
        </div>
    </center>
<script type="text/javascript">
        $('.flexme1').flexigrid();
</script>
</body>
</html>