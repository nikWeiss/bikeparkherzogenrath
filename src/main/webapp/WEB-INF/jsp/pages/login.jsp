<%-- 
    Document   : login
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<h1>Login</h1>
<form name='f' action="login" method='POST'>
    <table>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
	</tr>
	<tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
	</tr>
	<tr>
            <td><input name="submit" type="submit" value="submit" /></td>
	</tr>
    </table>
</form>