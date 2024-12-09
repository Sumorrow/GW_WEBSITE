<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/12/5
  Time: 04:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
</head>
<body>
<h3>修改商品</h3>
<form action="/untitled1_war/updategoodsServlet" method="post">
    <input type="hidden" name="id" value="${goods.id}">
    名字<input name="name" value="${goods.name}"><br>
    价格<input name="price" value="${goods.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')"><br>
    介绍<textarea rows="5" cols="20" name="description">
    ${goods.description}
</textarea>
    <input type="submit" value="提交">
</form>
<p><a href="/untitled1_war/mall.jsp">返回</a></p>
</body>

