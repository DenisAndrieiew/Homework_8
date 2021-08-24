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
    Product Details
</h2>
<form:form name="ProductForm" method="post" action="/product/save" modelAttribute="product">
    <form:input type="hidden" path="id" name="id" value='${product.id}'/>
    Name: <form:input type="text" name="name" path="name" /> <br/>
    Manufacturer:<form:select path="manufacturerName" items="${manufacturers}" itemLabel="name" itemValue="name"/>
    Cost: <form:input type="number" name="cost" path="cost" /> <br/>
    <br/>
    <input type="submit" value="Save product"/>

</form:form>
<p><a href="/user/index"><button type = "back-button" style="background-color:#AAA">
                                                             Back
                                                     </button></p></body>
</html>