<%--
  Created by IntelliJ IDEA.
  User: wsdl
  Date: 2022/5/18
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>i am myjsp.jsp</h4>
<form method="post" action="<%=request.getContextPath()%>/exercise2">
    name<input type="text" name="name">
    class<input type="text" name="class">
    ID<input type="text" name="id">
    <input type="submit"  value="Send data to the server">
</form>
</body>
</html>
