<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h1>c:set</h1>

<c:set var="p1" scope="session" value="${param.value1}"/>
<c:out value="${p1}"/>
<c:set var="p2" scope="session" value="${param.value2}"/>
<c:out value="${p2}"/>
<c:set var="p3" scope="session" value="${param.value3}"/>
<c:out value="${p3}"/>


<h1>c:choose</h1>

<c:set var="age" value="${param.age}"/>
<c:out value="${age}"/>
<br/>
<c:choose>
    <c:when test="${age gt 18}">
        старше 18
    </c:when>
    <c:otherwise>
        не старше 18
    </c:otherwise>
</c:choose>


<h1>c:sql</h1>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/history"
                   user="root" password="root"/>
<sql:query dataSource="${snapshot}" var="result">
    SELECT * from developments;
</sql:query>

<table border="1" width="100%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Year</th>
        <th>Country</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.iddevelopments}"/></td>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.year}"/></td>
            <td><c:out value="${row.country}"/></td>
        </tr>
    </c:forEach>
</table>


<h1>c:function</h1>

<c:set var="string" value="${param.string}"/>
<c:out value="string: ${string}"/>

<c:set var="after" value="${fn:substringAfter(string, param.substring)}"/>
<p>substringAfter '${param.substring}' : ${after}</p>

<c:out value="containsIgnoreCase: ${string} ="/>
<c:if test="${fn:containsIgnoreCase(string, fn:toUpperCase(string))}">
    ${fn:toUpperCase(string)}
</c:if>

</body>
</html>