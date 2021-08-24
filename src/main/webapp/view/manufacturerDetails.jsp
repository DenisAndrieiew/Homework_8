<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
    <style>
        <%@include file="/view/css/style.css" %>
    </style>
</head>
<body>
<c:import url="/view/navibar.jsp"/>

<h2 align="center" class="formCapture">
    Manufacturer Details
</h2>

Name: '${manufacturer.name}' <br/>
Products:
<ul type="square">
     <c:forEach var="product" items="${manufacturer.productNames}">
           <li> ${product}</li>
     </c:forEach>
</ul>

</html>