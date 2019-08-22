<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    window.onload = function(){  //onload코드는 모든 html코드를 로딩 후에 마지막에 실행
		if(${result}>0) {
			alert("저장성공");
			location.href="scoreList.do?pg=1";  //학번기준으로 오름차순하면 pg=1로가면 안보일 수 있음
		}else if(${result} ==0){
			alert("DB 저장실패");
			location.href ="scoreWriteForm.do";	
		}else if(${result}<0){
			alert("숫자를 입력해주세요");
			location.href ="scoreWriteForm.do";	
		}
    }	
</script>
</head>
<body>
	<c:if test="${result>0}">
   작성하신 성적을 저장하였습니다. 
</c:if>
<c:if test="${result <=0}">
   작성하신 성적을 저장하지 못하였습니다.
</c:if>



</body>
</html>