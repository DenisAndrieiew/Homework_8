<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div class="navbar">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Products
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/product/index">Show Products</a>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <a href="${pageContext.request.contextPath}/#">Add Product</a>
            </security:authorize>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Manufacturers
            <i></i>
        </button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/manufacturer/index">Show Manufacturers</a>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="${pageContext.request.contextPath}/#">Add Manufacturer</a>
                        </security:authorize>
        </div>

    </div>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <div> <a href="${pageContext.request.contextPath}/user/index">Users</a></div>
        </security:authorize>
    <div style="display: flex; justify-content: flex-end">
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</div>