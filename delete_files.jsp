

<%@page import="java.sql.*"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="common/connection.jsp" %>


<!DOCTYPE html>
   <%!
    Statement statement;
                                                                                            %>                                                                                      
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        String filename=request.getParameter("filename");
        String name=(String)session.getAttribute("userid");
        try
        {
		//fileName=getServletContext().getRealPath("/").replace("\\","/")+"/"+name+ "/"+filename;
          String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
                if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+name+"/";
              String filePath=uploadPath+filename;
               
             File f=new File(filePath);
        f.delete();
		String classfile=filename.substring(0,filename.indexOf("."))+".class";
		filePath=uploadPath+classfile;
				 File f1=new File(filePath);
				 if(f1.exists())
				 f1.delete();
       
       statement=con.createStatement();
       
      statement.executeUpdate("delete  from compiledfiles where file_name='"+filename+"'");
        }
     catch(Exception e)
     {
         
     }
        request.getRequestDispatcher("Files.jsp").forward(request, response);
       
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
