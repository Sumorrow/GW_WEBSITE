<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/12/5
  Time: 04:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购买记录</title>
</head>
<body>
<table>
    <p>back to <a href="/untitled1_war/mall.jsp">mall</a> now!</p>
    <h1>购买记录</h1>

</table>

<table border="1" cellspacing="0" width="800">
    <tr>
        <th>购物车ID</th>
        <th>商品ID</th>
        <th>商品名字</th>
        <th>用户ID</th>
        <th>价格</th>
        <th>数量</th>
        <th>购买时间</th>
    </tr>
    <c:forEach items="${carthistory}" var="cart">
        <tr>
            <td>${cart.id}</td>
            <td>${cart.goodsid}</td>
            <td>${cart.goodsname}</td>
            <td>${cart.usersid}</td>
            <td>${cart.price}</td>
            <td>${cart.quantity}</td>
            <td>${cart.updated_at}</td>


        </tr>
    </c:forEach>
</table>


</body>
</html>
