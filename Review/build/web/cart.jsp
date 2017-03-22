<%-- 
    Document   : welcome
    Created on : Mar 22, 2017, 9:21:49 AM
    Author     : NGUYEN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Total</th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${cart.items}">
            <tr>
                <th><form action="" method="post">
                     <input type="hidden" name="productCode" value="${item.product.code}">
                    <input type="number" name="quantity" min="1" value="${item.quantity}">    
                    <input type="submit" value="Update"></form></th>
                
                <th>${item.product.description}</th>
                <th>${item.product.productCurrencyFormat}</th>
                <th>${item.totalCurrencyFormat}</th>
                <th>
                     
                    <form action="" method="post">
                    <input type="hidden" name="productCode" value="${item.product.code}">
                    <input type="hidden" name="quantity" value="0">
                    <input type="submit" value="Remove">
                    </form></th>
            </tr>
            </c:forEach>
        </table>
        <form action="" method="post"><input type="hidden" name="action" value="shop">
            <input type="submit" value="Continue shopping"></form>
        <form action="" method="post"><input type="hidden" name="action" value="checkout">
            <input type="submit" value="Check out"></form>
    </body>
</html>
