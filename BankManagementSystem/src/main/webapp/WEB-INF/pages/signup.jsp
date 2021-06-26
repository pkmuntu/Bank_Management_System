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
   
  
    <h1 style="color:green;text-align:center">New  Account Application Form </h1>
<form:form  modelAttribute="accountDetailsDTO"  >
  <%--     <p style="color:red;text-align:center"><form:errors path="*"/>  </p>  --%>
     <table align="center" bgcolor="cyan">
     <tr>
        <td>First Name::       </td>
        <td><form:input path="fName"/> </td>
     </tr>
     <tr>
        <td>Middle Name::       </td>
        <td><form:input path="middleName"/> </td>
     </tr>
     <tr>
        <td>Last Name::       </td>
        <td><form:input path="lName"/> </td>
     </tr>
		<tr>
			<td>Date of birth::</td>
			<td><form:input type="date" value="2021-06-20" path="dob" /></td>
		</tr>
		<tr>
     <td>Gender::   </td>
     <td>
     Male <form:radiobutton path="gender" value="M"/>
     Female<form:radiobutton path="gender" value="F"/>
     </td>
     </tr>
     <tr>
        <td>Email::       </td>
        <td><form:input  path="email"/></td>
     </tr>
     <tr>
     <td>Marital status::   </td>
     <td>
     Married <form:radiobutton path="marital" value="Married"/>
     Unmarried<form:radiobutton path="marital" value="Unmarried"/>
     </td>
     </tr>
     <tr>
        <td>Address::       </td>
        <td><form:input  path="addr"/></td>
     </tr>
     <tr>
        <td>City::       </td>
        <td><form:input  path="city"/></td>
     </tr>
     <tr>
        <td>PinCode::       </td>
        <td><form:input  path="pinCode"/> </td>
     </tr>
     <tr>
        <td>State::       </td>
        <td><form:input  path="state"/></td>
     </tr>
     <tr>
        <td colspan="2"><input type="submit" value="submit">  </td>
     </tr>
   </table>
   <form:hidden  path="vflag"  />
</form:form>