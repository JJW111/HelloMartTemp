<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<input type='text' name='id' value='${id}' size=30>
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
<c:if test="${param.fail == 'true'}">
	<script type="text/javascript">
		alert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}')
	</script>
</c:if>
</body>
</html>