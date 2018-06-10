<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 다음 api js 파일 추가 -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/daum_postcode_v4.js"></script>
<!-- 다음 api js 파일 추가 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form:form action="join" method="post" modelAttribute="account">
	<ul>
		<li><form:label path="id">아이디</form:label>
			<form:input path="id" size="32" maxlength="32" /></li>
		<li><form:label path="password">비밀번호</form:label>
			<form:password path="password" size="32" maxlength="20" /></li>
		<li><label for="re_password">비밀번호 확인</label>
			<input id="re_password" size="32" maxlength="20" /></li>
		<li><form:label path="name">이름</form:label>
			<form:input path="name" size="32" maxlength="20" /></li>
		<li><form:label path="email">이메일</form:label>
			<form:input path="email" size="100" maxlength="100"/></li>
		<li>
			<div><form:input path="postCode" id="sample4_postcode" placeholder="우편번호" readonly="readonly"/>
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"></div>
			<div><form:input path="roadAddress" id="sample4_roadAddress" placeholder="도로명주소" readonly="readonly"/>
			<form:input path="detailAddress" placeholder="상세주소" /></div>
			<span id="guide" style="color:#999"></span>
		</li>
		<li>
			<select name="birthYear" style="width: 60px; height: 40px;">
				<option value="">생년</option>
				<option value=2001>2001</option>
				<option value=2000>2000</option>
				<option value=1999>1999</option>
				<option value=1998>1998</option>
				<option value=1997>1997</option>
				<option value=1996>1996</option>
				<option value=1995>1995</option>
				<option value=1994>1994</option>
				<option value=1993>1993</option>
				<option value=1992>1992</option>
				<option value=1991>1991</option>
				<option value=1990 selected>1990</option>
				<option value=1989>1989</option>
				<option value=1988>1988</option>
				<option value=1987>1987</option>
				<option value=1986>1986</option>
				<option value=1985>1985</option>
				<option value=1984>1984</option>
				<option value=1983>1983</option>
				<option value=1982>1982</option>
				<option value=1981>1981</option>
				<option value=1980>1980</option>
			</select>
			
			<select name="birthMonth" style="width: 60px; height: 40px;">
				<option value="">월</option>
				<option value="01">1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
		
			<select name="birthDay" style="width: 60px; height: 40px;">
				<option value="">일</option>
				<option value="01">1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select>
		</li>
		<li><form:label path="gender">성별</form:label>
			<form:radiobutton path="gender" value="F" label="남"/>
			<form:radiobutton path="gender" value="M" label="여" checked="checked"/>
		</li>
		<li><form:label path="phone">연락처</form:label> 
			<form:input path="phone" size="32" maxlength="20"/></li>
	</ul>
	<input type="submit" value="가입완료">
</form:form>
</body>
</html>