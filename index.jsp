
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="common/connection.jsp" %>


<!DOCTYPE html>
<head>
	<meta charset="utf-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<!--[if IE 7]>
		<link href="css/ie7.css" rel="stylesheet" type="text/css">
	<![endif]-->
</head>
<body>
    <form action="index.jsp" method="post">
	
	<div id="page">
		<div id="header">
			<p><a href=""><img class="logo" src="images/logo.png" width="177" height="104" alt=""></a></p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
            </div>
                
    
            <div>
               
      
             <div style="float:left; margin-left:10%"></div>
            <div style="float:left; margin-left:40%">
            Sign In
             <br/>
             <input type="text" placeholder="Username" name="uname" size="20"/>
            <input type="password" placeholder="Pas" name="pass" size="20"/>
            <br>
            <input type="submit" value="Login"/>
           <a href="Create a new account.htm">Sign Up</a>
		</div>
            
        </div>
    
    
               
    </form>	
</body>
</html>


                 <%!
                  
    PreparedStatement stmt;
    ResultSet rs;
    String error,name;
     %>
    
                <%
                     String user=request.getParameter("uname"); 
                      String pass=request.getParameter("pass"); 
        try
        {
      
       stmt=con.prepareStatement("select * from newuser where userid=(?) and userpass=(?)");
       stmt.setString(1, user);
       stmt.setString(2, pass);
       rs=stmt.executeQuery();
       while(rs.next())
       {
           String temp_user_name=rs.getString(2);
           String temp_user_pass=rs.getString("userpass");
           if(temp_user_name.compareTo(user)==0 && temp_user_pass.compareTo(pass)==0)
           {   session=request.getSession();
               name=rs.getString(1);
               session.setAttribute("user",rs.getString(1));
               session.setAttribute("phone",rs.getString(6));
               session.setAttribute("email",rs.getString(5));
               session.setAttribute("userid",rs.getString(2));
               session.setAttribute("sex",rs.getString(4));
               session.setAttribute("photo",rs.getString("photo"));
               request.getRequestDispatcher("Home.jsp").forward(request, response);
                error+=temp_user_name;
                out.print("<p>"+error+"</p>");
               break;
              
           }
           }
		   rs.close();
		   stmt.close();
		   con.close();
        }        
        catch(SQLException e)
        {
            error=e.getMessage();
             out.print("<p>"+error+"</p>");
        }
             catch(Exception e)
        {
            error +=e.getMessage();
            out.print("<p>"+error+"</p>");
        }    
                %>
      