<%--
  Created by IntelliJ IDEA.
  User: Tomasz
  Date: 13.04.2016
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    Hello World
    <h1>
        ${Stock.stockId}
        ${Stock.stockCode}
        ${Stock.stockDetail.listedDate}
        ${Stock.stockDetail.compDesc}
    </h1>
</body>
</html>
