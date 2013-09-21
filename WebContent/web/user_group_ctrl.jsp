<%@page import="bean.User.UserGroup"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="bean.User"%>
<%
User login_user = (User)session.getAttribute("user");
if(login_user == null || login_user.getGroup() == UserGroup.USER) {
    response.sendRedirect("main.jsp");
    return;
}
%>