<%-- 
    Document   : index
    Created on : Mar 22, 2017, 9:15:11 AM
    Author     : NGUYEN
--%>

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
                <th>Description</th>
                <th>Price</th>
                <th></th>
            </tr>
            <tr>
                <td>86 (the band) - True Life Songs and Pictures</td>
                <td class="right">$14.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="8601">
                        <input type="submit" value="Add To Cart">
                    </form><!--<a href="cart?productCode=8601">Add To Cart</a>--></td>
            </tr>
            <tr>
                <td>Paddlefoot - The first CD</td>
                <td class="right">$12.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="pf01">
                        <input type="submit" value="Add To Cart">
                    </form></td>
            </tr>
            <tr>
                <td>Paddlefoot - The second CD</td>
                <td class="right">$14.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="pf02">
                        <input type="submit" value="Add To Cart">
                    </form></td>
            </tr>
            <tr>
                <td>Joe Rut - Genuine Wood Grained Finish</td>
                <td class="right">$14.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="jr01">
                        <input type="submit" value="Add To Cart">
                    </form></td>
            </tr>

        </table>
    </body>
</html>
