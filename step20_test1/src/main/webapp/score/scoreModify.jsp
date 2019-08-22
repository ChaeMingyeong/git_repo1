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
			alert("수정성공");
			location.href="scoreView.do?pg=${pg}&studNo=${studNo}";  //학번기준으로 오름차순하면 pg=1로가면 안보일 수 있음
		}else if(${result} ==0){
			alert("DB 수정실패");
			location.href ="scoreModifyForm.do?pg=${pg}&studNo=${studNo}";	
		}else if(${result}<0){
			alert("숫자를 입력해주세요");
			location.href ="scoreModifyForm.do?pg=${pg}&studNo=${studNo}";	
		}
    }	
</script>
</head>
<body>
	<c:if test="${result>0}">
   작성하신 성적을 수정하였습니다. 
</c:if>
<c:if test="${result <=0}">
   작성하신 성적을 수정하지 못하였습니다.
</c:if>



</body>
</html>