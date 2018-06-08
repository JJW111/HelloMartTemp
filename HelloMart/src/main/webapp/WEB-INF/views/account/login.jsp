<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
파라미터의 result 값이 0 이면 Bad Credentials(아이디가 존재하지 않거나 비밀번호가 일치하지 않을 때 발생하는 예외)이 아닌 
의도치 못한 상황이므로 강제로 에러페이지 400으로 이동시킨다. 
--%>
<c:if test="${param.result == 0}">
<% response.sendRedirect("error/400"); %>
</c:if>
<%-- 
파라미터의 result 값이 0 이면 Bad Credentials(아이디가 존재하지 않거나 비밀번호가 일치하지 않을 때 발생하는 예외)이 아닌 
의도치 못한 상황이므로 강제로 에러페이지 400으로 이동시킨다. 
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<form name='f' action='loginProcess' method='POST'>
	<table>
		<tr>
			<td width='50px'>User:</td>
			<td>
				<input type='text' name='id' value='' size=29>
			</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>
				<input type='password' name='pw' size=30/>
			</td>
		</tr>
		<tr>
			<td colspan='2'>
				<input name='submit' type='submit' value='로그인'/>
			</td>
		</tr>
	</table>
</form>
<c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'] ne null}">
BEFORE SPRING_SECURITY_LAST_EXCEPTION EXISTS
</c:if>
<br/>
<c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'] eq null}">
BEFORE SPRING_SECURITY_LAST_EXCEPTION IS DELETED
</c:if>
<br/>
<c:if test="${param.fail == 'true' and param.result == 1}">
아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다. 다시 시도하여 주십시오
<c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>
</c:if>
<br/>
<c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'] ne null}">
AFTER SPRING_SECURITY_LAST_EXCEPTION EXISTS
</c:if>
<br/>
<c:if test="${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'] eq null}">
AFTER SPRING_SECURITY_LAST_EXCEPTION IS DELETED
</c:if>
</body>
</html>