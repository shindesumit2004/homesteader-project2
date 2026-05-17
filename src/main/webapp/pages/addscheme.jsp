<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Scheme</title>
</head>
<body>

<h2>Add Government Scheme</h2>

<form action="${pageContext.request.contextPath}/admin/savescheme"
      method="post">

    <input type="text"
           name="schemeName"
           placeholder="Scheme Name"><br><br>

    <textarea name="description"
              placeholder="Description"></textarea><br><br>

    <input type="text"
           name="benefits"
           placeholder="Benefits"><br><br>

    <input type="text"
           name="eligibility"
           placeholder="Eligibility"><br><br>

    <input type="text"
           name="department"
           placeholder="Department"><br><br>

    <select name="applicationMode">
        <option>Online</option>
        <option>Offline</option>
        <option>Both</option>
    </select><br><br>

    <input type="text"
           name="officialWebsite"
           placeholder="Official Website"><br><br>

    <textarea name="requiredDocuments"
              placeholder="Required Documents"></textarea><br><br>

    <input type="date"
           name="lastDate"><br><br>

    <input type="text"
           name="amount"
           placeholder="Amount"><br><br>

    <button type="submit">Save Scheme</button>

</form>

</body>
</html>