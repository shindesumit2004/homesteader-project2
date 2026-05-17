<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Schemes</title>
</head>
<body>

<h2>Government Schemes</h2>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Benefits</th>
    <th>Eligibility</th>
    <th>Department</th>
    <th>Mode</th>
    <th>Website</th>
    <th>Documents</th>
    <th>Last Date</th>
    <th>Amount</th>
</tr>

<c:forEach items="${schemes}" var="s">

<tr>
    <td>${s.id}</td>
    <td>${s.schemeName}</td>
    <td>${s.description}</td>
    <td>${s.benefits}</td>
    <td>${s.eligibility}</td>
    <td>${s.department}</td>
    <td>${s.applicationMode}</td>
    <td>${s.officialWebsite}</td>
    <td>${s.requiredDocuments}</td>
    <td>${s.lastDate}</td>
    <td>${s.amount}</td>
</tr>

</c:forEach>

</table>

</body>
</html>