<%-- 
    Document   : androidlogin
    Created on : 3 Apr, 2015, 3:06:33 AM
    Author     : KUSUM DEVI
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/connection.jsp" %>


<!DOCTYPE html>
<html>
    
    <body>
         <%!
                  
    PreparedStatement stmt;
    ResultSet rs;
    String error,name;
    int res=0;
     %>
      <%
                     String user=request.getParameter("uname"); 
                      String pass=request.getParameter("pass"); 
               JSONObject obj = new JSONObject();  
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
           {    
               name=rs.getString(1);
                              res=1;
               obj.put("name", "success");
               //request.getRequestDispatcher("Home.jsp").forward(request, response);
                error=temp_user_name;
                //out.print("<p>"+error+"</p>");
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
       if(res==0)
       {
           obj.put("name","failed");
       
       }
        out.print(obj);
        %>
                
       
    </body>
</html>