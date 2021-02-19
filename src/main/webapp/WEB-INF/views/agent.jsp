<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Agent Report</title>
</head>
<body>
<h1>Agent Report for ${agent}</h1>
<h2>Trainings</h2>
	<c:forEach items="${trainings}" var="training">
		<p>${training}</p>
	</c:forEach>

<h2>Raids</h2>
	<c:forEach items="${raids}" var="raid">
		<p>${raid}</p>
	</c:forEach>

</body>
</html>