<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User"%>
<div style="background-color:#F0F0F0; overflow:hidden" align="left">
<div style="width:50%; float:left">
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
    </div>
	<div style="width:50%; float:left" align=right>数据上传 用户管理 注销登陆</div>
</div>