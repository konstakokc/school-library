<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Book Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;
            overflow:hidden;word-break:normal;
            border: 1px solid #ccc;
            color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;
            overflow:hidden;word-break:normal;
            border: 1px solid #ccc;
            color:#333;background-color:#f0f0f0;}
    </style>
</head>
<body>
<h1>Add a Book</h1>

<c:url var="addAction" value="/book/add" />
<%--modelAttribute commandName--%>
<form:form action="${addAction}" modelAttribute="book">
    <table>
        <c:if test="${!empty book.name}">
            <tr>
                <td><form:label path="id"><spring:message text="ID"/></form:label></td>
                <td><form:input path="id" readonly="true"/></td>
            </tr>
        </c:if>
        <tr>
            <td><form:label path="name"><spring:message text="Name"/></form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="author"><spring:message text="Author"/></form:label></td>
            <td><form:input path="author" /></td>
        </tr>
        <tr>
            <td><form:label path="genre"><spring:message text="Genre"/></form:label></td>
            <td><form:input path="genre" /></td>
        </tr>
        <tr>
            <td><form:label path="country"><spring:message text="Country"/></form:label></td>
            <td><form:input path="country" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty book.name}">
                    <input type="submit" value="<spring:message text="Edit Book"/>" />
                </c:if>
                <c:if test="${empty book.name}">
                    <input type="submit" value="<spring:message text="Add Book"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Books List</h3>
<c:if test="${!empty listBooks}">
    <table class="tg">
        <tr>
            <th width="80">Book ID</th>
            <th width="120">Book Name</th>
            <th width="120">Book Author</th>
            <th width="100">Book Genre</th>
            <th width="100">Book Country</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.genre}</td>
                <td>${book.country}</td>
                <td><a href="<c:url value='/${book.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/book/remove/${book.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

