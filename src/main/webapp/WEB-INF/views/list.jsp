<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Objects</title>
</head>
<body>
<h2>Agents</h2>
	<c:forEach items="${agents}" var="a">
		<p>${a}</p>
	</c:forEach>
	
<h2>Trainings</h2>
	<c:forEach items="${trainings}" var="a">
		<p>${a}</p>
	</c:forEach>

<h2>Raids</h2>
	<c:forEach items="${raids}" var="a">
		<p>${a}</p>
	</c:forEach>

</body>
</html>