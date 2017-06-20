<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>User page</title>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans:600'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/userPage.css">
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
    <div class="user_info">

        <div class="user_data">Name: ${sessionScope.loginedUser.getName()}</div>
        <div class="user_data">Surname: ${sessionScope.loginedUser.getSurname()}</div>
        <div class="user_data">Phone number: ${sessionScope.loginedUser.getPhoneNumber()}</div>
    </div>
    <div class="table_withReminders">
        <table class="table">
            <c:forEach var="reminder" items="${ListOfReminders}">

                <tr>
                    <td class="remindDesc">${reminder.getText()}</td>
                    <td class="remindCheck">${reminder.getStatus()}</td>

                    <td class="remindCheck"><c:import url="/updateReminder?id=${reminder.getReminderId()}"/>Update</td>

                    <td class="remindCheck"><a href="/deleteReminder?id=${reminder.getReminderId()}">Delete</a></td>

                </tr>
            </c:forEach>
        </table>
        <div class="container">
            <form action="/addReminder" method="POST">
                <div class="form-group">
                    <label for="reminder">New reminder</label>
                    <input name="text" type="text" class="form-control" id="reminder" placeholder="reminder">
                </div>
                <button type="submit" class="btn btn-default">Ad new reminder</button>
            </form>
        </div>


    </div>
</div>
</body>
</html>
