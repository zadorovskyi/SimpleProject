<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/animecss.css">

</head>
<body>
<div class="button1">
    <a href>
        <div class="round1"><span><img src="images/reminder2.png" height="150"></span></div>
    </a>
    <div class="round2"></div>
    <div class="block1 block"></div>
    <div class="block2 block"></div>
    <div class="block3 block"></div>
    <div class="block4 block"></div>
</div>

<div class="login-wrap">
    <div class="login-html">
	<input id="tab-2" type="radio" name="tab" class="sign-up" checked><label for="tab-2" class="tab">Sign Up</label>
      
        
        <div class="login-form">
            <div class="sign-up-htm">
                <form action="/registration" method="post">
                    <div class="group">
                        <label  class="label">Username</label>
                        <input name="name" id="user" type="text" class="input">
                    </div>
                    <div class="group">
                        <label class="label">Surname</label>
                        <input name="surname" type="text" id="surname" class="input" type="input">
                    </div>
                    <div class="group">
                        <label class="label">Login</label>
                        <input name="login" type="text" class="input" type="input">
                    </div>
                    <div class="group">
                        <label class="label">Password</label>
                        <input name="password" class="input" type="password">
                    </div>
                    <div class="group">
                        <label class="label">Repeat Password</label>
                        <input name="reppassword" class="input" type="password">
                    </div>
                    <div class="group">
                        <label class="label">Phone number</label>
                        <input name="phoneNumber" id="phoneNumber" type="text" class="input">
                    </div>
						<div class= "message">${message}</div>
                    <div class="group">
                        <input type="submit" class="button" value="Sign Up"></div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>


</body>
</html>







