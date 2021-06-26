<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

 
 <h1 style="color:red;text-align:center">${errMsg} </h1>
    <h1 style="color:green;text-align:center">New  Account Application Form </h1>
<form:form  modelAttribute="loginUserDTO" action="signinProcess" >
  <%--     <p style="color:red;text-align:center"><form:errors path="*"/>  </p>  --%>
     <table align="center" bgcolor="cyan">
     <tr>
        <td>CardNo::       </td>
        <td><form:input path="cardNo"/> </td>
     </tr>
     <tr>
        <td>pin::       </td>
        <td><form:password path="pin"  /> </td>
     </tr>
    
     <tr>
        <td colspan="2"><input type="submit" value="submit">  </td>
     </tr>
   </table>
   
</form:form>