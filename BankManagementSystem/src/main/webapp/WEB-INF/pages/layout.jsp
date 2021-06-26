<%@page isELIgnored="true" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles" %>
<head>
  <title><tiles:insertAttribute name="title"  ignore="true"/>   </title>
</head>

<table width="100%" height="100%">
  <tr height="20%" bgcolor="#ECF0F1">
     <td colspan="2"><tiles:insertAttribute name="header"/>     </td>
  </tr>
  <tr height="70%">
     <td width="20%" bgcolor="#ECF0F1"><tiles:insertAttribute name="menu"/>       </td>
     <td width="80%"  bgcolor="#ECF0F1"><tiles:insertAttribute name="body"/>       </td>
  </tr>
  <tr  height="10%" bgcolor="#ECF0F1">
      <td colspan="2"><tiles:insertAttribute name="footer"/>  </td>
  </tr>
</table>
