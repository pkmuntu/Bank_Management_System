<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<script language="JavaScript"  src="<c:url value="/myresources/js/validation.js"/>">
  </script>
  
  <noscript >
     <h1 style="color:red;text-align:center"> Enable Java script </h1>
  </noscript> 
  
     <style>
       span{
          color:blue;
       }
   </style>
   
  
    <h1 style="color:green;text-align:center">Money Transfer From page </h1>
<form:form action="transfer_money_process" modelAttribute="transferDTO">
  <%--     <p style="color:red;text-align:center"><form:errors path="*"/>  </p>  --%>
     <table align="center" bgcolor="cyan">
     <tr>
        <td>Enter Target amountNo ::       </td>
        <td><form:input path="TargetAccountNo"/> </td>
     </tr>
     <tr>
        <td>Enter amount::       </td>
        <td><form:input path="amount"/> </td>
     </tr>
     <tr>
        <td colspan="2"><input type="submit" value="submit">  </td>
     </tr>
   </table>
   <form:hidden  path="vflag"  />
</form:form>