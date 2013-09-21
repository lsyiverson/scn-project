<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="bean.User"%>
<div style="background-color:#F0F0F0; overflow:hidden" align="left">
<div style="width:50%; float:left">
<%User user = (User) session.getAttribute("user");%>
<%
if (user == null) {
    response.sendRedirect("welcome.jsp");
    return;
}
%>
    欢迎
    <%switch (user.getGroup()) {
    case USER:
        out.print("用户");
        break;
    case ADMIN:
        out.print("管理员");
        break;
    default:
        out.print("未知身份");
        break;
    }%> ${user.username}
    </div>
    <div style="width:50%; float:left" align=right>
    <%
    String uri = request.getServletPath();
    uri=uri.substring(uri.lastIndexOf("/")+1);
        switch(user.getGroup()) {
        case SUPERADMIN:
        case ADMIN:
            if (!uri.equals("main.jsp")) {
                %>
                <a href="main.jsp">数据查询</a>
                <%
            }
            if (!uri.equals("fileupload.jsp")) {
                %>
                <a href="fileupload.jsp">数据上传</a>
                <%
            }
            if (!uri.equals("user_manager.jsp")) {
                %>
                <a href="GetAllUsers.action">用户管理</a>
                <%
            }
        case USER:
            if (!uri.equals("account_manager.jsp")) {
                %>
                <a href="account_manager.jsp">修改密码</a>
                <%
            }
        }
    %>
    <a href="Logout">注销登录</a>
    </div>
</div>