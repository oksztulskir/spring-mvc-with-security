<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../static/css/style.css" />
    <link rel="stylesheet" type="text/css"
          href="/resources/templates/css/style.css" />
</head>
<body>
    <h2>Updating user: ${user.login}</h2>

    <form class="form-horizontal" action="/user?id=${user.id}" method="post">
        <div class="form-group">
            <label for="inputFirstName" class="col-sm-2 control-label">First name</label>
            <div class="col-sm-2">
                <@spring.formInput "user.firstName"
                    "class='form-control' id='firstName' placeholder='First name'"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputLastName" class="col-sm-2 control-label">Last name</label>
            <div class="col-sm-2">
                <@spring.formInput "user.lastName"
                    "class='form-control' id='lastName' placeholder='Last name'"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-2">
                <@spring.formInput "user.emailAddress"
                    "class='form-control' id='emailAddress' placeholder='Email address'"/>
            </div>
        </div>
        <#--<div class="form-group">-->
            <#--<div class="col-sm-4">-->
                <#--<@spring.formHiddenInput "user.id" />-->
            <#--</div>-->
        <#--</div>-->
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-4">
                <button type="submit" class="btn btn-default">Update user</button>
            </div>
        </div>
    </form>

</body>
