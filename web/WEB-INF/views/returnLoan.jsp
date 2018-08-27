<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Return Loan</title>
</head>
<body>
<h1>Return a Loan</h1>
<c:url var="returnAction" value="/loan/return/${loan.loanID}"/>
<c:url var="cancelAction" value="/loan/loans"/>
<form:form action="${returnAction}" modelAttribute="loan">

<table class="tg">
    <tr>
        <th width="120">Loan ID</th>
        <th width="120">Student First Name</th>
        <th width="120">Student Last Name</th>
        <th width="120">Book Name</th>
        <th width="100">Start date</th>
        <th width="100">Active</th>
    </tr>
    <tr>
        <td>${loan.loanID}</td>
        <td>${loan.student.firstName}</td>
        <td>${loan.student.lastName}</td>
        <td>${loan.book.name}</td>
        <td>${loan.startDate}</td>
        <td>${loan.active}</td>
    </tr>
    <tr>
        <td>
            The debt for this loan is ${debt}.
            Debt paid and book returned?
        </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="<spring:message text="Return loan"/>"/>
        </td>
    </tr>
</table>
</form:form>
<form:form action = "${cancelAction}" method="get">
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
