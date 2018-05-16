<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <style>
            .wrap {
                width: 50%;
            }
        </style>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="wrap"><sf:form class="formGroup" action="${pageContext.servletContext.contextPath}/" method="post"
                                   modelAttribute="url">
            <sf:input class="form-control" path="enteredUrl" placeholder="enter your url http://example.com"
                      minLength="3"/>
            <div><sf:errors path="enteredUrl"/></div>
            <input type="submit" name="" placeholder="" class="btn btn-primary">

        </sf:form></div>


        <c:forEach items="${urls}" var="url">
            <ul class="list-group wrap">
                <li class="list-group-item"><a href="${url.enteredUrl}" target="_blank">http://ec2-35-180-29-224.eu-west-3.compute.amazonaws.com:8080${pageContext.servletContext.contextPath}/${url.id}</a>
                </li>
            </ul>
        </c:forEach>

        <div>
            <a href="https://github.com/VictorKmin/TaskProject">git source </a>

        </div>

    </body>
</html>
