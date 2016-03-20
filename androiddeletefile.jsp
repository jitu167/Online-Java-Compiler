<%@page import="org.json.JSONObject"%>
<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@ include file="common/connection.jsp" %>


<%!
Statement statement;
%>
<%
String temp_name=request.getParameter("name");
String filename=request.getParameter("filename");
        String fileName="";
        int success=0;
        try
        {
		String uploadPath = getServletContext().getRealPath("/").replace("\\", "/");
         if(!uploadPath.endsWith("/"))
                    uploadPath = uploadPath+"/";
               uploadPath = uploadPath+"files/"+temp_name+"/"+filename;
          
             File f=new File(uploadPath);
        f.delete();
		/*String classfile=filename.substring(0,filename.indexOf("."))+".class";
		fileName=getServletContext().getRealPath("/").replace("\\","/")+"/"+temp_name+
                 "/"+classfile;
				 File f1=new File(fileName);
				 if(f1.exists())
				 f1.delete();*/
       
       statement=con.createStatement();
       
      statement.executeUpdate("delete  from compiledfiles where file_name='"+filename+"'");
	  statement.close();
	  con.close();
      success=1;
        }
     catch(Exception e)
     {
      out.println(e.getMessage());
     }
        JSONObject obj=new JSONObject();
        if(success==0)
        obj.put("res","fail");
        else
            obj.put("res","Success");
        out.println(obj);
%>