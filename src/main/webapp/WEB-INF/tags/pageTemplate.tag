<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="titulo" required="true"%>
<%@ attribute name="bodyClass" required="false"%>

<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>World Organize</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="resources/css/ol.css">
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="resources/css/index.css">
    </head>
    <body class="${bodyClass}">
        <jsp:doBody />
        <script src="resources/js/font-awesome-all.js"></script>
        <script src="resources/js/jquery-3.3.1.min.js"></script>
        <script src="resources/js/ol.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script src="resources/js/index.js"></script>
    </body>
</html>
