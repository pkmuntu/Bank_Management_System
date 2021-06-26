<%@ page  isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color: green; text-align: center">Your last 5 transaction are----</h1>
<br>

<c:choose>
  <c:when test="${!empty listDTO}">
    <table  border="1" bgcolor="cyan" align="center">
       <tr>
          <th>Transaction Id</th><th>Transaction Date</th><th>Transaction Mode</th><th>Amount</th>  
       </tr>
       <c:forEach  var="dto" items="${listDTO}">
          <tr>
              <td>${dto.transactionId}  </td>
              <td>${dto.date}  </td>
              <td>${dto.mode}  </td>
              <td>${dto.amount}  </td>
          </tr>
       </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
         <h1 style="color:red;text-align:center">No Records found </h1>
  </c:otherwise>
</c:choose>
<br>
<h4><a href="main_menu">HOME</a> </h4>
   