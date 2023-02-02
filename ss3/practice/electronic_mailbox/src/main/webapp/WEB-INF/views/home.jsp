<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Settings</title>
    <style>
        .m1 {
            width: 100px;
        }
        .m2 {
            width: 300px;
        }
    </style>
</head>
<body>
<div>
    <div style="margin-left: 38%">
        <form:form action="update" modelAttribute="settings">
            <h2>${settings.setting}</h2>

            <div style="display: flex">
                <div class="m1">${settings.language}</div>
                <div class="m2">
                    <select name="languageId">
                        <option value="1">English</option>
                        <option value="2">Tiếng Việt</option>
                        <option value="3">日本</option>
                        <option value="4">中国語</option>
                    </select>
                </div>
            </div>

            <div style="display: flex">
                <div class="m1">${settings.pageSize}</div>
                <div class="m2">
                    <form:select path="pageSize">
                        <form:options items="${pages}"></form:options>
                    </form:select>
                </div>
            </div>

            <div style="display: flex">
                <div class="m1">${settings.spamsFilter}</div>
                <div class="m2">
                    <input type="checkbox">
                </div>
            </div>

            <div style="display: flex">
                <div class="m1">${settings.signature}</div>
                <div class="m2">
                    <textarea>Thor</textarea>
                </div>
            </div>
            <div style="display: flex">
                <div class="m1"></div>
                <div class="m2">
                    <button type="submit">${settings.update}</button>
                    <button class="btn btn-primary">${settings.cancel}</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>
