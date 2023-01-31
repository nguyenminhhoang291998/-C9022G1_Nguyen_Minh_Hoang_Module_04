<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/31/2023
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
  <h1>Simple Dictionary</h1>
  <form action="/translation" method="post">
    <input style="width: 200px" type="text" name="data" placeholder="Nhập từ tiếng Anh muốn dịch.">
    <p>${result}</p>
    <button type="submit">Dịch</button>
  </form>
</div>
</body>
</html>
