<%@ page isELIgnored="false"%>
<br>
<h1 style="color: green; text-align: center">Your Account is Open
	successfully</h1>
	
	

<table align="center" bgcolor="cyan" border="1">
	<tr>
		<td>
			<h3>Account Number::</h3>
		</td>
		<td>
			<h3>${cdto.getAccountNo()}</h3>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Account Type::</h3>
		</td>
		<td>
			<h3>${cdto.getAccountType()}</h3>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Card Number::</h3>
		</td>
		<td>
			<h3>${cdto.getCardNo()}</h3> <br>
		</td>
	</tr>
	<tr>
		<td>
			<h3>Pin::</h3><br>
		</td>
		<td>
			<h3>${cdto.getPin()}</h3> <br>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<h3 style="color: blue; text-align: center">
				<a href="welcome">home</a>
			</h3>
		</td>
	</tr>
</table>