<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>四川广电工程管理系统</title>
</head>
<body>
<%User user = (User) session.getAttribute("user");%>
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
</body>
</html>