<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<head>
<style>

th, td {
  padding: 10px;
}
</style>
</head>

<h1 style="color: green; text-align: center">Please select your Choice
</h1>

<table align="center">
  <tr>
    <th><a href="deposit"><img src="<c:url  value="/myresources/images/deposit.png"/>"/></a> </th>
    <th><a href="cash_withdrawal"><img src="<c:url  value="/myresources/images/cash_withdrawal.png"/>"/></a> </th>
  </tr>
  <tr>
    <th><a href="balance_enquiry"><img src="<c:url  value="/myresources/images/balance_enquiry.png"/>"/></a> </th>
    <th><a href="transfer_money"><img src="<c:url  value="/myresources/images/money_transfer.png"/>"/></a> </th>
  </tr>
   <tr>
    <th><a href="pin_change"><img src="<c:url  value="/myresources/images/pin_change.png"/>"/></a> </th>
    <th><a href="mini_statement"><img src="<c:url  value="/myresources/images/mini_statement.png"/>"/></a> </th>
  </tr>
   <tr>
    <th colspan="2"><a href="welcome"><img src="<c:url  value="/myresources/images/logout.png"/>"/></a> </th>
  </tr>
</table>
