<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<form method="post" action="/myhome/writeOk">
	제목 : <input type="text" id="subject" name="subject"/><br/>
	내용 : <textarea name="content" cols="50" rows="10"></textarea>
	<input type="submit" value="등록"/>
</form>
</body>
</html>