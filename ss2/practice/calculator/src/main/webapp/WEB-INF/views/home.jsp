<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/1/2023
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: center">
    <form id="calculator" action="calculator">
        <h2>Calculator</h2>
        <div>
            <input type="number" name="value1">
            <input type="number" name="value2">
        </div>
        <div>
            <button name="calculation" value="Addition" type="submit">Addition(+)</button>
            <button name="calculation" value="Subtraction" type="submit">Subtraction(-)</button>
            <button name="calculation" value="Multiplication" type="submit">Multiplication(X)</button>
            <button name="calculation" value="Division" type="submit">Division(/)</button>
        </div>
        <p>${result}</p>
    </form>
</div>
</body>
</html>
