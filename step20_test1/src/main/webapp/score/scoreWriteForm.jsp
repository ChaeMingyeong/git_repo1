<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
<style type="text/css">
  table{
     width: 450px;
     margin: 0 auto;
      
   }
   table th{
    background-color: mistyrose; 
   }
  
   
   fieldset {
	width: 250px;
	padding-left: 10px;
	}
	
	fieldset >legend{
	 
	   font-weight: bold;  
	}
	
	
	
</style>
<script type="text/javascript" src="../script/scoreScript.js"></script>
</head>
<body>
  <form action="scoreWrite.do" name="scoreWriteForm" method="post">
   <fieldset>
   <legend>성적입력</legend>
   <table class="writeForm">
     <tr>
       <th>학번</th>
       <td><input type="text" name="studNo"></td>
     </tr>
     <tr>
       <th>이름</th>
       <td><input type="text" name="name"></td>
     </tr>
     <tr>
       <th>국어</th>
       <td><input type="text" name="kor"></td>
     </tr>
     <tr>
       <th>영어</th>
       <td><input type="text" name="eng"></td>
     </tr>
     <tr>
       <th>수학</th>
       <td><input type="text" name="mat"></td>
     </tr>
     <tr>
       <td colspan="2">
        <input type="button" value="등록" onclick="inputScore()">
        <input type="reset" value="다시쓰기">
        <input type="button" value="성적목록" onclick="location.href='../score/scoreList.do?pg=1'">
       </td>
     </tr>
   </table>   
    </fieldset>
   </form>
</body>
</html>