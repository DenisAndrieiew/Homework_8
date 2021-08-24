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
    User details
</h2>
<form:form name="userForm" method="post" action="/user/update" modelAttribute="user">
    <form:input type="hidden" path="id" name="id" value='${user.id}'/>
    Firstname: <form:input type="text" name="firstname" path="firstname" placeholder="<c:out value='${user.firstname}'/>"/> <br/>
    Lastname: <form:input type="text" name="lastname" path="lastname" placeholder="<c:out value='${user.lastname}'/>"/> <br/>
    Email: <form:input type="text" name="email" path="email" placeholder="<c:out value='${user.email}'/>"/> <br/>
    Role: <form:select path="role" items="${roles}" itemLabel="Role" itemValue="role">
</form:select>


    <br/>
    <input type="submit" value="Update User"/>

</form:form>
<p><a href="/user/index"><button type = "back-button" style="background-color:#AAA">
                                                             Back
                                                     </button></p></body>
</html>