<%@page import="java.sql.*"%>
<%
 Class.forName("com.mysql.jdbc.Driver");
 Connection      con=DriverManager.getConnection("jdbc:mysql://localhost/java_compiler", "root", "");
%>