<%@ page isELIgnored="false"%>


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
   
  
    <h1 style="color:green;text-align:center">Deposit From page </h1>
<form action="pin_change_process">
  <%--     <p style="color:red;text-align:center"><form:errors path="*"/>  </p>  --%>
     <table align="center" bgcolor="cyan">
     <tr>
        <td>Enter new pin::       </td>
        <td><input type="text" name="pin"> </td>
     </tr>
     <tr>
        <td colspan="2"><input type="submit" value="submit">  </td>
     </tr>
   </table>
</form>