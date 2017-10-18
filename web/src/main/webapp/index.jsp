<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Hrodno-Airport</title>
</head>
<body>
    <c:url value="index" var="somevar"/>
    <form method="post">
        CityFrom<input type="text" name="from">
        CityTo<input type="text" name="to">
        <input type="submit" value="send">
    </form>
</body>
</html>
