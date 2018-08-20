<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Loans</title>
</head>
<body>
<h1>List of Loans</h1>

<c:if test="${!empty listLoans}">
    <table class="tg">
        <tr>
            <th width="120">Loan ID</th>
            <th width="120">Student First Name</th>
            <th width="120">Student Last Name</th>
            <th width="120">Book Name</th>
            <th width="100">Start date</th>
            <th width="100">Active</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listLoans}" var="loan">
            <tr>
                <td>${loan.loanID}</td>
                <td>${loan.student.firstName}</td>
                <td>${loan.student.lastName}</td>
                <td>${loan.book.name}</td>
                <td>${loan.startDate}</td>
                <td>${loan.active}</td>
                <td><a href="<c:url value='/book/return/${loan.loanID}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
