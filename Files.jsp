
<%@page import="java.sql.*"%>
<%@ include file="common/connection.jsp" %>

<!DOCTYPE html>
<%
        session=request.getSession(false);
         String name=(String)session.getAttribute("userid");
        if(session==null)
    {
        request.getRequestDispatcher("index.jsp").include(request, response);
        return;
    }
    %>
<html>
<head>
    <script type="text/javascript">
function validate()
    {
      var confirmMessage="Are you sure you want to remove the file !!!";

      if(confirm(confirmMessage)==false)
      {
          return false;
      }
    }



    </script>
	<meta charset="UTF-8">
	
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<!--[if IE]>
		<link rel="stylesheet" href="css/ie.css" type="text/css" charset="utf-8">
	<![endif]-->
</head>
<body>
	<div id="background">
		<div id="page">
			<div id="header">
				<ul id="navigation">
					<li class="selected">
						<a href="Home.jsp">Home</a>
					</li>
					<li>
						<a href="Editor.jsp">Editor</a>
					</li>
					<li>
						<a href="Files.jsp">Files</a>
					</li>
					<li>
						<a href="Logout.jsp">LogOut</a>
					</li>
					<li>
						<a href="Download.html">App Download</a>
					</li>
				</ul>
				
			</div>
			<div id="contents">
				
				<div class="header">
					
					<p>
						Your All saved files				</p>
				</div>
				<div id="featured">
					<h2>Programs</h2>
					<p>
											</p>
                                                                                        <%!
                                                                                             Statement statement;
    ResultSet rs;
    
                                                                                            %>
    <%
     try
        {
             
        
       statement=con.createStatement();
       
       rs=statement.executeQuery("select * from compiledfiles where user_name='"+name+"'");
    %>                                                                                        
							<table width="90%" border="1">
     <tr>
    <td>File Name</td>
    <td>User Nmae</td>
    <td>Status</td>
    <td>Date</td>
    <td>Edit</td>
    <td>Delete</td>
  </tr>
<%
       while(rs.next())
       {
%>
  <tr>
      <td><%= rs.getString(1) %>&nbsp;</td>
    <td><% out.print(rs.getString(2)); %>&nbsp;</td>
    <td><% 
    String k;
    if(rs.getInt(3)==0)
            {
             k="Saved not Compiled";                      
            }
    else
    {
        k="Saved and Compiled";
    }
    out.print(k); %>&nbsp;</td>
    <td><% out.print(rs.getString(4)); %>&nbsp;</td>
   
    <td><form action="edit_file.jsp" method="POST" >
             <input type="hidden" name="filename"  value="<%=rs.getString(1) %>" />
            <input type="submit" value="Edit"/>
        </form></td>
     <td>
        <form action="delete_files.jsp" method="POST" onSubmit="return validate()" >
             <input type="hidden" name="filename"  value="<%=rs.getString(1) %>" />
            <input type="submit" value="Delete"/>          
        </form>
    </td>
  </tr>
<%
 }
 rs.close();
     statement.close();
           con.close();

        }catch(Exception e)
        {
           out.println( e.getMessage());
        }
%>
</table>				</div>
			</div>
			<div id="footer">
				<div>
					<ul>
						
						<li>
							<h4>Links</h4>
							<ul class="navigation">
								<li>
									<a href="Home.jsp">Home</a>
								</li>
								<li>
									<a href="Editor.jsp">Editor</a>
								</li>
								<li>
									<a href="Files.jsp">Files</a>
                                                                </li>
								<li>
						<a href="Download.html">App Download</a>
					</li>
							</ul>
						</li>
						
					</ul>
					<p id="footnote">
						© Copyright Jitendra Kumar. All rights reserved.
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>