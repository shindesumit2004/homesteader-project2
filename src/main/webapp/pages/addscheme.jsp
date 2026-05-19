<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Add Government Scheme</title>

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>

<style>

body{
	margin:0;
	padding:0;
	font-family:Arial,sans-serif;
	background:linear-gradient(135deg,#74ebd5,#ACB6E5);
	min-height:100vh;
}

.main-container{
	padding:40px;
}

.scheme-card{

	background:#fff;
	max-width:900px;
	margin:auto;
	padding:40px;
	border-radius:20px;
	box-shadow:0 10px 30px rgba(0,0,0,0.2);

	animation:fadeIn 0.8s ease;
}

@keyframes fadeIn{

	from{
		opacity:0;
		transform:translateY(20px);
	}

	to{
		opacity:1;
		transform:translateY(0);
	}
}

.page-title{

	text-align:center;
	font-weight:bold;
	color:#2c3e50;
	margin-bottom:30px;
}

.form-group label{

	font-weight:600;
	color:#34495e;
}

.form-control{

	border-radius:10px;
	height:45px;
	border:1px solid #dcdde1;
	transition:0.3s;
}

textarea.form-control{

	height:100px;
}

.form-control:focus{

	border-color:#00b894;
	box-shadow:0 0 8px rgba(0,184,148,0.4);
}

.btn-custom{

	background:linear-gradient(to right,#00b894,#00cec9);
	color:white;
	font-size:18px;
	font-weight:bold;
	border:none;
	padding:12px;
	border-radius:10px;
	width:100%;
	transition:0.3s;
}

.btn-custom:hover{

	transform:scale(1.02);
	background:linear-gradient(to right,#00cec9,#00b894);
}

.icon-title{

	color:#00b894;
	margin-right:10px;
}

.upload-box{

	border:2px dashed #00b894;
	padding:15px;
	border-radius:10px;
	background:#f8f9fa;
}

</style>

</head>

<body>

<div class="main-container">

<div class="scheme-card">

<h2 class="page-title">

<i class="fa-solid fa-landmark icon-title"></i>

Add Government Scheme

</h2>

<form action="/admin/savescheme"
method="post"
enctype="multipart/form-data">

<div class="row">

<div class="col-md-6">

<div class="form-group">

<label>Scheme Name</label>

<input type="text"
name="schemeName"
class="form-control"
placeholder="Enter scheme name"
required>

</div>

</div>

<div class="col-md-6">

<div class="form-group">

<label>Scheme Type</label>

<input type="text"
name="schemeType"
class="form-control"
placeholder="Enter scheme type">

</div>

</div>

</div>

<div class="form-group">

<label>Department Name</label>

<input type="text"
name="departmentName"
class="form-control"
placeholder="Enter department name">

</div>

<div class="form-group">

<label>Description</label>

<textarea name="description"
class="form-control"
placeholder="Enter scheme description"></textarea>

</div>

<div class="row">

<div class="col-md-6">

<div class="form-group">

<label>Eligibility</label>

<input type="text"
name="eligibility"
class="form-control"
placeholder="Eligibility criteria">

</div>

</div>

<div class="col-md-6">

<div class="form-group">

<label>Benefits</label>

<input type="text"
name="benefits"
class="form-control"
placeholder="Enter benefits">

</div>

</div>

</div>

<div class="form-group">

<label>Required Documents</label>

<textarea name="requiredDocuments"
class="form-control"
placeholder="Required documents"></textarea>

</div>

<div class="form-group">

<label>Application Process</label>

<textarea name="applicationProcess"
class="form-control"
placeholder="Application process"></textarea>

</div>

<div class="row">

<div class="col-md-6">

<div class="form-group">

<label>Subsidy Amount</label>

<input type="text"
name="subsidyAmount"
class="form-control"
placeholder="Enter subsidy amount">

</div>

</div>

<div class="col-md-6">

<div class="form-group">

<label>State Name</label>

<input type="text"
name="stateName"
class="form-control"
placeholder="Enter state name">

</div>

</div>

</div>

<div class="row">

<div class="col-md-6">

<div class="form-group">

<label>Official Website</label>

<input type="text"
name="officialWebsite"
class="form-control"
placeholder="Official website">

</div>

</div>

<div class="col-md-6">

<div class="form-group">

<label>Contact Number</label>

<input type="text"
name="contactNumber"
class="form-control"
placeholder="Contact number">

</div>

</div>

</div>

<div class="row">

<div class="col-md-6">

<div class="form-group">

<label>Last Date</label>

<input type="date"
name="lastDate"
class="form-control">

</div>

</div>

<div class="col-md-6">

<div class="form-group">

<label>Status</label>

<select name="status"
class="form-control">

<option value="Active">
Active
</option>

<option value="Closed">
Closed
</option>

</select>

</div>

</div>

</div>

<div class="form-group">

<label>Upload Image</label>

<div class="upload-box">

<input type="file"
name="file"
class="form-control">

</div>

</div>

<button type="submit"
class="btn btn-custom">

<i class="fa-solid fa-plus"></i>

Add Scheme

</button>

</form>

</div>

</div>

</body>

</html>