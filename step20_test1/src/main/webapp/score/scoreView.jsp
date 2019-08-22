<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 상세보기</title>

</head>
<body>
<table style="border: 2px solid #DA8A8A">
	<tr bgcolor="#F6C1C1">
		<td id="title" colspan="6" style="text-align: center"><font size="5">${scoreVO.name}</font></td>
	</tr>
	<tr bgcolor="#FAE6E6" align="center">
	    <th width="100">학번</th>
	    <th width="100">국어</th>
	    <th width="100">영어</th>
	    <th width="100">수학</th>
	    <th width="100">총점</th>
	    <th width="100">평균</th>
	</tr>
	
	<tr bgcolor="#FAE6E6" align="center">
		<td>${scoreVO.studNo}</td>
		<td>${scoreVO.kor}</td>
		<td>${scoreVO.eng}</td>
		<td>${scoreVO.mat}</td>
		<td>${scoreVO.tot}</td>
		<td>${scoreVO.avg}</td>
	</tr>

</table>
<input type="button" value="목록" onclick="location.href='scoreList.do?pg=${pg}'">
<input type="button" value="글수정" onclick="location.href='scoreModifyForm.do?pg=${pg}&studNo=${scoreVO.studNo}'">
<input type="button" value="글삭제" 
	onclick="location.href='scoreDelete.do?pg=${pg}&studNo=${scoreVO.studNo}'">

</body>
</html>