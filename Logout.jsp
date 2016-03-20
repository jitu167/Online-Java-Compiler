<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Online Compiler</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
</head>
<body>
    <% String logout;
        DateFormat form=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
       Date dat=new Date();
       logout=form.format(dat);
        session=request.getSession(false);
    if(session!=null)
    {
        session.invalidate();
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
         return;
    }
    
    %>
</body>
</html>