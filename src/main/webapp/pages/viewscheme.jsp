<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Government Schemes</title>

<link rel="stylesheet"
href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<style>

/* ===== Page Background ===== */

body{
    background: linear-gradient(135deg,#f0fff4,#e0f2fe);
    font-family: Arial, sans-serif;
}

/* ===== Title ===== */

.page-title{
    text-align:center;
    font-size:40px;
    font-weight:bold;
    color:#166534;
    margin-bottom:30px;
    position:relative;
}

.page-title::after{
    content:"";
    width:100px;
    height:4px;
    background:#22c55e;
    display:block;
    margin:12px auto;
    border-radius:10px;
}

/* ===== Filter ===== */

.filter-box{
    margin-bottom:40px;
}

#stateFilter{
    height:50px;
    border-radius:12px;
    border:2px solid #22c55e;
    font-size:16px;
    font-weight:600;
    color:#166534;
}

/* ===== Card ===== */

.scheme-card{
    border:none;
    border-radius:20px;
    overflow:hidden;
    box-shadow:0 6px 18px rgba(0,0,0,0.12);
    transition:0.4s;
    background:#ffffff;
    margin-bottom:30px;
}

.scheme-card:hover{
    transform:translateY(-10px);
    box-shadow:0 12px 25px rgba(34,197,94,0.30);
}

/* ===== Image ===== */

.scheme-card img{
    width:100%;
    height:230px;
    object-fit:contain;
    background:linear-gradient(135deg,#dcfce7,#ecfeff);
    padding:20px;
}

/* ===== Card Body ===== */

.card-body{
    padding:25px;
}

/* ===== Scheme Name ===== */

.scheme-name{
    color:#14532d;
    font-size:26px;
    font-weight:bold;
    margin-bottom:18px;
}

/* ===== Text ===== */

.card-body p{
    font-size:15px;
    color:#374151;
    line-height:1.7;
    margin-bottom:10px;
}

.card-body b{
    color:#111827;
}

/* ===== Website Button ===== */

.website-btn{
    display:inline-block;
    padding:10px 18px;
    background:linear-gradient(135deg,#16a34a,#22c55e);
    color:white !important;
    text-decoration:none;
    border-radius:10px;
    font-weight:600;
    transition:0.3s;
}

.website-btn:hover{
    text-decoration:none;
    transform:scale(1.05);
    background:linear-gradient(135deg,#15803d,#16a34a);
}

/* ===== Status Badge ===== */

.status-badge{
    background:#dcfce7;
    color:#166534;
    padding:6px 14px;
    border-radius:20px;
    font-weight:bold;
    display:inline-block;
}

/* ===== Responsive ===== */

@media(max-width:768px){

    .page-title{
        font-size:30px;
    }

    .scheme-name{
        font-size:22px;
    }

}

</style>

</head>

<body>

<div class="container mt-5 mb-5">

<h1 class="page-title">
Government Schemes
</h1>

<!-- ===== State Filter ===== -->

<div class="row justify-content-center filter-box">

    <div class="col-md-4">

        <select id="stateFilter"
                class="form-control">

            <option value="all">
                All States
            </option>

            <option value="Andhra Pradesh">Andhra Pradesh</option>
            <option value="Arunachal Pradesh">Arunachal Pradesh</option>
            <option value="Assam">Assam</option>
            <option value="Bihar">Bihar</option>
            <option value="Chhattisgarh">Chhattisgarh</option>
            <option value="Goa">Goa</option>
            <option value="Gujarat">Gujarat</option>
            <option value="Haryana">Haryana</option>
            <option value="Himachal Pradesh">Himachal Pradesh</option>
            <option value="Jharkhand">Jharkhand</option>
            <option value="Karnataka">Karnataka</option>
            <option value="Kerala">Kerala</option>
            <option value="Madhya Pradesh">Madhya Pradesh</option>
            <option value="Maharashtra">Maharashtra</option>
            <option value="Manipur">Manipur</option>
            <option value="Meghalaya">Meghalaya</option>
            <option value="Mizoram">Mizoram</option>
            <option value="Nagaland">Nagaland</option>
            <option value="Odisha">Odisha</option>
            <option value="Punjab">Punjab</option>
            <option value="Rajasthan">Rajasthan</option>
            <option value="Sikkim">Sikkim</option>
            <option value="Tamil Nadu">Tamil Nadu</option>
            <option value="Telangana">Telangana</option>
            <option value="Tripura">Tripura</option>
            <option value="Uttar Pradesh">Uttar Pradesh</option>
            <option value="Uttarakhand">Uttarakhand</option>
            <option value="West Bengal">West Bengal</option>

        </select>

    </div>

</div>

<!-- ===== Scheme Cards ===== -->

<div class="row">

<c:forEach items="${list}"
var="s">

<div class="col-lg-4 col-md-6 scheme-item"
     data-state="${s.stateName}">

<div class="card scheme-card">

<img class="card-img-top"
src="/scheme/${s.image}">

<div class="card-body">

<h3 class="scheme-name">
${s.schemeName}
</h3>

<p>
<b>Type:</b>
${s.schemeType}
</p>

<p>
<b>Department:</b>
${s.departmentName}
</p>

<p>
<b>Description:</b>
${s.description}
</p>

<p>
<b>Eligibility:</b>
${s.eligibility}
</p>

<p>
<b>Documents:</b>
${s.requiredDocuments}
</p>

<p>
<b>Application:</b>
${s.applicationProcess}
</p>

<p>
<b>Benefits:</b>
${s.benefits}
</p>

<p>
<b>Subsidy:</b>
${s.subsidyAmount}
</p>

<p>
<b>State:</b>
${s.stateName}
</p>

<p>
<b>Contact:</b>
${s.contactNumber}
</p>

<p>
<b>Last Date:</b>
${s.lastDate}
</p>

<p>
<b>Status:</b>

<span class="status-badge">
${s.status}
</span>

</p>

<a href="${s.officialWebsite}"
target="_blank"
class="website-btn">

Visit Website

</a>

</div>

</div>

</div>

</c:forEach>

</div>

</div>

<!-- ===== Filter Script ===== -->

<script>

document.getElementById("stateFilter")
.addEventListener("change", function () {

    let selectedState = this.value.toLowerCase();

    let schemes = document.querySelectorAll(".scheme-item");

    schemes.forEach(function(card){

        let state = card.getAttribute("data-state")
                        .toLowerCase();

        if(selectedState === "all" || state === selectedState){

            card.style.display = "block";

        }
        else{

            card.style.display = "none";

        }

    });

});

</script>

</body>
</html>