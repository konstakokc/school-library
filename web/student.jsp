<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Student Page</title>
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
<h1>
    Add a Student
</h1>

<c:url var="addAction" value="/student/add" />
<%--modelAttribute commandName--%>
<form:form action="${addAction}" modelAttribute="student">
    <table>
        <c:if test="${!empty student.firstName}">
            <tr>
                <td><form:label path="id"><spring:message text="ID"/> </form:label></td>
                <td><form:input path="id" readonly="true"/></td>
            </tr>
        </c:if>
        <tr>
            <td><form:label path="firstName"><spring:message text="First Name"/></form:label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label path="lastName"><spring:message text="Last Name"/></form:label></td>
            <td><form:input path="lastName" /></td>
        </tr>
        <%--*****************************ALL fields********************--%>
        <tr>
            <td><form:label path="group"><spring:message text="Group"/></form:label></td>
            <td><form:input path="group" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty student.firstName}">
                    <input type="submit" value="<spring:message text="Edit Student"/>" />
                </c:if>
                <c:if test="${empty student.firstName}">
                    <input type="submit" value="<spring:message text="Add Student"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Students List</h3>
<c:if test="${!empty listStudents}">
    <table class="tg">
        <tr>
            <th width="80">Student ID</th>
            <th width="120">Student First Name</th>
            <th width="120">Student Last name</th>
            <th width="100">Student Group</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listStudents}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.group}</td>
                <td><a href="<c:url value='/student/${student.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/student/remove/${student.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

