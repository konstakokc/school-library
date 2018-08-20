<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Loan page</title>
</head>
<body>
<h1>Add a Loan</h1>

<c:url var="addAction" value="/loan/add"/>

<form:form action="${addAction}" modelAttribute="loan">
    <table>
        <tr>
            <td>
                <ul>
                    <form:select path="student" size="10">
                        <form:options items="${listStudents}" />
                    </form:select>
                </ul>
            </td>
            <td>
                <ul>
                    <form:select path="book" size="10">
                        <form:options items="${listBooks}" />
                    </form:select>
                </ul>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
