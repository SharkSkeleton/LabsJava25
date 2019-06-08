<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Travels Manage Page</title>
    <style>
        table,th,td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<%-- Travel Add/Edit logic --%>
<c:if test="${requestScope.error ne null}">
    <strong style="color: red;"><c:out
            value="${requestScope.error}"></c:out></strong>
</c:if>
<c:if test="${requestScope.success ne null}">
    <strong style="color: green;"><c:out
            value="${requestScope.success}"></c:out></strong>
</c:if>
<c:url value="/addTravel" var="addURL"></c:url>
<c:url value="/editTravel" var="editURL"></c:url>

<%-- Edit Request --%>
<c:if test="${requestScope.travel ne null}">
    <form action='<c:out value="${editURL}"></c:out>' method="post">
        ID: <input type="text" value="${requestScope.travel.id}"
                   readonly="readonly" name="id"><br> Number: <input
            type="text" value="${requestScope.travel.number}" name="number"><br>
        Bus ID: <input type="text" value="${requestScope.travel.busId}"
                        name="busId"><br> <input type="submit"
                                                   value="Edit Travel">
    </form>
</c:if>

<%-- Add Request --%>
<c:if test="${requestScope.travel eq null}">
    <form action='<c:out value="${addURL}"></c:out>' method="post">
        Number: <input type="text" name="number"><br> Bus ID: <input
            type="text" name="busId"><br> <input type="submit"
                                                   value="Add Travel">
    </form>
</c:if>

<%-- Travels List Logic --%>
<c:if test="${not empty requestScope.travels}">
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <th>Number</th>
            <th>Bus ID</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.travels}" var="travel">
            <c:url value="/editTravel" var="editURL">
                <c:param name="id" value="${travel.id}"></c:param>
            </c:url>
            <c:url value="/deleteTravel" var="deleteURL">
                <c:param name="id" value="${travel.id}"></c:param>
            </c:url>
            <tr>
                <td><c:out value="${travel.id}"></c:out></td>
                <td><c:out value="${travel.number}"></c:out></td>
                <td><c:out value="${travel.busId}"></c:out></td>
                <td><a
                        href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
                <td><a
                        href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
