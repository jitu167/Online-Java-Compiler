

 <%@page import="java.io.*"%>
  <%@page import="java.sql.*"%>
<%@page import="org.json.*"%>
<%@ include file="common/connection.jsp" %>

<%!
         PreparedStatement stmt2;
   String name="",error="";
    ResultSet rs2;
    
    int success=0;
        %>

<%
         String temp_name=request.getParameter("name");
        
           String path="";
           String st2="";
           String st1="";
           String code="",fileName="";
           int y=0;
           File f;
            
        if(session==null)
    {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        return;
    }
    %>
    
<%
 try
 
        {

 JSONArray arr=new JSONArray();
 JSONObject obj2=new JSONObject();
        
       stmt2=con.prepareStatement("select * from compiledfiles where user_name=(?)");
       stmt2.setString(1,temp_name);
       rs2=stmt2.executeQuery();
       while(rs2.next())
       {
       JSONObject obj=new JSONObject();
       String userfilename=rs2.getString(1);
        obj.put("name",userfilename);           
           arr.put(obj); 
       }
        rs2.close();
           stmt2.close();
          con.close();
         
        obj2.put("files",arr);
        out.println(obj2);
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