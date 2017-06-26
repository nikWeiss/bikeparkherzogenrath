<%-- 
    Document   : login
    Created on : 16.10.2016, 00:38:45
    Author     : Niklas
--%>

<div class="container center-block card">
    <form name='f' action="login" method='POST'>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<img id="profile-img" class="profile-img-card center-block" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	<input type='text' name='username' class="form-control" placeholder="Benutzername" required autofocus>
	<input type='password' name='password' class="form-control" placeholder="Passwort" required>
	<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" name="submit">Anmelden</button>
    </form>
</ul>
