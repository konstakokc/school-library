<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <title>Loan page</title>
</head>
<body>
<h1>Add a Loan</h1>

<c:url var="addAction" value="/loan/add"/>
<c:url var="cancelAction" value="/loan/loans"/>

<form:form action="${addAction}" modelAttribute="studbookID" method="POST">
    <table>
        <tr>
            <td>
                <ul>
                    <form:select path="left" size="10">
                        <c:forEach items="${listStudents}" var="student">
                            <form:option
                                    value="${student.id}">${student.toString()}</form:option>
                        </c:forEach>
                    </form:select>
                </ul>
            </td>
            <td>
                <ul>
                    <form:select path="right" size="10">
                        <c:forEach items="${listBooks}" var="book">
                            <form:option value="${book.id}">${book.toString()}</form:option>
                        </c:forEach>
                    </form:select>
                </ul>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="<spring:message text="Add loan"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<form:form action="${cancelAction}" method="get">
    <table>
        <tr>
            <td>
                <input type="submit" value="<spring:message text="Cancel"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
