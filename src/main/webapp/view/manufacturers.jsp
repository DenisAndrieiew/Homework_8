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
    <p>MANUFACTURERS</p>
    <table border="1" cellpadding="2%" width="100%" >
        <thead>
            <tr align="center">
                <td>Manufacturer Name</td>
                <td/>
            </tr>
        </thead>
        <tbody align="center">
             <c:forEach var="manufacturer" items="${manufacturers}">
                 <tr>
                     <td>${manufacturer.name}</td>
                     <td border="0" cellpadding="0">
                     <p><a href="/manufacturers/details?id=${manufacturer.id}">
                         <button type = "details-button" style="background-color:#080808">
                            Details
                         </button></a></p>
                     <security:authorize access="hasRole('ROLE_ADMIN')">
                     <a href="/manufacturer/update?id=${manufacturer.id}">
                            <button type = "update-button" style="background-color:#1E90FF">
                             update
                     </button></a></p>
                     <p><a href="/manufacturer/delete?id=${manufacturer.id}">
                     <button type = "delete-button" style="background-color:#DC143C">
                            Delete
                     </button></p></security:authorize>
                     </td>
                 </tr>
             </c:forEach>
        </tbody>
     </table>
    <div align="center"> <a href="/companies/new">
    </body>
</html>

