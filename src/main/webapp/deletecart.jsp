<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/12/5
  Time: 04:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>删除商品</title>
</head>
<body>
<h3>删除商品</h3>
<form action="/untitled1_war/deletecartServlet" method="post">
    <input type="hidden" name="id" value="${cart.id}">
    ID<input name="name" value="${cart.goodsid}" readonly><br>
    名字<input name="name" value="${cart.goodsname}" readonly><br>
    价格<input name="price"value="${cart.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')" readonly><br>
    购买数量<input name="quantity" value="${cart.quantity}" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" readonly>
    <input type="submit" value="确认">
</form>
<p><a href="/untitled1_war/cart.jsp">返回</a> </p>
</body>
