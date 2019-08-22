<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적목록</title>
<style type="text/css">
#currentPaging {color: red; text-decoration: underline;}
#paging {color: blue; text-decoration: none;}
.scoreList{
  margin: 0 auto;
  width: 450px;
}
.scoreList th{
  width: 50px;
}
#studNo:link{color: black; text-decoration: none;}
#studNo:visited{color: black; text-decoration: none;}
#studNo:achieve{color: black; text-decoration: none;}
#studNo:hover{color: green; text-decoration: none;}
input{
  margin-left: 395px;
}
</style>

</head>
<body>
<table style="border: 2px solid #DA8A8A" class="scoreList">
	<tr bgcolor="#F6C1C1">
		<th width="70">학번</th>
		<th width="150">이름</th>
		<th width="150">국어</th>
		<th width="150">영어</th>
		<th width="150">수학</th>
		<th width="70">총점</th>
		<th width="70">평균</th>
		<th width="200">날짜</th>
	</tr>
<c:forEach var="scoreVO" items="${list}">
	<tr align="center" bgcolor="#FAE6E6">
		<td><a id="studNo" href="scoreView.do?studNo=${scoreVO.studNo}&pg=${pg}">${scoreVO.studNo}</a></td>
		<td>${scoreVO.name}</td>
		
		<td>${scoreVO.kor}</td>
		<td>${scoreVO.eng}</td>
		<td>${scoreVO.mat}</td>
		<td>${scoreVO.tot}</td>
		<td>${scoreVO.avg}</td>
		<td>${scoreVO.logtime}</td>
	</tr>
</c:forEach>

	<tr bgcolor="#F6C1C1">
		<td colspan="8" align="center">
	<c:if test="${startPage > 3}">
		[<a id="paging" href="scoreList.do?pg=${startPage-1}">이전</a>]
	</c:if>	
	
	<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
		<c:if test="${pg == i}">
			[<a id="currentPaging" href="scoreList.do?pg=${i}">${i}</a>]
		</c:if>
		
		<c:if test="${pg != i}">
			[<a id="paging" href="scoreList.do?pg=${i}">${i}</a>]
		</c:if>
	</c:forEach>	
	
	<c:if test="${endPage < totalP}">
		[<a id="paging" href="scoreList.do?pg=${endPage+1}">다음</a>]
	</c:if>	
		</td>
	</tr>
</table>
<input type="button" value="성적입력" onclick="location.href='scoreWriteForm.do'">

</body>
</html>