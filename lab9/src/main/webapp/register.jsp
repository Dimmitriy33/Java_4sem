<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="register" method="post">
    <label>username
        <input type="text" placeholder="username" name="username">
    </label>
    <br>
    <label>password
        <input type="password" placeholder="password" name="password" id="password" onkeyup="check()">
    </label>
    <br>
    <label>confirm password
        <input type="password" placeholder="confirm password" id="confirmPassword" onkeyup="check()">
    </label>
    <br>
    <input type="submit" value="register" id="register" disabled>

    <script>
        const check = () => {
            const passwordInput = document.getElementById("password");
            const retypedPasswordInput = document.getElementById("confirmPassword");
            const registerButton = document.getElementById("register");

            registerButton.disabled = !(passwordInput.value && retypedPasswordInput.value && passwordInput.value === retypedPasswordInput.value);
        }
    </script>
</form>
</body>
</html>
