<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 수정</title>
<style type="text/css">
   .modifyForm{
     width: 200px;
     margin: 0 auto;
    
     
   }
   .modifyForm th{
      background: mistyrose;
   }
   fieldset {
	width: 250px;
	margin-left: 350px;
	padding-left: 10px;
	}
	
	fieldset >legend{
	 
	   font-weight: bold;  
	}
	
	
	
</style>
<script type="text/javascript" src="../script/scoreScript.js"></script>
</head>
<body>
  <form action="scoreModify.do" name="scoreModifyForm" method="post">
     <input type="hidden" name="pg" value="${pg}">
     <input type="hidden" name="studNo" value="${scoreVO.studNo}">
     <!-- input태그에 disabled속성을 주기 때문에 hidden으로 sutdNo데이터를 보냄  
     name은 modify.do넘어간이후로 안쓸거기 때문에 굳이 hidden으로 안보내줘도 됨 -->
   <fieldset>
   <legend>성적수정</legend>
   <table class="modifyForm">
     <tr>
       <th>학번</th>
       <td><input type="text" name="studNo" value="${scoreVO.studNo}" disabled="disabled"></td>
     </tr>
     <tr>
       <th>이름</th>
       <td><input type="text" name="name" value="${scoreVO.name}" disabled="disabled"></td>
     </tr>
     <tr>
       <th>국어</th>
       <td><input type="text" name="kor" value="${scoreVO.kor}"></td>
     </tr>
     <tr>
       <th>영어</th>
       <td><input type="text" name="eng" value="${scoreVO.eng}"></td>
     </tr>
     <tr>
       <th>수학</th>
       <td><input type="text" name="mat" value="${scoreVO.mat}"></td>
     </tr>
     <tr>
       <td colspan="2">
        <input type="button" value="수정완료" onclick="modifyScore()">
        <input type="reset" value="다시쓰기">
        <input type="button" value="성적목록" onclick="location.href='scoreList.do?pg=${pg}'">
       </td>
     </tr>
   </table>   
    </fieldset>
   </form>
</body>
</html>