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
    <p>Project Management System</p><security:authorize access="hasRole('ROLE_ADMIN')">
    <p>USERS</p>
    <table border="1" cellpadding="2%" width="100%" >
        <thead>
            <tr align="center">
                <td>Email</td>
                <td/>
            </tr>
        </thead>
        <tbody align="center">
             <c:forEach var="user" items="${users}">
                 <tr>
                     <td>${user.email}</td>
                     <td border="0" cellpadding="0">
                     <p><a href="/user/update?id=${user.id}">
                            <button type = "update-button" style="background-color:#1E90FF">
                             details
                     </button></a></p>
                     <p><a href="/user/delete?id=${user.id}">
                     <button type = "delete-button" style="background-color:#DC143C">
                                                  delete
                                          </button></p>
                     </td>
                 </tr>
             </c:forEach>
        </tbody>
     </table>
    <div align="center"> <a href="/companies/new">
    </security:authorize>
    </body>
</html>

