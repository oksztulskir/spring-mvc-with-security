<#import "macros.ftl" as utils>

<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/static/css/style.css" />
</head>
<body>

<h2>List of users</h2>

<#if message??>
    <@utils.message msg="${message}" />
</#if>

<@utils.url "/logout" "Logout"/>

<table class="table">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Login</th>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
            <th scope="col">Email address</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
        <#list users as user>
            <tr>
                <td>${user.login}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.emailAddress}</td>
                <td>
                    <a href="/user/${user.id}?action=update">
                        update
                    </a>
                </td>
                <td>
                    <a href="/deleteUser/${user.id}">
                        delete
                    </a>
                </td>
            </tr>
        </#list>
    </tbody>
</table>
</body>

</html>
