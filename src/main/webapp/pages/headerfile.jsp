<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Header File</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

     <!-- Favicon -->
     <link rel="shortcut icon" href="img/favicon-32x32.png" type="image/x-icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    
    <script src="https://kit.fontawesome.com/afcf20c6bc.js" crossorigin="anonymous"></script>
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid px-5 d-none d-lg-block top_bar">
        <div class="row gx-5 py-3 align-items-center">
            <div class="col-lg-3" style="color: darkslategrey;font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman',">
                <div class="d-flex align-items-center justify-content-start">
                    <i class="bi bi-phone-vibrate fs-1 text-primary me-2"></i>
                    <h2 class="mb-0">+91 904-908-909-7</h2>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="d-flex align-items-center justify-content-center">
                    <a href="/home" class="navbar-brand ms-lg-5">
                        <h1 class="m-0 display-4 text-primary"><span class="text-secondary">Homesteader</span>India</h1>
                    </a>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="d-flex align-items-center justify-content-end">
                    <a class="btn btn-primary btn-square rounded-circle me-2" href=""><i class="fab fa-twitter"></i></a>
                    <a class="btn btn-primary btn-square rounded-circle me-2" href=""><i class="fab fa-facebook-f"></i></a>
                    <a class="btn btn-primary btn-square rounded-circle me-2" href=""><i class="fab fa-linkedin-in"></i></a>
                    <a class="btn btn-primary btn-square rounded-circle" href=""><i class="fab fa-instagram"></i></a>
                </div>
            </div>
        </div>
    </div>
    <!-- Topbar End -->
    <%HttpSession s1=request.getSession(false);%>


    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-primary navbar-dark shadow-sm py-3 py-lg-0 px-3 px-lg-5">
        <a href="" class="navbar-brand d-flex d-lg-none">
            <h1 class="m-0 display-4 text-secondary"><span class="text-white">Homesteader</span>India</h1>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav mx-auto py-0">
                
     
                <form action="searchname" method="post">
                 
                 <input type="text" value="<%out.println(s1.getAttribute("email"));%>" name="email" style="display:none;">
                
               
                <button type="submit" class="custombutton" style=" margin-right: 700px; margin-top:10px; border:none;background-color:#f93; color:white; "><i class="fa-solid fa-id-card"></i>&nbsp; &nbsp;<%out.println(s1.getAttribute("name"));%></button></form>
                <a href="home" class="nav-item nav-link "><i class="fa-solid fa-house"></i>&nbsp;Home</a>
                <a href="aboutl" class="nav-item nav-link"><i class="fa-solid fa-globe"></i>&nbsp;About</a>
                <a href="service" class="nav-item nav-link"><i class="fa-solid fa-building"></i>&nbsp;Services</a>
                <a href="farmer/viewschemes" class="nav-item nav-link">
                        <i class="fa-solid fa-landmark"></i>&nbsp;Govt Schemes
                    </a>
                <a href="farmproduct" class="nav-item nav-link"><i class="fa-solid fa-cart-shopping"></i>&nbsp;Product</a>
                
                <a href="contact" class="nav-item nav-link"><i class="fa-solid fa-envelope"></i>&nbsp;Contact</a>
                <a href="logout" class="nav-item nav-link"><i class="fa-solid fa-power-off"></i>&nbsp;Logout</a>
               
               
              
                
               
            </div>
        </div>
    </nav>
    <!-- Navbar End -->
    
    <style>
    
    .custombutton
    {
      width:120px;
      height:50px;
      
      
     
    }
    
    i{
     font-size:13px;
    }
    
    </style>

<!-- ================= CHATBOT START ================= -->

<!-- CHATBOT ICON -->
<div id="chatbot-icon">
    <img src="${pageContext.request.contextPath}/images/chatbot.jpg" alt="Chatbot">
</div>

<!-- CHATBOT BOX -->
<div id="chatbot-box">

    <!-- HEADER -->
    <div id="chat-header">
        Smart Farming Assistant
        <span id="close-chat">X</span>
    </div>

    <!-- CHAT BODY -->
    <div id="chat-body"></div>

    <!-- FOOTER -->
    <div id="chat-footer">
        <input type="text" id="chat-input" placeholder="Type your message...">
        <button id="send-btn" type="button">Send</button>
    </div>

</div>

<!-- ================= CSS ================= -->

<style>

/* ICON */
#chatbot-icon{
    position: fixed;
    bottom: 20px;
    right: 20px;
    width: 60px;
    height: 60px;
    background: #111;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    z-index: 9999;
    box-shadow: 0 6px 15px rgba(0,0,0,0.5);
}

#chatbot-icon img{
    width: 32px;
    height: 32px;
}

/* CHAT WINDOW */
#chatbot-box{
    position: fixed;
    bottom: 100px;
    right: 20px;
    width: 360px;
    height: 500px;
    background: #0f0f0f;
    border-radius: 15px;
    display: none;
    flex-direction: column;
    overflow: hidden;
    z-index: 9999;
    box-shadow: 0 8px 25px rgba(0,0,0,0.6);
}

/* HEADER */
#chat-header{
    background: #111;
    color: #fff;
    padding: 12px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-weight: bold;
    border-bottom: 1px solid #222;
}

/* CLOSE BUTTON */
#close-chat{
    cursor: pointer;
    font-size: 22px;
    color: #ff4d4d;
}

/* BODY */
#chat-body{
    flex: 1;
    padding: 12px;
    overflow-y: auto;
    background: #0f0f0f;
}

/* USER MESSAGE */
.user-msg{
    background: #1f1f1f;
    color: #ffffff;
    padding: 10px 12px;
    border-radius: 10px;
    margin: 8px 0;
    margin-left: auto;
    max-width: 85%;
    white-space: pre-wrap;
}

/* BOT MESSAGE */
.bot-msg{
    background: #1a1a1a;
    color: #e6e6e6;
    padding: 10px 12px;
    border-radius: 10px;
    margin: 8px 0;
    max-width: 85%;
    white-space: pre-wrap;
    line-height: 1.5;
}

/* FOOTER */
#chat-footer{
    display: flex;
    padding: 10px;
    border-top: 1px solid #222;
    background: #111;
}

#chat-input{
    flex: 1;
    padding: 10px;
    border-radius: 8px;
    border: 1px solid #333;
    background: #1a1a1a;
    color: white;
    outline: none;
}

#send-btn{
    margin-left: 8px;
    background: #28a745;
    color: #fff;
    border: none;
    padding: 10px 14px;
    border-radius: 8px;
    cursor: pointer;
}

#send-btn:hover{
    background: #1f7a32;
}

</style>

<!-- ================= JAVASCRIPT ================= -->

<script>

const chatbotIcon = document.getElementById("chatbot-icon");
const chatbotBox = document.getElementById("chatbot-box");
const closeChat = document.getElementById("close-chat");
const chatBody = document.getElementById("chat-body");
const input = document.getElementById("chat-input");
const sendBtn = document.getElementById("send-btn");

/* OPEN CHAT */
chatbotIcon.addEventListener("click", () => {
    chatbotBox.style.display = "flex";

    if(chatBody.innerHTML.trim() === "") {
        addMessage("bot", "Hello..!\nHow can I help you with farming?");
    }
});

/* CLOSE CHAT */
closeChat.addEventListener("click", () => {
    chatbotBox.style.display = "none";
});

/* SEND */
sendBtn.addEventListener("click", sendMessage);

input.addEventListener("keypress", (e) => {
    if(e.key === "Enter") sendMessage();
});

/* ADD MESSAGE */
function addMessage(type, text){

    const div = document.createElement("div");
    div.className = type === "user" ? "user-msg" : "bot-msg";

    div.innerHTML = formatText(text);

    chatBody.appendChild(div);
    chatBody.scrollTop = chatBody.scrollHeight;
}

/* FORMAT GEMINI STYLE RESPONSE */
function formatText(text){

    return text
        .replace(/\n/g, "<br>")
        .replace(/\*\*(.*?)\*\*/g, "<b>$1</b>")
        .replace(/- /g, "• ");
}

/* SEND MESSAGE */
function sendMessage(){

    let message = input.value.trim();
    if(message === "") return;

    addMessage("user", message);
    input.value = "";

    // typing indicator
    const loading = document.createElement("div");
    loading.className = "bot-msg";
    loading.innerHTML = "Typing...";
    chatBody.appendChild(loading);
    chatBody.scrollTop = chatBody.scrollHeight;

    fetch("/chat", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ message })
    })
    .then(res => res.text())
    .then(data => {
        loading.remove();
        addMessage("bot", data);
    })
    .catch(() => {
        loading.innerHTML = "Server not responding.";
    });
}

</script>

<!-- ================= CHATBOT END ================= -->