<#macro url path name="WP">
  <a href="${path}">
      ${name}
  </a>
</#macro>


<#macro topMenu>
    <ul class="nav nav-pills">
        <li role="presentation"><a href="/">Home</a></li>
        <li role="presentation"><a href="/users">Users</a></li>
    </ul>
</#macro>

<#macro message msg>
    <div class="alert alert-info" role="alert">
        ${msg}
    </div>
</#macro>
