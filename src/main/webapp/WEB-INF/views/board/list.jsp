<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
<h1>게시판 목록</h1>
<a href="/myhome/write">글쓰기</a>
<ul>
	<c:forEach var="boardVO" items="${list}">
	<li>
		${boardVO.no },
		<a href="/myhome/view?no=${boardVO.no}">${boardVO.subject}</a>,
		${boardVO.userid},
		${boardVO.hit},
		${boardVO.writedate}
	</li>
	</c:forEach>
</ul>
</body>
</html>