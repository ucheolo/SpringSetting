<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/upload.jsp</title>
</head>
<body>
	<div class="container">
		<p>
			업로드된 파일명:<strong>${fileName }</strong>
			<br>
			업로드된 파일크기<strong>${fileSize }</strong>
		</p>
	</div>
</body>
</html>