<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 1/31/2023
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <h1>CurrenCy Conversion</h1>
    <form action="/conversion" method="post">
        <input type="number" name="number" placeholder="Nhập tiền muốn đổi (USD)">
        <p>Tỷ giá: 1 USD = 23 000 VND</p>
        <p>${result}</p>
        <button>Quy đổi</button>
    </form>
</div>
</body>
</html>
