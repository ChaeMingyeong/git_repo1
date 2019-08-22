<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
  <table border="1" width="700">
     <tr>
       <td colspan="2" align="center" > 
           <jsp:include page="top.jsp"/>
       </td>
     </tr>
     <tr>
       <td width="300" height="300" valign="top"> 
          <jsp:include page="left.jsp"/>
       </td>
       <td> 
       <c:if test="${display==null}">
         <jsp:include page="body.jsp"/>
       </c:if>
        <c:if test="${display !=null }">
         <jsp:include page="${display}"/>
         </c:if>
       </td>       
     </tr>
     <tr>
       <td colspan="2" align="center">
         <jsp:include page="bottom.jsp"/>
      </td>
     </tr>
  </table>
</body>
</html>