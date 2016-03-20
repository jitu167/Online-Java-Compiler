
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/connection.jsp" %>


<!DOCTYPE html>
<%!
    PreparedStatement stmt;
    ResultSet rs;
    String  d="fal";
%>
<%
String name,pass,id,email,phone;
            String gender;
            
            name=request.getParameter("registerVO.commonname");
            pass=request.getParameter("registerVO.password");
            id=request.getParameter("registerVO.userId");
            phone=request.getParameter("registerVO.officePhone");
            email=request.getParameter("registerVO.email");
            gender=request.getParameter("registerVO.sex");
            
            int x=0;
       try      
       {
         
           Statement stmt1;
           
           stmt1=con.createStatement();
           x=stmt1.executeUpdate("insert into newuser (`USERNAME`, `USERID`, `USERPASS`, `GENDER`, `EMAIL`, `PHONE`) values('"+name+"','"+id+"','"+pass+"','"+gender+"','"+email+"','"+phone+"')");     
           d=String.valueOf(x);
                  }
       
       catch(SQLException sqe)
       {
           d=sqe.getMessage();
       }
       if(x==1)
       {
	           session=request.getSession();
	          session.setAttribute("user",name);
               session.setAttribute("phone",phone);
               session.setAttribute("email",email);
               session.setAttribute("userid",id);
               session.setAttribute("sex",gender);
           request.getRequestDispatcher("Home.jsp").forward(request, response);
           
           return;
       }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% out.println(d+" ---"+name+gender+id+pass+email); %>!</h1>
    </body>
</html>
