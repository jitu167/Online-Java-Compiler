<%@ include file="common/connection.jsp" %>
<%!
    PreparedStatement stmt;
    ResultSet rs;
    String  d="fal";
%>
<%
String image=request.getParameter("image");
String userid = (String)session.getAttribute("userid");
Statement stmt1=con.createStatement();
int x=stmt1.executeUpdate("update newuser set photo ='"+image+"' where userid='"+userid+"'");   
session.setAttribute("photo",image);
response.sendRedirect("Home.jsp");
%>

