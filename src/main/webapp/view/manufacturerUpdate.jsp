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
    Manufacturer details
</h2>
<form:form name="ManufacturerForm" method="post" action="/manufacturer/update" modelAttribute="manufacturer">
    <form:input type="hidden" path="id" name="id" value='${manufacturer.id}'/>
    Name: <form:input type="text" name="name" path="name" placeholder="<c:out value='${manufacturer.name}'/>"/> <br/>
    <br/>


    <br/>
    <input type="submit" value="Save manufacturer"/>

</form:form>
<p><a href="/user/index"><button type = "back-button" style="background-color:#AAA">
                                                             Back
                                                     </button></p></body>
</html>