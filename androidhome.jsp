<%@page import ="java.sql.*"%>
<%@page import ="org.json.*"%>
<%@ include file="common/connection.jsp" %>

<%!
                  
    PreparedStatement stmt;
    ResultSet rs;
    String error;
     %>
     
     
                <%
                     String user=request.getParameter("name"); 
                      JSONObject obj=new JSONObject();
        try
        {
       
       stmt=con.prepareStatement("select * from newuser where userid=(?)");
       stmt.setString(1, user);
       rs=stmt.executeQuery();
       while(rs.next())
       {
           String temp_user_name=rs.getString(2);
           if(temp_user_name.compareTo(user)==0)
           {    
                                      obj.put("name",rs.getString(1));
                                      obj.put("userid",rs.getString(2));
                                      obj.put("gender",rs.getString(4));
                                      obj.put("email",rs.getString(5));
                                       obj.put("phone",rs.getString(6));

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
        out.println(obj); 
                %>