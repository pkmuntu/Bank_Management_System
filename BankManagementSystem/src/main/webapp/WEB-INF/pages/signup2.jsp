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
   
   
   <h3 style="color:green;text-align:center">New account application form </h3>
    <h1 style="color:green;text-align:center">Addition Details Form for ${accNo} </h1>
<form:form  action="signup2" modelAttribute="accountDetailsDTO2" >
  <%--     <p style="color:red;text-align:center"><form:errors path="*"/>  </p>  --%>
     <table align="center" bgcolor="cyan">
     <tr>
        <td>AccountNo::       </td>
        <td><form:input path="accountNo" readonly="true"/> </td>
     </tr>
     <tr>
     <td>Religion</td>
     <td>
     <form:select path="religion">  
        <form:option value="Hindu" label="Hindu"/>  
        <form:option value="Muslim" label="Muslim"/>  
        <form:option value="Sikh" label="Meerut"/>  
        <form:option value="Christion" label="Christion"/>  
        <form:option value="Other" label="Other"/>  
        </form:select>  
     </td>
     </tr>
      <tr>
     <td>Category</td>
     <td>
     <form:select path="category">  
        <form:option value="Genral" label="Genral"/>  
        <form:option value="OBC" label="OBC"/>  
        <form:option value="SC" label="SC"/>  
        <form:option value="ST" label="ST"/>  
        <form:option value="Other" label="Other"/>  
        </form:select>  
     </td>
     </tr>
      <tr>
        <td>Income::       </td>
        <td><form:input  path="income"/></td>
     </tr>
      <tr>
     <td>Education Qulification</td>
     <td>
     <form:select path="education">  
        <form:option value="Graduate" label="Graduate"/>  
        <form:option value="Non-Graduate" label="Non-Graduate"/>  
        <form:option value="Other" label="Other"/>  
        </form:select>  
     </td>
     </tr>
       <tr>
     <td>Occupation</td>
     <td>
     <form:select path="occupation">  
        <form:option value="Salaried" label="Salaried"/>  
        <form:option value="Self_Employee" label="self_Employee"/>  
        <form:option value="Business" label="Business"/>  
        <form:option value="Student" label="Student"/>  
        <form:option value="Other" label="Other"/>  
        </form:select>  
     </td>
     </tr>
     <tr>
        <td>Pan::       </td>
        <td><form:input  path="pan"/> </td>
     </tr>
      <tr>
        <td>Aadhar::       </td>
        <td><form:input  path="aadhar"/></td>
     </tr>
     <tr>
     <td>Senior Scitizen::   </td>
     <td>
     Yes<form:radiobutton path="scitizen" value="Yes"/>
     No<form:radiobutton path="scitizen" value="No"/>
     </td>
     </tr>
       <tr>
     <td> Existing Eaccount::   </td>
     <td>
     Yes <form:radiobutton path="eaccount" value="Yes"/>
     No<form:radiobutton path="eaccount" value="No"/>
     </td>
     </tr>
      <tr>
     <td>Account Type::   </td>
     <td>
     Saving Account<form:radiobutton path="accountType" value="Saving Account"/>
     Current Account<form:radiobutton path="accountType" value="Current Account"/>
     Fixed Deposit Account<form:radiobutton path="accountType" value="Fixed Deposit Account"/>
     Recurring Deposit Account<form:radiobutton path="accountType" value="Recurring Deposit Account"/>
     </td>
     </tr>
     <tr>
        <td colspan="2"><input type="submit" value="submit">  </td>
     </tr>
   </table>
   <form:hidden  path="vflag"  />
</form:form>