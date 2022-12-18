<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Form</title>
</head>
<body>
<form
        style="text-align: center"
        action="hello-servlet"
        method="GET">
    Температура: <input id="temp" type="number" name="temperature" value="temp">
    <br/><br/>
    <input type="submit" value="Отправить" />
</form>
</body>
</html>