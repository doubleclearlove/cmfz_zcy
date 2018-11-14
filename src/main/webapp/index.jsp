<%@page pageEncoding="utf-8" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<c:forEach items="${requestScope.admins}" var="admin">
    名字：${admin.name}<br/>
    密码：${admin.password}<br/>
</c:forEach>
</body>
</html>
