<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Product Management</title>
        <style><%@include file="/view/css/style.css"%></style>
    </head>
    <body>
    <c:import url="/view/navibar.jsp"/>
    <p>Project Management System</p>
    <p>PRODUCTS</p>
    <table border="1" cellpadding="2%" width="100%" >
        <thead>
            <tr align="center">
                <td>Product name</td>
                <td>Manufacturer</td>
                <td>Cost</td>
                <td/>
            </tr>
        </thead>
        <tbody align="center">
             <c:forEach var="product" items="${products}">
                 <tr>
                     <td>${product.name}</td>
                     <td>${product.manufacturerName}</td>
                     <td>${product.cost}</td>
                     <td border="0" cellpadding="0">
                     <p><a href="/products/update?id=${product.id}">
                            <button type = "update-button" style="background-color:#1E90FF">
                             update
                     </button></a></p>
                     <p><a href="/products/delete?id=${product.id}">
                     <button type = "delete-button" style="background-color:#DC143C">
                                                  delete
                                          </button></p>
                     </td>
                 </tr>
             </c:forEach>
        </tbody>
     </table>
    <div align="center"> <a href="/companies/new">
    </body>
</html>

