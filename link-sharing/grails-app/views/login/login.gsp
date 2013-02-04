<%--
  Created by IntelliJ IDEA.
  User: intelligrape
  Date: 30/1/13
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
       <meta name="layout" content="main">
</head>
<body>       <g:form controller="User" action="loginHandler">
             USERNAME: <input type="text" name="username" id="text1"/>  <br/>
             PASSWORD: <input type="password" name="password" id="text1"/>      <br/><br/>
            <g:submitButton name="submit" value="submit"/></g:form>
</body>
</html>