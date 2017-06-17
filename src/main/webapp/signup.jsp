<%--
  Created by IntelliJ IDEA.
  User: jarki
  Date: 6/17/2017
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>SignUp</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/bootstrap.min.css" />"/>
    <link type="text/css" rel="stylesheet" href="<c:url value="css/login.css" />"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="/signup" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Registration</label>
                    <div class="col-sm-10">
                        <p class="form-control-static"><span class="label label-warning">${message}</span></p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="nameSignUp">Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="name" class="form-control" placeholder="Name" id="nameSignUp">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="ageSingUp">Age</label>
                    <div class="col-sm-10">
                        <input type="number" name="age" min="12" max="85" class="form-control" placeholder="Age"
                               id="ageSingUp">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="addressSingUp">Address</label>
                    <div class="col-sm-10">
                        <input type="text" name="address" class="form-control" placeholder="Address" id="addressSingUp">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="loginSignUp">Login</label>
                    <div class="col-sm-10">
                        <input type="text" name="login" class="form-control" placeholder="Login" id="loginSignUp">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="passwordSignUp">Password</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" placeholder="Password"
                               id="passwordSignUp">
                    </div>
                </div>
                <div class="col-sm-10 col-sm-offset-2">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>

            </form>

        </div>
    </div>
</div>


</body>
</html>
